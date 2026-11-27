public class ChequeAccount extends Account {
    private String employerName;
    private String employerAddress;

    public ChequeAccount(String accountNumber, double balance, String branch, Customer owner,
                         String employerName, String employerAddress) {
        super(accountNumber, balance, branch, owner);
        
        if (employerName == null || employerName.length() == 0
                || employerAddress == null || employerAddress.length() == 0) {
            throw new IllegalArgumentException("Cheque accounts need employer details.");
        }
        this.employerName = employerName;
        this.employerAddress = employerAddress;
    }


    @Override
    public double calculateInterest() {
        return 0;
    }

    
    public String getEmployerName() { return employerName; }
    public String getEmployerAddress() { return employerAddress; }
}