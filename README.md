# JavaBank

A command-line banking management system written in Java. Built as a Data Structures course project with a focus on applying the right data structure for each problem rather than using them arbitrarily.

> **Status: In progress.** Core account and customer management is functional. Transaction history, fraud detection, and the DSA implementations are still being worked on.

---

## Data Structures

| Structure | Application |
|---|---|
| HashMap | O(1) customer and account lookup by ID |
| LinkedList | Chronological transaction log |
| Queue | Pending transaction pipeline and fraud detection window |
| Stack | Transaction reversal tracking |
| BST | Account search by account number |

The built-in Java implementations are used for now. Custom from-scratch implementations will be added in the `dsa/` module.

---

## Project Structure

```
src/
    Main.java
    models/
        Customer.java
        Account.java
        Transaction.java
    data/
        DataStore.java
    services/
        CustomerService.java
        AccountService.java
        TransactionService.java
        FraudService.java
        IdGeneratorService.java
    ui/
        MainMenu.java
        AuthMenu.java
        DashboardMenu.java
        AccountMenu.java
        TransactionMenu.java
        ReceiptPrinter.java
    utils/
        Validator.java
        DateTimeUtil.java
```

---

## Architecture

Three distinct layers with no cross-layer skipping:

- **Models** — data only, no logic
- **Services** — all business rules, validation, and operations
- **UI** — input collection and output formatting only

Services read and write to DataStore. UI calls Services and displays results. Models hold state.

---

## Running the Project

Requires Java 8 or above.

```bash
cd src
javac -cp . models/*.java data/*.java utils/*.java services/*.java ui/*.java Main.java
java Main
```

---

This project is for educational purposes only.
