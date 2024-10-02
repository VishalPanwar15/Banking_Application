package com.banking;


public class Customer {
    private String name;
    private String account_type;
    private double amount;
    private String accountNumber;

    public Customer() {
    }

    public Customer(String name, String account_type, double amount, String accountNumber) {
        this.name = name;
        this.account_type = account_type;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public Customer(String name, double amount, String accountNumber) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", account_type='" + account_type + '\'' +
                ", amount=" + amount +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
