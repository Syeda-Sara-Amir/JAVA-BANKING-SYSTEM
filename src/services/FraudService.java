package services;


import java.util.Queue;
import java.util.ArrayDeque;
import java.util.HashMap;

public class FraudService {

    // Stores recent transaction timestamps per account for frequency checking
    private static HashMap<String, Queue<String>> recentTransactions = new HashMap<>();

    public boolean checkTransactionFrequency(String accountId) {
        // TODO: get the queue of recent transaction timestamps for this account
        // TODO: remove timestamps older than 5 minutes from the queue
        // TODO: if more than 3 transactions remain in the queue return true (fraud suspected)
        // TODO: add current timestamp to the queue
        // TODO: return false if frequency is normal
        return false;
    }

    public boolean checkUnusualAmount(Account account, double amount) {
        // TODO: calculate average transaction amount for this account
        //       by looping through transaction history
        // TODO: if amount exceeds 3x the average return true (fraud suspected)
        // TODO: return false if amount is normal
        return false;
    }

    public void flagAccount(String accountId) {
        // TODO: fetch account from DataStore
        // TODO: freeze the account using AccountService
        // TODO: print a warning that account has been flagged
    }
}
