package ui;

import java.util.Scanner;
import java.util.LinkedList;
import models.Transaction;
import services.TransactionService;

public class TransactionMenu {

    private Scanner scanner = new Scanner(System.in);
    private TransactionService transactionService = new TransactionService();
    private static final int PAGE_SIZE = 5;

    public void show(String accountId) {
        LinkedList<Transaction> history = transactionService.getTransactionHistory(accountId);
        int total = history.size();
        int shown = 0;

        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                 TRANSACTION HISTORY                      ║");
        System.out.println("  ║                     " + accountId + "                    ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");

        if (history.isEmpty()) {
            System.out.println("\n  No transactions found.\n");
            return;
        }

        while (shown < total) {
            System.out.println();
            System.out.printf("  %-12s  %-18s  %-12s  %s%n", "REF", "DATE", "TYPE", "AMOUNT");
            System.out.println("  ──────────────────────────────────────────────────────────");

            int end = Math.min(shown + PAGE_SIZE, total);
            for (int i = shown; i < end; i++) {
                Transaction t = history.get(i);
                String sign = t.getType().equals("DEPOSIT") ? "+" : "-";
                System.out.printf("  %-12s  %-18s  %-12s  %s%.2f%n",
                    t.getTransactionId(),
                    t.getTimestamp(),
                    t.getType(),
                    sign,
                    t.getAmount());
            }

            System.out.println("  ──────────────────────────────────────────────────────────");
            System.out.printf("  Showing %d of %d transactions%n", end, total);
            shown = end;

            if (shown < total) {
                System.out.println();
                System.out.println("  1. Load More");
                System.out.println("  2. Back");
                System.out.print("\n  Enter your choice: ");
                String choice = scanner.nextLine().trim();
                if (!choice.equals("1")) return;
            } else {
                System.out.println();
                System.out.print("  Press Enter to go back...");
                scanner.nextLine();
                return;
            }
        }
    }

    public void showMiniStatement(String accountId) {
        LinkedList<Transaction> mini = transactionService.getMiniStatement(accountId);

        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                    MINI STATEMENT                        ║");
        System.out.println("  ║                     " + accountId + "                   ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  Last 5 Transactions:");
        System.out.println("  ──────────────────────────────────────────────────────────");

        if (mini.isEmpty()) {
            System.out.println("  No transactions found.");
        } else {
            for (Transaction t : mini) {
                String sign = t.getType().equals("DEPOSIT") ? "+" : "-";
                System.out.printf("  %-12s  %-12s  %-12s  %s%.2f%n",
                    t.getTransactionId(),
                    t.getTimestamp(),
                    t.getType(),
                    sign,
                    t.getAmount());
            }
        }

        System.out.println("  ──────────────────────────────────────────────────────────");
        System.out.println();
        System.out.print("  Press Enter to go back...");
        scanner.nextLine();
    }
}

