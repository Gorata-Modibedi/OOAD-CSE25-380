import java.util.ArrayList;

public class Customer {
    private int customerId;
    private String fullnames;
    private String address;
    private String phone;
    private String password;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    
    public Customer(int customerId, String fullnames, String address, String phone, String password) {
        this.customerId = customerId;
        this.fullnames = fullnames;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public String register() {
        return "Customer registered: " + fullnames;
    }

    public boolean login(int id, String pw) {
        return customerId == id && password.equals(pw);
    }

    public String updateDetails(String address, String phone) {
        this.address = address;
        this.phone = phone;
        return "Customer updated.";
    }

    public String getDetails() {
    return "Customer ID: " + customerId + ", Full Names: " + fullnames + ", Address: " + address + ", Phone: " + phone;
}

    public void addAccount(Account account) { accounts.add(account); }
    public void addTransaction(Transaction transaction) { transactions.add(transaction); }
    public ArrayList<Account> getAccounts() { return accounts; }
    public ArrayList<Transaction> getTransactions() { return transactions; }
    public String getFullnames() { return fullnames; }
}