package com.banking;

import java.util.Scanner;

public class UserInterface {
   int choice;
   ServiceImplementation service = new ServiceImplementation();
    public void ServiceInterface(String accountNumber){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("SBI Bank These are the our Services ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. History Transaction");
            System.out.println("5. Logout");

            System.out.println("Enter what you want from above service");
            choice = scanner.nextInt();
            switch (choice){
                case 1 :
                    System.out.println("Current Balance :"+service.checkBalance(accountNumber));
                    break;
                case 2 :
                    System.out.println("Enter the amount you want to Deposite");
                    double depositeAmt = new Scanner(System.in).nextDouble();
                    while (depositeAmt <0) {
                        System.out.println("Invalid amount negative not allowed please enter again");
                        depositeAmt = new Scanner(System.in).nextDouble();
                    }
                    service.depositeAmount(depositeAmt,accountNumber);
                    break;
                case 3 :
                    System.out.println("Enter amount you want to withdraw");
                    double withdrawAmt = scanner.nextDouble();
                    service.withdrawAmount(withdrawAmt,accountNumber);
                    break;
                case 4:
                    System.out.println("****** HISTORY  OF TRANSACTION *******");
                    service.repo.showHistory();
                    break;
                case 5:
                    System.out.println("Logout Successful");
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }while (choice!= -1);
    }
}
