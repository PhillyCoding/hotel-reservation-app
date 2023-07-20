package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    String first;

    String last;

    String email;

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
