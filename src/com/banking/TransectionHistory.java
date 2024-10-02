package com.banking;

public class TransectionHistory extends Customer {
    private String transectionType;
    private double previousBalnce;
    private double updateBalance;

    public TransectionHistory(String name, double amount, String transectionType, String accountNumber, double previousBalnce, double updateBalance) {
        super(name,transectionType,amount,accountNumber);
        this.previousBalnce = previousBalnce;
        this.updateBalance = updateBalance;
    }


    public String getTransectionType() {
        return transectionType;
    }

    public void setTransectionType(String transectionType) {
        this.transectionType = transectionType;
    }

    @Override
    public String toString() {
        return super.toString()+ ", previousAmount='" + previousBalnce + '\'' +
                ", currentAmount='" + updateBalance + '\'' +
                '}'+"\n";
    }
}
