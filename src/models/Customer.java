package models;

import java.util.ArrayList;

public class Customer {
    private String customerId;
    private String fullName;
    private String cnic;
    private String phoneNumber;
    private String email;
    private String dateOfBirth;
    private String city;
    private String password;
    private ArrayList<String> accountIds;
    private String createdAt;

    public Customer(String customerId, String fullName, String cnic, String phoneNumber, String email, String dateOfBirth, String city, String password, String createdAt) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.cnic = cnic;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.password = password;
        this.createdAt = createdAt;
        this.accountIds = new ArrayList<>();
    }

    // Getters
    public String getCustomerId() { return customerId; }
    public String getFullName() { return fullName; }
    public String getCnic() { return cnic; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getCity() { return city; }
    public String getPassword() { return password; }
    public ArrayList<String> getAccountIds() { return accountIds; }
    public String getCreatedAt() { return createdAt; }

    // Setters
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setCity(String city) { this.city = city; }
    public void setPassword(String password) { this.password = password; }
    public void addAccounts(String accountID) {  accountIds.add(accountID); }
}
