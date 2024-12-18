package com.bucks.banking.repositories;
import java.sql.*;
import java.util.*;
import java.util.Date;

import org.apache.commons.dbcp2.BasicDataSource;

import com.bucks.banking.model.TransactionDetail;
import com.bucks.banking.model.TransactionType;
import com.bucks.banking.services.DBUtil;

public class JdbcTransactionRepositoryImpl implements TransactionRepository {
		
	BasicDataSource dataSource;
	public JdbcTransactionRepositoryImpl(BasicDataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.dataSource = dataSource;
	}

	public Long addTransaction(TransactionDetail transactionDetail, Connection connection) {
	    // SQL Query for inserting a new transaction
	    String insertQuery = "INSERT INTO transactiondetail (accountnumber, transactiondate, amount, txtype) VALUES (?, ?, ?, ?) RETURNING transactionid";
	    PreparedStatement insertStmt = null;
	    ResultSet resultSet = null;
	    Long transactionId = null;

	    try {
	        // Use the provided connection for the transaction
	        insertStmt = connection.prepareStatement(insertQuery);
	        insertStmt.setLong(1, transactionDetail.getAccountNumber());
	        insertStmt.setTimestamp(2, new Timestamp(transactionDetail.getTransactionDate().getTime()));
	        insertStmt.setInt(3, transactionDetail.getAmount());
	        insertStmt.setString(4, transactionDetail.getTxType().name());  // Assuming txType is an enum

	        // Execute insert and retrieve the generated transaction ID
	        resultSet = insertStmt.executeQuery();
	        if (resultSet.next()) {
	            transactionId = resultSet.getLong("transactionid");
	        }
	        System.out.println("Transaction added successfully with ID: " + transactionId);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    

	    return transactionId;
	}

    public List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) {
        // SQL Query for fetching all transactions for an account
        String query = "SELECT transactionid, accountnumber, transactiondate, amount, txtype FROM transactiondetail WHERE accountnumber = ?";
        Connection connect = null;
        PreparedStatement checkStmt = null;
        ResultSet resultSet = null;
        List<TransactionDetail> transactionDetails = new ArrayList<TransactionDetail>();

        try {
            // Get connection
            connect = dataSource.getConnection();
            checkStmt = connect.prepareStatement(query);
            checkStmt.setLong(1, accountNumber);
            resultSet = checkStmt.executeQuery();

               // Process result set
            while (resultSet.next()) {
                long transactionId = resultSet.getLong("transactionid");
                Date transactionDate = resultSet.getTimestamp("transactiondate");
                int amount = resultSet.getInt("amount");
                String txTypeStr = resultSet.getString("txtype");
                TransactionType txType = TransactionType.valueOf(txTypeStr);  // Assuming TransactionType is an enum

                TransactionDetail transactionDetail = new TransactionDetail(transactionId, accountNumber, transactionDate, amount, txType);
                transactionDetails.add(transactionDetail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return transactionDetails;
    }
}
