
CREATE TABLE IF NOT EXISTS customers (
    customer_id INT PRIMARY KEY,
    fullnames VARCHAR(100) NOT NULL,
    address VARCHAR(150),
    phone VARCHAR(20),
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts (
    account_number VARCHAR(20) PRIMARY KEY,
    balance DECIMAL(15,2) NOT NULL,
    branch VARCHAR(100) NOT NULL,
    open_date TIMESTAMP NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE IF NOT EXISTS transactions (
    transaction_id VARCHAR(20) PRIMARY KEY,
    type VARCHAR(30) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    account_number VARCHAR(20) NOT NULL,
    FOREIGN KEY (account_number) REFERENCES accounts(account_number)
);
