import java.util.Date;

public abstract class Account {
    private String accountNumber;
    private double balance;
    private String branch;
    private Date openDate = new Date();
    private Customer owner;

    public Account(String accountNumber, double balance, String branch, Customer owner) {
        if (owner == null) {
            throw new IllegalArgumentException("An account needs a customer.");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.branch = branch;
        this.owner = owner;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be above zero.");
        }
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be above zero.");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds.");
        }
        balance = balance - amount;
    }

    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public Customer getOwner() { return owner; }
    
    public abstract double calculateInterest();

}