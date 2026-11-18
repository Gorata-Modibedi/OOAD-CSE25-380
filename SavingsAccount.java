public class SavingsAccount extends Account implements InterestCalculator {
    private double interestRate = 0.0005;   // 0.05% per month

    public SavingsAccount(String accountNumber, double balance, String branch, Customer owner) {
        super(accountNumber, balance, branch, owner);  
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Savings accounts do not allow withdrawals.");
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

}