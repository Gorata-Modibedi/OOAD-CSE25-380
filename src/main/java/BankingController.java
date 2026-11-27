import java.sql.SQLException;
import java.util.Date;

public class BankingController {

    private CustomerDAO customerDAO;
    private AccountDAO accountDAO;
    private TransactionDAO transactionDAO;

    public BankingController() throws SQLException {
        customerDAO = new CustomerDAO();
        accountDAO = new AccountDAO();
        transactionDAO = new TransactionDAO();
    }

    // Register a customer
    public boolean registerCustomer(int customerId, String fullnames,
                                    String address, String phone,
                                    String password) {
        if (fullnames == null || fullnames.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            System.out.println("Name and password are required.");
            return false;
        }

        try {
            customerDAO.addCustomer(customerId, fullnames,
                    address, phone, password);
            return true;
        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
            return false;
        }
    }

    // Authenticate a customer
public boolean loginCustomer(int customerId, String password) {
    if (password == null || password.trim().isEmpty()) {
        return false;
    }

    try {
        return customerDAO.authenticateCustomer(customerId, password);
    } catch (SQLException e) {
        System.out.println("Login failed: " + e.getMessage());
        return false;
    }
}
    // Open an account
    public boolean openAccount(String accountNumber, double balance,
                               String branch, Date openDate,
                               String accountType, int customerId) {
        if (accountNumber == null || accountNumber.trim().isEmpty()
                || balance < 0 || openDate == null
                || branch == null || branch.trim().isEmpty()) {
            System.out.println("Invalid account information.");
            return false;
        }

        try {
            accountDAO.addAccount(accountNumber, balance, branch,
                    openDate, accountType, customerId);
            return true;
        } catch (SQLException e) {
            System.out.println("Account creation failed: " + e.getMessage());
            return false;
        }
    }

    // Record a transaction
    public boolean recordTransaction(String transactionId, String type,
                                     double amount, Date date,
                                     String accountNumber) {
        if (transactionId == null || transactionId.trim().isEmpty()
                || type == null || type.trim().isEmpty()
                || amount <= 0 || date == null
                || accountNumber == null || accountNumber.trim().isEmpty()) {
            System.out.println("Invalid transaction information.");
            return false;
        }

        try {
            transactionDAO.addTransaction(transactionId, type,
                    amount, date, accountNumber);
            return true;
        } catch (SQLException e) {
            System.out.println("Transaction failed: " + e.getMessage());
            return false;
        }
    }

    // Close database connections
    public void close() {
        try {
            customerDAO.close();
            accountDAO.close();
            transactionDAO.close();
        } catch (SQLException e) {
            System.out.println("Error closing database: " + e.getMessage());
        }
    }
}

