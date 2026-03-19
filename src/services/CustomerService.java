package services;

import data.DataStore;
import models.Customer;
import utils.*;

public class CustomerService {

    public Customer createCustomer(String fullName, String cnic, String phoneNumber, String email, String dateOfBirth, String city, String password) {

        if(Validator.isValidAge(dateOfBirth) && Validator.isValidEmail(email) && Validator.isValidCnic(cnic) && Validator.isValidPhone(phoneNumber)){
            if(!isDuplicateCnic(cnic)){
                String customerId = IdGeneratorService.generateCustomerId();
                String createdAt = DateTimeUtil.getCurrentTimestamp();
                Customer customer = new Customer(customerId, fullName, cnic, phoneNumber, email, dateOfBirth, city, password, createdAt);
                DataStore.customers.put(customerId, customer);
                return customer;
            }
        }
        return null;
    }

    public Customer login(String customerId, String password) {
        if(!DataStore.customers.containsKey(customerId)) return null;
        Customer customerobj = DataStore.customers.get(customerId);
        if (password.equals(customerobj.getPassword())) return customerobj;  // (password.) this way it saves from null pointer expception
        return null;
    }

    public Customer findCustomerById(String customerId) {
        return DataStore.customers.get(customerId);
    }

    public Customer findCustomerByCnic(String cnic) {
        for (Customer value : DataStore.customers.values()){
            if((value.getCnic()).equals(cnic)){
                return value;
            }
        }
        return null;
    }

    public boolean isDuplicateCnic(String cnic) {
    for (Customer value : DataStore.customers.values()) {
        if (value.getCnic().equals(cnic)) {
            return true;
        }
    }
    return false;
    }
}
