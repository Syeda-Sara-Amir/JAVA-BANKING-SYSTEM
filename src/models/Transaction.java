package models;

public class Transaction {
    private String transactionId;
    private String fromAccountId;
    private String toAccountId;
    private String type; // DEPOSIT, WITHDRAWAL, TRANSFER, REVERSAL
    private double amount;
    private String status; // PENDING, COMPLETED, FAILED, REVERSED
    private String timestamp;
    private String description;

    public Transaction(String transactionId, String fromAccountId, String toAccountId,
                       String type, double amount, String description, String timestamp) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.type = type;
        this.amount = amount;
        this.status = "PENDING";
        this.timestamp = timestamp;
        this.description = description;
    }

    // Getters
    public String getTransactionId() { return transactionId; }
    public String getFromAccountId() { return fromAccountId; }
    public String getToAccountId() { return toAccountId; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public String getTimestamp() { return timestamp; }
    public String getDescription() { return description; }

    // Setters
    public void setStatus(String status) { this.status = status; }
}
