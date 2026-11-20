import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class AccountDAO {

    private Connection connection;

    public AccountDAO() throws SQLException {
        connection = BankingDatabase.getConnection();
    }

    // CREATE: Add a new account
    public void addAccount(String accountNumber, double balance,
                           String branch, Date openDate,
                           String accountType, int customerId)
            throws SQLException {

        String sql = "INSERT INTO accounts "
                + "(account_number, balance, branch, open_date, account_type, customer_id) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, accountNumber);
            statement.setDouble(2, balance);
            statement.setString(3, branch);
            statement.setTimestamp(4, new Timestamp(openDate.getTime()));
            statement.setString(5, accountType);
            statement.setInt(6, customerId);

            statement.executeUpdate();

            System.out.println("Account added successfully!");
        }
    }

    // READ: Find an account
    public void findAccount(String accountNumber) throws SQLException {

        String sql = "SELECT * FROM accounts WHERE account_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, accountNumber);

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {
                    System.out.println("Account Number: " + result.getString("account_number"));
                    System.out.println("Balance: " + result.getDouble("balance"));
                    System.out.println("Branch: " + result.getString("branch"));
                    System.out.println("Account Type: " + result.getString("account_type"));
                    System.out.println("Customer ID: " + result.getInt("customer_id"));
                } else {
                    System.out.println("Account not found!");
                }
            }
        }
    }

    // UPDATE: Update account details
    public void updateAccount(String accountNumber, double balance,
                              String branch, String accountType)
            throws SQLException {

        String sql = "UPDATE accounts SET balance = ?, branch = ?, "
                + "account_type = ? WHERE account_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, balance);
            statement.setString(2, branch);
            statement.setString(3, accountType);
            statement.setString(4, accountNumber);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Account updated successfully!");
            } else {
                System.out.println("Account not found!");
            }
        }
    }

    // DELETE: Delete an account
    public void deleteAccount(String accountNumber) throws SQLException {

        String sql = "DELETE FROM accounts WHERE account_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, accountNumber);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Account deleted successfully!");
            } else {
                System.out.println("Account not found!");
            }
        }
    }

    // Close the database connection
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
