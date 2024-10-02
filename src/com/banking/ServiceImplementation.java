package com.banking;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class ServiceImplementation{

    Repository repo = new Repository();
    Scanner scanner = new Scanner(System.in);
    public void registerCustomer(){
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Enter account type : saving or current");
        String accountType = scanner.next();
        System.out.println("Enter initial amount to open account ");
        double amount = scanner.nextDouble();

// To generate account number for new customer
        String accountNumber = "SBI";
        Random random = new Random();
        int num = random.nextInt(1000, 9999);
        accountNumber += num;

        Customer customer = new Customer(name,accountType,amount,accountNumber);
        repo.saveCustomer(customer);
    }

    public void customerData(){
        repo.getData();
    }

    public boolean checkCustomer(String name,String accountNumber){
        if(!repo.customers.isEmpty()){
            for (Customer c : repo.customers){
                if (name.equalsIgnoreCase(c.getName()) && accountNumber.equalsIgnoreCase(c.getAccountNumber())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
            return false;
    }

    public double checkBalance(String accountNumber){
    if(Repository.customers.isEmpty()){
        System.out.println("No data present");
        return 0.0;
    }
    else{
        for (Customer c:Repository.customers){
            if(accountNumber.equalsIgnoreCase(c.getAccountNumber())){
                return c.getAmount();
            }
        }
    }
    return 0.0;
    }

    public void depositeAmount(double amount,String accountNumber){
        LinkedHashSet<Customer> customers = repo.customers;
        if (!customers.isEmpty()) {
            for (Customer customer : customers) {
                if (accountNumber.equalsIgnoreCase(customer.getAccountNumber())) {
                    String type = "Deposite";
                    double customeAmount = customer.getAmount();
                    double tempAmt = customeAmount;
                    customeAmount += amount;
                    customer.setAmount(customeAmount);
                    System.out.println("Updated Balance is :" + customeAmount);
                    TransectionHistory t = new TransectionHistory(customer.getName(),amount,type,accountNumber,tempAmt,customeAmount);
                    Repository.history.add(t);
                } else {
                    System.out.println("Invalid Account number");
                }
            }
        }
        else{
            System.out.println("Enter positive amount");
        }
    }

    public void withdrawAmount(double amount,String accountNumber){
        LinkedHashSet<Customer> customers = repo.customers;
        if (!customers.isEmpty()) {
            for (Customer customer : customers) {
                if (accountNumber.equalsIgnoreCase(customer.getAccountNumber())) {
                    if (amount < customer.getAmount()) {
                        String type="Withdraw";
                        double currentAmt = customer.getAmount();
                        double tempAmt = currentAmt;
                        currentAmt -= amount;
                        customer.setAmount(currentAmt);
                        System.out.println("Updated balance  :" + currentAmt);
                        TransectionHistory t = new TransectionHistory(customer.getName(),amount,type,accountNumber,tempAmt,currentAmt);
                        Repository.history.add(t);
                    } else {
                        System.out.println("Your withdrawal amount is greter than the cuurent balance");
                        System.out.println("Current Balance :" + customer.getAmount());
                    }
                }
                else {
                    System.out.println("Account Number is invalid");
                }
            }
        }
    }

}
