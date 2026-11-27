import java.sql.SQLException;
import java.util.Date;

public class BankingControllerTest {

    public static void main(String[] args) {

        try {
            cleanUp();
            BankingController controller = new BankingController();

            System.out.println("--- CUSTOMER REGISTRATION ---");
            boolean customerAdded = controller.registerCustomer(
                    8888, "Integration Test Customer",
                    "Mochudi", "71234567", "test123"
            );
            System.out.println("Customer test: " + customerAdded);

            System.out.println("\n--- ACCOUNT CREATION ---");
            boolean accountAdded = controller.openAccount(
                    "ACC8888", 1000.00, "Gaborone",
                    new Date(), "Savings", 8888
            );
            System.out.println("Account test: " + accountAdded);

            System.out.println("\n--- TRANSACTION RECORDING ---");
            boolean transactionAdded = controller.recordTransaction(
                    "TXN8888", "Deposit", 500.00,
                    new Date(), "ACC8888"
            );
            System.out.println("Transaction test: " + transactionAdded);

            
            controller.close();

        } catch (SQLException e) {
            System.out.println("Integration test failed: " + e.getMessage());
        }
    }


    private static void cleanUp() throws SQLException {
        System.out.println("Cleaning old test data...");
        try (java.sql.Connection c = BankingDatabase.getConnection();
             java.sql.Statement s = c.createStatement()) {
            s.executeUpdate("DELETE FROM transactions WHERE transaction_id = 'TXN8888'");
            s.executeUpdate("DELETE FROM accounts WHERE account_number = 'ACC8888'");
            s.executeUpdate("DELETE FROM customers WHERE customer_id = 8888");
        }
    }
}