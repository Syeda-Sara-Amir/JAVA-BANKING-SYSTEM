package ui;

import java.util.Scanner;
import models.Customer;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private AuthMenu authMenu = new AuthMenu();

    public void start() {
        while (true) {
            printBanner();
            System.out.println("  1. Login");
            System.out.println("  2. Create New Customer");
            System.out.println("  3. Exit");
            System.out.println();
            System.out.print("  Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    Customer customer = authMenu.showLoginScreen();
                    if (customer != null) {
                        DashboardMenu dashboard = new DashboardMenu();
                        dashboard.show(customer);
                    }
                    break;
                case "2":
                    authMenu.showRegisterScreen();
                    break;
                case "3":
                    printGoodbye();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n Invalid choice. Please enter 1, 2, or 3.\n");
            }
        }
    }

    private void printBanner() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                        JAVABANK                          ║");
        System.out.println("  ║               Your Trusted Banking Partner               ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    private void printGoodbye() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║           Thank you for banking with JavaBank!           ║");
        System.out.println("  ║                      Goodbye!                            ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();
    }
}
