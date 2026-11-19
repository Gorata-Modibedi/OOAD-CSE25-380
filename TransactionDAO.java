
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class TransactionDAO {

    private Connection connection;

    public TransactionDAO() throws SQLException {
        connection = BankingDatabase.getConnection();
    }

    // CREATE: Add a transaction
    public void addTransaction(String transactionId, String type,
                               double amount, Date date,
                               String accountNumber) throws SQLException {

        String sql = "INSERT INTO transactions "
                + "(transaction_id, type, amount, transaction_date, account_number) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, transactionId);
            statement.setString(2, type);
            statement.setDouble(3, amount);
            statement.setTimestamp(4, new Timestamp(date.getTime()));
            statement.setString(5, accountNumber);

            statement.executeUpdate();

            System.out.println("Transaction recorded successfully!");
        }
    }

    // READ: Find a transaction
    public void findTransaction(String transactionId) throws SQLException {

        String sql = "SELECT * FROM transactions WHERE transaction_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, transactionId);

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {
                    System.out.println("Transaction ID: "
                            + result.getString("transaction_id"));
                    System.out.println("Type: "
                            + result.getString("type"));
                    System.out.println("Amount: "
                            + result.getDouble("amount"));
                    System.out.println("Date: "
                            + result.getTimestamp("transaction_date"));
                    System.out.println("Account Number: "
                            + result.getString("account_number"));
                } else {
                    System.out.println("Transaction not found!");
                }
            }
        }
    }

    // UPDATE: Update a transaction
    public void updateTransaction(String transactionId, String type,
                                  double amount) throws SQLException {

        String sql = "UPDATE transactions SET type = ?, amount = ? "
                + "WHERE transaction_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, type);
            statement.setDouble(2, amount);
            statement.setString(3, transactionId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Transaction updated successfully!");
            } else {
                System.out.println("Transaction not found!");
            }
        }
    }

    // DELETE: Delete a transaction
    public void deleteTransaction(String transactionId) throws SQLException {

        String sql = "DELETE FROM transactions WHERE transaction_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, transactionId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Transaction deleted successfully!");
            } else {
                System.out.println("Transaction not found!");
            }
        }
    }

    // Close database connection
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    
}
