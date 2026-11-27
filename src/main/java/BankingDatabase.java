import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankingDatabase {

    private static final String URL = "jdbc:h2:file:./data/bankingdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

public static void main(String[] args) {
    try (Connection connection = getConnection()) {
        System.out.println("Successfully connected to H2 database!");
        createTables();
    } catch (SQLException e) {
        System.out.println("Database connection failed: " + e.getMessage());
    }
}


//method to create the database tables if they don't exist

public static void createTables() {
    String sql = """
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
        """;

    try (Connection connection = getConnection();
         java.sql.Statement statement = connection.createStatement()) {

        for (String command : sql.split(";")) {
            if (!command.isBlank()) {
                statement.execute(command);
            }
        }

        System.out.println("All three database tables created successfully!");

    } catch (SQLException e) {
        System.out.println("Table creation failed: " + e.getMessage());
    }
}

}
