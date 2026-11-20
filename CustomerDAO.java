import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    private Connection connection;

    public CustomerDAO() throws SQLException {
        connection = BankingDatabase.getConnection();
    }


public void addCustomer(int customerId, String fullnames,
                        String address, String phone, String password)
        throws SQLException {

    String sql = "INSERT INTO customers "
               + "(customer_id, fullnames, address, phone, password) "
               + "VALUES (?, ?, ?, ?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, customerId);
        statement.setString(2, fullnames);
        statement.setString(3, address);
        statement.setString(4, phone);
        statement.setString(5, password);

        statement.executeUpdate();

        System.out.println("Customer registered successfully!");
    }
}

public void findCustomer(int customerId) throws SQLException {

    String sql = "SELECT * FROM customers WHERE customer_id = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, customerId);

        try (ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                System.out.println("Customer ID: " + result.getInt("customer_id"));
                System.out.println("Full names: " + result.getString("fullnames"));
                System.out.println("Address: " + result.getString("address"));
                System.out.println("Phone: " + result.getString("phone"));
            } else {
                System.out.println("Customer not found!");
            }
        }
    }
}


public void updateCustomer(int customerId, String fullnames,
                           String address, String phone)
        throws SQLException {

    String sql = "UPDATE customers SET fullnames = ?, "
               + "address = ?, phone = ? WHERE customer_id = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, fullnames);
        statement.setString(2, address);
        statement.setString(3, phone);
        statement.setInt(4, customerId);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Customer updated successfully!");
        } else {
            System.out.println("Customer not found!");
        }
    }
}

public void deleteCustomer(int customerId) throws SQLException {

    String sql = "DELETE FROM customers WHERE customer_id = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, customerId);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Customer not found!");
        }
    }
}


public static void main(String[] args) {
    try {
        CustomerDAO dao = new CustomerDAO();

        dao.deleteCustomer(9999);

        dao.addCustomer(9999, "Test Customer",
                "Mochudi", "71234567", "test123");

        System.out.println("\n--- FIND CUSTOMER ---");
        dao.findCustomer(9999);

        System.out.println("\n--- UPDATE CUSTOMER ---");
        dao.updateCustomer(9999, "Updated Customer",
                "Gaborone", "72345678");

        dao.findCustomer(9999);

        System.out.println("\n--- DELETE CUSTOMER ---");
        dao.deleteCustomer(9999);

        dao.findCustomer(9999);

        dao.connection.close();

    } catch (SQLException e) {
        System.out.println("Test failed: " + e.getMessage());
    }
}

public void close() throws SQLException {
    if (connection != null && !connection.isClosed()) {
        connection.close();
    }
}

}
