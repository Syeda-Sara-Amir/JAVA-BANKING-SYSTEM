package ui;

import java.util.Scanner;
import models.Customer;
import services.CustomerService;

public class AuthMenu {

    private Scanner scanner = new Scanner(System.in);
    private CustomerService customerService = new CustomerService();

    public Customer showLoginScreen() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                   LOGIN TO JAVABANK                      ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.print("  Customer ID : ");
        String customerId = scanner.nextLine().trim();

        System.out.print("  Password    : ");
        String password = scanner.nextLine().trim();

        Customer customer = customerService.login(customerId, password);

        if (customer == null) {
            System.out.println();
            System.out.println(" Invalid Customer ID or Password. Please try again.");
            System.out.println();
            return null;
        }

        System.out.println();
        System.out.println(" Welcome back, " + customer.getFullName() + "!");
        System.out.println();
        return customer;
    }

    public Customer showRegisterScreen() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                      NEW CUSTOMER                        ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.print("  Full Name        : ");
        String fullName = scanner.nextLine().trim();

        System.out.print("  CNIC             : ");
        String cnic = scanner.nextLine().trim();

        System.out.print("  Phone Number     : ");
        String phone = scanner.nextLine().trim();

        System.out.print("  Email            : ");
        String email = scanner.nextLine().trim();

        System.out.print("  Date of Birth (DD-MM-YYYY) : ");
        String dob = scanner.nextLine().trim();

        System.out.print("  City             : ");
        String city = scanner.nextLine().trim();

        System.out.print("  Password         : ");
        String password = scanner.nextLine().trim();

        System.out.print("  Confirm Password : ");
        String confirmPassword = scanner.nextLine().trim();

        if (!password.equals(confirmPassword)) {
            System.out.println();
            System.out.println(" Passwords do not match. Please try again.");
            System.out.println();
            return null;
        }

        Customer customer = customerService.createCustomer(fullName, cnic, phone, email, dob, city, password);

        if (customer == null) {
            System.out.println();
            System.out.println(" Registration failed. CNIC may already be registered.");
            System.out.println();
            return null;
        }

        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                REGISTRATION SUCCESSFUL                   ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  Customer ID : " + customer.getCustomerId());
        System.out.println("  Name        : " + customer.getFullName());
        System.out.println();
        System.out.println("Please save your Customer ID — you will need it to login.");
        System.out.println();

        System.out.print(" Would you like to open an account now? (Y/N): ");
        String openAccount = scanner.nextLine().trim();

        if (openAccount.equalsIgnoreCase("Y")) {
            AccountMenu accountMenu = new AccountMenu();
            accountMenu.showCreateAccountScreen(customer);
        }

        return customer;
    }
}
