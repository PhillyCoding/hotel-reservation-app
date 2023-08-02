package model;

public class Driver {
    public static void main(String[] args) {
        Customer customer = new Customer("first", "second", "fs@do.co");
        System.out.println(customer);

        Customer customer1 = new Customer("first", "second", "none");
    }
}
