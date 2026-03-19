package ui;
import java.util.Scanner;
import models.Account;
import models.Customer;
import models.Transaction;
import services.AccountService;
import services.TransactionService;

public class AccountMenu {

    private Scanner scanner = new Scanner(System.in);
    private AccountService accountService = new AccountService();
    private TransactionService transactionService = new TransactionService();

    public void show(Account account) {
        while (true) {
            System.out.println();
            System.out.println("  ╔══════════════════════════════════════════════════════════╗");
            System.out.println("  ║                      ACCOUNT MENU                        ║");
            System.out.println("  ╚══════════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.println("  Account ID  : " + account.getAccountId());
            System.out.println("  Type        : " + account.getAccountType());
            System.out.printf( "  Balance     : Rs. %.2f%n", account.getBalance());
            System.out.println("  Status      : " + account.getStatus());
            System.out.println();
            System.out.println("  ──────────────────────────────────────────────────────────");
            System.out.println("  1. Deposit");
            System.out.println("  2. Withdraw");
            System.out.println("  3. Transfer");
            System.out.println("  4. Transaction History");
            System.out.println("  5. Mini Statement");
            System.out.println("  6. Back");
            System.out.println();
            System.out.print("  Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": handleDeposit(account); break;
                case "2": handleWithdraw(account); break;
                case "3": handleTransfer(account); break;
                case "4":
                    TransactionMenu txMenu = new TransactionMenu();
                    txMenu.show(account.getAccountId());
                    break;
                case "5":
                    TransactionMenu miniMenu = new TransactionMenu();
                    miniMenu.showMiniStatement(account.getAccountId());
                    break;
                case "6": return;
                default:
                    System.out.println("\n Invalid choice.\n");
            }
        }
    }

public void showCreateAccountScreen(Customer customer) {
    System.out.println();
    System.out.println("  ╔══════════════════════════════════════════════════════════╗");
    System.out.println("  ║                   OPEN NEW ACCOUNT                       ║");
    System.out.println("  ╚══════════════════════════════════════════════════════════╝");
    System.out.println();
    System.out.println("  Account Types:");
    System.out.println("  1. Savings  (Min balance: Rs. 1,000.00)");
    System.out.println("  2. Current  (Min balance: Rs. 0.00)");
    System.out.println();
    System.out.print("  Select account type: ");

    String choice = scanner.nextLine().trim();
    String accountType;

    if (choice.equals("1")) {
        accountType = "SAVINGS";
        System.out.println();
        System.out.println("WARNING: Savings account requires a minimum deposit of Rs. 1,000.00");
        System.out.println("         Your account will be created with Rs. 0.00 balance.");
        System.out.println("         Please deposit at least Rs. 1,000.00 before making withdrawals.");
    } else if (choice.equals("2")) {
        accountType = "CURRENT";
    } else {
        System.out.println("\n Invalid choice.\n");
        return;
    }

    Account account = accountService.createAccount(customer.getCustomerId(), accountType);

    if (account == null) {
        System.out.println("\n Failed to create account.\n");
        return;
    }

    System.out.println();
    System.out.println("Account created successfully!");
    System.out.println("  Account ID      : " + account.getAccountId());
    System.out.println("  Type            : " + account.getAccountType());
    System.out.printf( "  Minimum Balance : Rs. %.2f%n", account.getMinimumBalance());
    System.out.println();
}

    public void handleDeposit(Account account) {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                        DEPOSIT                           ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.printf("  Current Balance : Rs. %.2f%n", account.getBalance());
        System.out.print("  Enter Amount    : Rs. ");

        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            boolean success = accountService.deposit(account, amount);

            if (success) {
                Transaction t = transactionService.recordDeposit(account.getAccountId(), amount);
                ReceiptPrinter.printTransactionReceipt(t, account.getBalance());
            } else {
                System.out.println("\n  Deposit failed. Check amount and account status.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n  Invalid amount entered.\n");
        }
    }

    public void handleWithdraw(Account account) {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                       WITHDRAW                           ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.printf("  Current Balance          : Rs. %.2f%n", account.getBalance());
        System.out.printf("  Minimum Balance          : Rs. %.2f%n", account.getMinimumBalance());
        System.out.printf("  Maximum You Can Withdraw : Rs. %.2f%n", account.getBalance() - account.getMinimumBalance());
        System.out.print("  Enter Amount             : Rs. ");

        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            boolean success = accountService.withdraw(account, amount);

            if (success) {
                Transaction t = transactionService.recordWithdrawal(account.getAccountId(), amount);
                ReceiptPrinter.printTransactionReceipt(t, account.getBalance());
            } else {
                System.out.println("\n Withdrawal failed. Check balance or account status.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n Invalid amount entered.\n");
        }
    }

    public void handleTransfer(Account account) {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                       TRANSFER                           ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  From Account    : " + account.getAccountId());
        System.out.printf( "  Current Balance : Rs. %.2f%n", account.getBalance());
        System.out.println();
        System.out.print("  Destination Account ID : ");
        String toAccountId = scanner.nextLine().trim();

        System.out.print("  Amount                 : Rs. ");

        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());

            System.out.println();
            System.out.println("  ──────────────────────────────────────────────────────────");
            System.out.println("  Confirm Transfer:");
            System.out.println("  From   : " + account.getAccountId());
            System.out.println("  To     : " + toAccountId);
            System.out.printf( "  Amount : Rs. %.2f%n", amount);
            System.out.println("  ──────────────────────────────────────────────────────────");
            System.out.print("  Proceed? (Y/N): ");

            String confirm = scanner.nextLine().trim();

            if (!confirm.equalsIgnoreCase("Y")) {
                System.out.println("\n  Transfer cancelled.\n");
                return;
            }

            boolean success = transactionService.transfer(account.getAccountId(), toAccountId, amount);

            if (success) {
                Transaction t = transactionService.getLastTransaction();
                ReceiptPrinter.printTransactionReceipt(t, account.getBalance());
            } else {
                System.out.println();
                System.out.println("  ╔══════════════════════════════════════════════════════════╗");
                System.out.println("  ║                    TRANSACTION FAILED                    ║");
                System.out.println("  ╚══════════════════════════════════════════════════════════╝");
                System.out.println("\n  Reason: Insufficient balance or invalid destination account.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n  Invalid amount entered.\n");
        }
    }
}

