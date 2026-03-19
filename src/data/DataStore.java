package data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import models.*;


public class DataStore {

    public static HashMap<String, Customer> customers = new HashMap<>();
    public static HashMap<String, Account> accounts = new HashMap<>();
    public static LinkedList<Transaction> transactionLog = new LinkedList<>();
    public static Queue<Transaction> pendingTransactions = new ArrayDeque<>();

}
