package com.banking;

import com.banking.ServiceImplementation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankManagementSystem {

    public static void main(String[] args) {
        int choice = -1;

//       To use the method like register customer, valid customer or not to use this functionality
//        crete login inside ServiceImplementation class and use that functionality using object
        ServiceImplementation service = new ServiceImplementation();

//        To take input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ********* Welcome to the SBI Bank ***********");

        do {
            System.out.println("To Create an Account Enter : 1");
            System.out.println("Already have an Account? Login Enter : 2");
            System.out.println("To exit the application Enter : -1");

//            If user by mistake enter any string value than to handle that we use try-catch block
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, please enter only an integer value");
                scanner.next();  // Clear the invalid input
                continue;  // Skip to the next iteration
            }

//      there is multiple choice to the use create account,login and exit from application that's why we use switch statement
            switch (choice) {
                case 1:
                    service.registerCustomer();
                    service.customerData();
                    break;

                case 2:
                    System.out.println("Enter your name:");
                    String name = scanner.next();
                    System.out.println("Enter your account number:");
                    String accountNumber = scanner.next();

                    if (service.checkCustomer(name, accountNumber)) {
                        UserInterface user = new UserInterface();
                        user.ServiceInterface(accountNumber);
                    } else {
                        System.out.println("You are not a registered customer. Please register first.");
                    }
                    break;

                case -1:
                    System.out.println("Exiting the application. Thank you for using SBI Bank!");
                    scanner.close();  // Close the scanner
                    return;

                default:
                    System.out.println("Invalid choice, please select a valid option.");
                    break;
            }
        } while (true);
    }
}
