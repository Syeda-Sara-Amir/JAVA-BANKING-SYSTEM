package models;

public class Account {
    private String accountId;
    private String customerId;
    private String accountType; // SAVINGS or CURRENT
    private double balance;
    private double minimumBalance;
    private String status; // ACTIVE, FROZEN, CLOSED
    private String createdAt;

    public Account(String accountId, String customerId, String accountType,
                   double balance, double minimumBalance, String createdAt) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
        this.minimumBalance = minimumBalance;
        this.status = "ACTIVE";
        this.createdAt = createdAt;
    }

    // Getters
    public String getAccountId() { return accountId; }
    public String getCustomerId() { return customerId; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public double getMinimumBalance() { return minimumBalance; }
    public String getStatus() { return status; }
    public String getCreatedAt() { return createdAt; }

    // Setters
    public void setBalance(double balance) { this.balance = balance; }
    public void setStatus(String status) { this.status = status; }

    // Helper
    public boolean isActive() { return this.status.equals("ACTIVE"); }
}
