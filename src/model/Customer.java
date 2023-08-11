package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

   private String first;

   private String last;

   private String email;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer(String first, String last, String email) {
        this.first = first;
        this.last = last;
        Pattern reg = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher match = reg.matcher(email);
        if(!match.matches()){throw new IllegalArgumentException();}
        this.email = email;
    }

    @Override
    public String toString(){
        return "Name:  " + this.first + " " + this.last + "\nEmail: " + this.email;
    }

}
