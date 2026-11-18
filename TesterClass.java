public class TesterClass {

    public static void main(String[] args) {
        Balance bank = new Balance("BK001", "Absa Bank", "Gaborone");
        Customer thabo = new Customer(1, "Thabo Kgosi", "Plot 45", "71234567", "secret1");
        bank.addCustomer(thabo);
        System.out.println(thabo.getDetails());

        // Test 1: savings account works, withdrawing must fail
        SavingsAccount sav = new SavingsAccount("SAV-1", 1000, "Gaborone", thabo);
        bank.addAccount(sav);
        try {
            bank.processTransaction(sav, "withdrawal", 100);
            System.out.println("FAIL: savings withdrawal was allowed");
        } catch (Exception e) {
            System.out.println("PASS: " + e.getMessage());
        }

        // Test 2: investment with BWP300 must fail
        try {
            new InvestmentAccount("INV-X", 300, "Gaborone", thabo);
            System.out.println("FAIL: BWP300 was accepted");
        } catch (Exception e) {
            System.out.println("PASS: " + e.getMessage());
        }

        // Test 3: investment with BWP500 works, withdrawing is allowed
        InvestmentAccount inv = new InvestmentAccount("INV-1", 500, "Gaborone", thabo);
        bank.addAccount(inv);
        bank.processTransaction(inv, "withdrawal", 200);

        // Test 4: cheque account without an employer must fail
        try {
            new ChequeAccount("CHQ-X", 0, "Gaborone", thabo, "", "");
            System.out.println("FAIL: cheque without employer was accepted");
        } catch (Exception e) {
            System.out.println("PASS: " + e.getMessage());
        }

        // Test 5: cheque account with an employer works
        ChequeAccount chq = new ChequeAccount("CHQ-1", 2000, "Gaborone", thabo, "Choppies", "Plot 9");
        bank.addAccount(chq);
        bank.processTransaction(chq, "deposit", 500);

        // Test 6: an account with no customer must fail
        try {
            new SavingsAccount("SAV-X", 100, "Gaborone", null);
            System.out.println("FAIL: account without customer was accepted");
        } catch (Exception e) {
            System.out.println("PASS: " + e.getMessage());
        }

        // Test 7: pay interest to everyone
        bank.payMonthlyInterest();
        System.out.println("Savings (expect 1000.5): " + sav.getBalance());
        System.out.println("Investment (expect 315): " + inv.getBalance());
        System.out.println("Cheque (expect 2500):    " + chq.getBalance());

        // Test 8: customer holds many accounts and transactions
        System.out.println("Accounts (expect 3):     " + thabo.getAccounts().size());
        System.out.println("Transactions (expect 4): " + thabo.getTransactions().size());

        // Test 9: login
        System.out.println("Right password (expect true):  " + thabo.login(1, "secret1"));
        System.out.println("Wrong password (expect false): " + thabo.login(1, "nope"));

        // Test 10: print history
        for (Transaction t : thabo.getTransactions()) {
            System.out.println("  " + t.getDetails());
        }
    }
}