package com.banking;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Repository {

    static LinkedHashSet<Customer> customers = new LinkedHashSet<>();
    static ArrayList<TransectionHistory> history = new ArrayList<>();
    public  void saveCustomer(Customer c){
        customers.add(c);
    }

    public  void getData(){
        for (Customer customer : customers) {
            if (customers.isEmpty()) {
                System.out.println("There is no data present");
            } else {
                System.out.println(customer);
            }

        }
    }

    public  void showHistory(){
        System.out.println(Repository.history);
    }


}
