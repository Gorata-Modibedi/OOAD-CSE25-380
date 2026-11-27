import java.util.ArrayList;
import java.util.Date;

public class Balance {
    private String bankId;
    private String name;
    private String branchAddress;
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Balance(String bankId, String name, String branchAddress) {
        this.bankId = bankId;
        this.name = name;
        this.branchAddress = branchAddress;
    }

    public String addCustomer(Customer customer) {
        customers.add(customer);
        return "Customer added: " + customer.getFullnames();
    }

    public String addAccount(Account account) {
        if (!customers.contains(account.getOwner())) {
            throw new IllegalArgumentException("Add the customer to the bank first.");
        }
        accounts.add(account);
        account.getOwner().addAccount(account);
        return "Account added: " + account.getAccountNumber();
    }

    public String processTransaction(Account account, String type, double amount) {
        if (type.equals("deposit")) {
            account.deposit(amount);
        } else if (type.equals("withdrawal")) {
            account.withdraw(amount);
        } else {
            throw new IllegalArgumentException("Type must be deposit or withdrawal.");
        }
        record(account.getOwner(), type, amount);
        return "Done. New balance: " + account.getBalance();
    }

    public void payMonthlyInterest() {
        for (Account account : accounts) {
            double interest = account.calculateInterest();
            if (interest > 0) {
                account.deposit(interest);
                record(account.getOwner(), "interest", interest);
            }
        }
    }

    private void record(Customer customer, String type, double amount) {
        Transaction t = new Transaction("T" + (transactions.size() + 1), type, amount, new Date());
        transactions.add(t);
        customer.addTransaction(t);
    }

    public ArrayList<Transaction> getTransactions() { return transactions; }
    public ArrayList<Customer> getCustomers() { return customers; }
    public ArrayList<Account> getAccounts() { return accounts; }
}