package ui;
import models.Transaction;
import utils.DateTimeUtil;

public class ReceiptPrinter {

    public static void printTransactionReceipt(Transaction transaction, double newBalance) {
        if (transaction == null) return;

        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                TRANSACTION SUCCESSFUL                    ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  Reference   : " + transaction.getTransactionId());
        System.out.println("  Type        : " + transaction.getType());

        if (transaction.getFromAccountId() != null && !transaction.getFromAccountId().isEmpty()) {
            System.out.println("  From        : " + transaction.getFromAccountId());
        }
        if (transaction.getToAccountId() != null && !transaction.getToAccountId().isEmpty()) {
            System.out.println("  To          : " + transaction.getToAccountId());
        }

        System.out.printf( "  Amount      : Rs. %.2f%n", transaction.getAmount());
        System.out.println("  Date & Time : " + DateTimeUtil.formatForReceipt(transaction.getTimestamp()));
        System.out.printf( "  New Balance : Rs. %.2f%n", newBalance);
        System.out.println();
        System.out.println("  ══════════════════════════════════════════════════════════");
        System.out.println();
    }

    public static void printAccountDetails(models.Account account) {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                     ACCOUNT DETAILS                      ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  Account ID      : " + account.getAccountId());
        System.out.println("  Type            : " + account.getAccountType());
        System.out.printf( "  Balance         : Rs. %.2f%n", account.getBalance());
        System.out.printf( "  Minimum Balance : Rs. %.2f%n", account.getMinimumBalance());
        System.out.println("  Status          : " + account.getStatus());
        System.out.println("  Created         : " + DateTimeUtil.formatDate(account.getCreatedAt()));
        System.out.println();
    }
}

