package services;
 
import java.util.ArrayList;
 
import data.DataStore;
import models.Account;
import models.Customer;
import utils.DateTimeUtil;
 
public class AccountService {
 
    public Account createAccount(String customerId, String accountType) {
        if (!DataStore.customers.containsKey(customerId)) return null;
        if (!accountType.equals("SAVINGS") && !accountType.equals("CURRENT")) return null;
 
        double minimumBalance = accountType.equals("SAVINGS") ? 1000.0 : 0.0;
        String accountId = IdGeneratorService.generateAccountId(accountType);
        String createdAt = DateTimeUtil.getCurrentTimestamp();
 
        Account account = new Account(accountId, customerId, accountType, 0.0, minimumBalance, createdAt);
 
        DataStore.accounts.put(accountId, account);
 
        Customer customer = DataStore.customers.get(customerId);
        customer.addAccounts(accountId);
 
        return account;
    }
 
    public boolean deposit(Account account, double amount) {
        if (amount > 0 && account.getStatus().equals("ACTIVE")) {
            double newBalance = account.getBalance() + amount; // fixed: was mixing up variables
            account.setBalance(newBalance);
            return true;
        }
        return false;
    }
 
    public boolean withdraw(Account account, double amount) {
        if (amount > 0
                && account.getStatus().equals("ACTIVE")
                && (account.getBalance() - amount) >= account.getMinimumBalance()) { // fixed: was > should be >=
            double updatedBalance = account.getBalance() - amount;
            account.setBalance(updatedBalance);
            return true;
        }
        return false;
    }
 
    public boolean freezeAccount(Account account) {
        if (account.getStatus().equals("ACTIVE")) {
            account.setStatus("FROZEN");
            return true;
        }
        return false;
    }
 
    public boolean closeAccount(Account account) {
        if (!account.getStatus().equals("CLOSED") && account.getBalance() == 0) {
            account.setStatus("CLOSED");
            return true;
        }
        return false;
    }
 
    public double getBalance(Account account) {
        return account.getBalance();
    }
 
    public ArrayList<Account> getAccountsByCustomer(String customerId) {
        Customer customerObj = DataStore.customers.get(customerId);
        if (customerObj == null) return new ArrayList<>();
        ArrayList<String> accountIds = customerObj.getAccountIds();
        ArrayList<Account> accountObjs = new ArrayList<>();
        for (String id : accountIds) {
            Account acc = DataStore.accounts.get(id);
            if (acc != null) accountObjs.add(acc);
        }
        return accountObjs;
    }
}
