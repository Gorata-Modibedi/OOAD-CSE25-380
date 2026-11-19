
import java.util.Date;

public class AccountDAOTest {

    public static void main(String[] args) {

        try {
            // Create a test customer first
            CustomerDAO customerDAO = new CustomerDAO();

            customerDAO.deleteCustomer(9999);

            customerDAO.addCustomer(
                9999,
                "Test Customer",
                "Mochudi",
                "71234567",
                "test123"
            );

            // Create AccountDAO
            AccountDAO accountDAO = new AccountDAO();

            // Test CREATE
            System.out.println("\n--- ADD ACCOUNT ---");

            accountDAO.addAccount(
                "ACC9999",
                1000.00,
                "Mochudi",
                new Date(),
                "Savings",
                9999
            );

            // Test READ
            System.out.println("\n--- FIND ACCOUNT ---");
            accountDAO.findAccount("ACC9999");

            // Test UPDATE
            System.out.println("\n--- UPDATE ACCOUNT ---");

            accountDAO.updateAccount(
                "ACC9999",
                1500.00,
                "Gaborone",
                "Savings"
            );

            accountDAO.findAccount("ACC9999");

            // Test DELETE
            System.out.println("\n--- DELETE ACCOUNT ---");
            accountDAO.deleteAccount("ACC9999");

            // Close connections
            accountDAO.close();

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }
}
