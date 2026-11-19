
import java.util.Date;

public class TransactionDAOTest {

    public static void main(String[] args) {

        try {
            // Create a test customer
            CustomerDAO customerDAO = new CustomerDAO();

            customerDAO.deleteCustomer(9999);

            customerDAO.addCustomer(
                9999,
                "Test Customer",
                "Mochudi",
                "71234567",
                "test123"
            );

            // Create a test account
            AccountDAO accountDAO = new AccountDAO();

            accountDAO.deleteAccount("ACC9999");

            accountDAO.addAccount(
                "ACC9999",
                1000.00,
                "Mochudi",
                new Date(),
                "Savings",
                9999
            );

            // Create TransactionDAO
            TransactionDAO transactionDAO = new TransactionDAO();

            // CREATE
            System.out.println("\n--- ADD TRANSACTION ---");

            transactionDAO.addTransaction(
                "TXN9999",
                "deposit",
                500.00,
                new Date(),
                "ACC9999"
            );

            // READ
            System.out.println("\n--- FIND TRANSACTION ---");
            transactionDAO.findTransaction("TXN9999");

            // UPDATE
            System.out.println("\n--- UPDATE TRANSACTION ---");

            transactionDAO.updateTransaction(
                "TXN9999",
                "withdrawal",
                200.00
            );

            transactionDAO.findTransaction("TXN9999");

            // DELETE
            System.out.println("\n--- DELETE TRANSACTION ---");
            transactionDAO.deleteTransaction("TXN9999");

            // Clean up test records
            transactionDAO.close();
            accountDAO.deleteAccount("ACC9999");
            accountDAO.close();
            customerDAO.deleteCustomer(9999);

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }
}
