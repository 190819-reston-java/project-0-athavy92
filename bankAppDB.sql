CREATE SCHEMA customer_account;

CREATE TABLE customer_account.bankAcctInfo(
id SERIAL NOT NULL UNIQUE,
firstname VARCHAR(100),
username VARCHAR(100) UNIQUE,
user_pass VARCHAR(100),
pinNumber NUMERIC(4)
);

DROP TABLE customer_account.bankacctinfo;

INSERT INTO customer_account.bankacctinfo (username, firstname, user_pass, pinnumber) VALUES
('ReadyPlayer1', 'Sam', 'jumpman23', '6865');

SELECT * FROM customer_account.bankacctinfo;

ALTER TABLE customer_account.bankacctinfo
	RENAME COLUMN pinnumber TO pin_number;

ALTER TABLE customer_account.bankacctinfo
	ADD PRIMARY KEY (ID);

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

DROP TABLE deposit_history;
	