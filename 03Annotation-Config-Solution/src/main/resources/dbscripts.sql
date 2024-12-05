-- Drop existing tables if they exist
DROP TABLE IF EXISTS transactiondetail CASCADE;
DROP TABLE IF EXISTS beneficiaries CASCADE;
DROP TABLE IF EXISTS reward CASCADE;
DROP TABLE IF EXISTS account CASCADE;

-- Create the 'account' table
CREATE TABLE account (
    accountNumber BIGSERIAL PRIMARY KEY,
    name VARCHAR(50),
    isactive BOOLEAN,
    city VARCHAR(50),
    country VARCHAR(50),
    balance INTEGER,
    emailaddress VARCHAR(50)
);

-- Create the 'beneficiaries' table
CREATE TABLE beneficiaries (
    ssn BIGSERIAL PRIMARY KEY,
    name VARCHAR(50),
    accountnumber BIGINT NOT NULL,
    CONSTRAINT fk_account FOREIGN KEY (accountnumber) REFERENCES account(accountNumber)
);

-- Create the 'reward' table
CREATE TABLE reward (
    rewardConfirmationNumber BIGSERIAL PRIMARY KEY,
    rewardAmount INTEGER,
    accountNumber BIGINT,
    CONSTRAINT fk_account FOREIGN KEY (accountNumber) REFERENCES account(accountNumber)
);

-- Create the 'transactiondetail' table
CREATE TABLE transactiondetail (
    transactionId BIGSERIAL PRIMARY KEY,
    accountNumber BIGINT,
    transactionDate DATE,
    amount INTEGER,
    txtype VARCHAR(10),
    CONSTRAINT fk_account FOREIGN KEY (accountNumber) REFERENCES account(accountNumber)
);

-- Insert sample data into the 'account' table
INSERT INTO account(name, isactive, city, country, balance, emailaddress) 
VALUES 
    ('shiva', TRUE, 'Bangalore', 'India', 10000, 'sivaprasad.valluru@gmail.com'),
    ('Prasad', TRUE, 'Hyderabad', 'India', 20000, 'siva@gmail.com');
