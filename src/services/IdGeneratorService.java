package services;

public class IdGeneratorService {

    private static int customerCounter = 1;
    private static int accountCounter = 1;
    private static int transactionCounter = 1;

    public static String generateCustomerId() {
        return String.format("CUST-%05d", customerCounter++);
    }

    public static String generateAccountId(String accountType) {
        if (accountType.equals("SAVINGS")) {
            return String.format("SAV-%05d", accountCounter++);
        } else {
            return String.format("CUR-%05d", accountCounter++);
        }
    }

    public static String generateTransactionId() {
        return String.format("TXN-%05d", transactionCounter++);
    }
}
