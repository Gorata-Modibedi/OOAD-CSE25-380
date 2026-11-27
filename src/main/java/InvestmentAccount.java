public class InvestmentAccount extends Account implements InterestCalculator {
    private double interestRate = 0.05;   // 5% per month

    public InvestmentAccount(String accountNumber, double balance, String branch, Customer owner) {
        super(accountNumber, balance, branch, owner);
        if (balance < 500) {
            throw new IllegalArgumentException("Investment accounts need BWP500 to open.");
        }
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

}