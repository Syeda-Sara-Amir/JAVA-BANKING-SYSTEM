package services;

import java.util.LinkedList;

public class TransactionService {

    private AccountService accountService = new AccountService();

    public boolean transfer(String fromAccountId, String toAccountId, double amount) {
        // TODO: fetch both accounts from DataStore
        // TODO: validate both accounts exist and are ACTIVE
        // TODO: save original balances for rollback
        // TODO: attempt debit on source account
        // TODO: attempt credit on destination account
        // TODO: if anything fails restore original balances (atomicity)
        // TODO: create Transaction record and save to DataStore
        // TODO: return true if successful
        return false;
    }

    public boolean recordDeposit(String accountId, double amount) {
        // TODO: create a DEPOSIT Transaction object
        // TODO: set status to COMPLETED
        // TODO: save to DataStore.getInstance().transactionLog
        // TODO: return true if successful
        return false;
    }

    public boolean recordWithdrawal(String accountId, double amount) {
        // TODO: create a WITHDRAWAL Transaction object
        // TODO: set status to COMPLETED
        // TODO: save to DataStore.getInstance().transactionLog
        // TODO: return true if successful
        return false;
    }

    public boolean reverseTransaction(String transactionId) {
        // TODO: find original transaction in transactionLog
        // TODO: check it is COMPLETED and not already REVERSED
        // TODO: create a new REVERSAL transaction
        // TODO: undo the balance changes on affected accounts
        // TODO: mark original transaction as REVERSED
        // TODO: return true if successful
        return false;
    }

    public LinkedList<Transaction> getTransactionHistory(String accountId) {
        // TODO: loop through DataStore.getInstance().transactionLog
        // TODO: collect transactions where fromAccountId or toAccountId matches
        // TODO: return matching transactions as a LinkedList
        return new LinkedList<>();
    }

    public LinkedList<Transaction> getMiniStatement(String accountId) {
        // TODO: get full transaction history using getTransactionHistory()
        // TODO: return only the last 5 transactions
        return new LinkedList<>();
    }
}
