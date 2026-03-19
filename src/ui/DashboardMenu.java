package ui;


import java.util.Scanner;
import java.util.ArrayList;
import models.Customer;
import models.Account;
import services.AccountService;

public class DashboardMenu {

    private Scanner scanner = new Scanner(System.in);
    private AccountService accountService = new AccountService();

    public void show(Customer customer) {
        while (true) {
            ArrayList<Account> accounts = accountService.getAccountsByCustomer(customer.getCustomerId());

            System.out.println();
            System.out.println("  ╔══════════════════════════════════════════════════════════╗");
            System.out.println("  ║                         DASHBOARD                        ║");
            System.out.printf( "  ║                  Welcome, %-28s  ║%n", customer.getFullName());
            System.out.println("  ╚══════════════════════════════════════════════════════════╝");
            System.out.println();

            if (accounts.isEmpty()) {
                System.out.println("  You have no accounts yet.");
            } else {
                System.out.println("  Your Accounts:");
                System.out.println("  ┌────────────────────────────────────────────────────────┐");
                for (int i = 0; i < accounts.size(); i++) {
                    Account acc = accounts.get(i);
                    System.out.printf("  │  [%d]  %-10s  %-8s  Rs. %10.2f  %-8s  │%n",
                        i + 1,
                        acc.getAccountId(),
                        acc.getAccountType(),
                        acc.getBalance(),
                        acc.getStatus());
                }
                System.out.println("  └────────────────────────────────────────────────────────┘");
            }

            System.out.println();
            System.out.println("  1. Select Account");
            System.out.println("  2. Open New Account");
            System.out.println("  3. Logout");
            System.out.println();
            System.out.print("  Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    if (accounts.isEmpty()) {
                        System.out.println("\n You have no accounts to select.\n");
                        break;
                    }
                    System.out.print("\n  Enter account number [1-" + accounts.size() + "]: ");
                    String input = scanner.nextLine().trim();
                    try {
                        int index = Integer.parseInt(input) - 1;
                        if (index >= 0 && index < accounts.size()) {
                            AccountMenu accountMenu = new AccountMenu();
                            accountMenu.show(accounts.get(index));
                        } else {
                            System.out.println("\n Invalid selection.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\n Please enter a valid number.\n");
                    }
                    break;
                case "2":
                    AccountMenu accountMenu = new AccountMenu();
                    accountMenu.showCreateAccountScreen(customer);
                    break;
                case "3":
                    System.out.println("\n  Logging out...\n");
                    return;
                default:
                    System.out.println("\n Invalid choice.\n");
            }
        }
    }
}
 
