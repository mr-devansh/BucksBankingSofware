import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.*;

import com.bucks.banking.repositories.AccountRepository;
import com.bucks.banking.repositories.JdbcAccountRepositoryImpl;
import com.bucks.banking.repositories.JdbcRewardRepositoryImpl;
import com.bucks.banking.repositories.JdbcTransactionRepositoryImpl;
import com.bucks.banking.repositories.RewardRepository;
import com.bucks.banking.repositories.TransactionRepository;
import com.bucks.banking.services.BankService;
import com.bucks.banking.services.BankServiceImpl;

@Configuration
public class BankAppConfiguration {
	@Bean
	public BasicDataSource createDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername("postgres");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/BucksBanking");
		return dataSource;
	}
	@Bean
	public AccountRepository createAccountRepositry(BasicDataSource dataSource) {
		return new JdbcAccountRepositoryImpl(dataSource);
	}
	@Bean
	public RewardRepository createRewardRepositry(BasicDataSource dataSource) {
		return new JdbcRewardRepositoryImpl(dataSource);
	}
	@Bean
	public TransactionRepository createTransactionRepositry(BasicDataSource dataSource) {
		return new JdbcTransactionRepositoryImpl(dataSource);
	}
//	@Bean
//	public BankService createBankService(BasicDataSource dataSource) {
//		return new BankServiceImpl(createDataSource(),createAccountRepositry(dataSource), createTransactionRepositry(dataSource));
//	}
}
