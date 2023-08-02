package service;

import model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    static Map<String, Customer> customers = new HashMap<>();

    public static void addCustomer(String email, String first, String last){
        Customer cust = new Customer(first, last, email);
        customers.put(email, cust);
    }

    public Customer getCustomer(String email){
        return customers.get(email);
    }
}
