import java.util.Date;

public class Transaction {
    private String transactionId;
    private String type;      // "deposit", "withdrawal" or "interest"
    private double amount;
    private Date date;

    public Transaction(String transactionId, String type, double amount, Date date) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getDetails() {
        return transactionId + " | " + type + " | " + amount + " | " + date;
    }

}