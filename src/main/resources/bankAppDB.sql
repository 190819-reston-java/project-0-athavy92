CREATE SCHEMA customer_account;

CREATE TABLE customer_account.bankAcctInfo(
id SERIAL NOT NULL UNIQUE,
firstname VARCHAR(100),
username VARCHAR(100) UNIQUE,
user_pass VARCHAR(100),
pinNumber NUMERIC(4),
balance NUMERIC(10,2) NOT NULL DEFAULT(0.00)
);

--DROP TABLE customer_account.bankacctinfo;

INSERT INTO customer_account.bankacctinfo (username, firstname, user_pass, pinnumber) VALUES
('ReadyPlayerOne', 'Sam', 'jumpman23', '7777');

SELECT * FROM customer_account.bankacctinfo;

UPDATE customer_account.bankacctinfo SET first_name = 'Tye' WHERE username = 'ReadyPlayerOne';
UPDATE customer_account.bankacctinfo SET pin_number = 3303 WHERE first_name = 'Nick';

ALTER TABLE customer_account.bankacctinfo
	RENAME COLUMN pinnumber TO pin_number;

ALTER TABLE customer_account.bankacctinfo
	DROP COLUMN balance;

ALTER TABLE customer_account.bankacctinfo
	ADD PRIMARY KEY (id);

CREATE TABLE transaction_history(
transaction_id SERIAL UNIQUE,
description VARCHAR(100) NULL,
time_of_transaction TIME WITHOUT TIME ZONE NULL
)

DROP TABLE transaction_history;

ALTER TABLE customer_account.transaction_history
	ADD CONSTRAINT fk_transactions_history_Nto1
	FOREIGN KEY (account_user) REFERENCES customer_account.bankacctinfo(id);

CREATE TABLE withdraw_history (
withdraw_id SERIAL,
time_of_withdraw TIMESTAMP NOT NULL,
withdraw_amount NUMERIC (6)
);

CREATE TABLE login_info (
	username VARCHAR(100) UNIQUE NOT NULL,
	user_pass VARCHAR(100) NOT NULL,
	pinNumber NUMERIC(4) NOT NULL
	);

ALTER TABLE customer_account.login_info
	ADD CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES customer_account.bankacctinfo(username);
DROP TABLE deposit_history;

UPDATE customer_account.bankacctinfo
SET firstname = 'Nick', username = 'illenium3', user_pass = 'sadboi247', pinnumber = 0923, balance = 23000.89  
WHERE id=5;
	