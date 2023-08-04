package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private static CustomerService instance;
    private Map<String, Customer> customers;

    private CustomerService() {
        customers = new HashMap<>();
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }


    public void addCustomer(String email, String first, String last){
        Customer cust = new Customer(first, last, email);
        customers.put(email, cust);
    }

    public Customer getCustomer(String email){
        return customers.get(email);
    }

    public Collection<Customer> getAllCustomers(){
        return customers.values();
    }
}
