/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctu.gertdaffie.ctubankingapp;

import java.util.Scanner;

/**
 *
 * @author unico
 */
public class BankingAppv2 {
 
    public static void main(String args[]){
        
        /* Defined Variables */
        
        Scanner scan = new Scanner(System.in);
        int mainMenu = 0;
        int monthsEntered = 0;
        double deposit = 0;

        double withdraw;
        double balance = 0;
        double savings = 0;
        double simpleSavings = 0;
        double compoundSavings = 0;
        double interest = 0;
        double interestAmount = 0;
        double simpleInterest = 0;
        double compoundInterest = 0;
        int interestType = 0;
        
        /* Loop main menu */

        while (mainMenu != 999){ 
            switch(mainMenu){
                case 0:         /* Main Menu */
                    System.out.println("==============================");
                    System.out.println("CTU BANKING APPLICATION");
                    System.out.println("1.Account Info");
                    System.out.println("2.Deposit into account");
                    System.out.println("3.Deposit into savings");
                    System.out.println("4.Withdraw from account");
                    System.out.println("5.Withdraw from savings");
                    System.out.println("6.Exit Application");
                    System.out.println("ENTER THE NUMBER REPRESENTING YOUR CHOICE:");
                    mainMenu = scan.nextInt();
                    System.out.println("==============================");
                    break;
                
                case 1:         /* Display all account info  */
                    System.out.println("ACCOUNT INFO");
                    System.out.println("Debit Account Balance: R" + balance); 
                    System.out.println("\nSAVINGS ACCOUNT INFO");                
                    System.out.println("Interest Amount: R" + interestAmount);
                    System.out.println("Total Savings Balance: R" + savings);
                    System.out.println("\nPress 0 to exit back to Main Menu.. ");
                    mainMenu = scan.nextInt();
                    
                    break;
              
                case 2:         /* Deposit Into Debit Account */
                    System.out.println("Current Debit balance: R" + balance);
                    System.out.println("Enter deposit amount: ");
                
                    deposit = scan.nextDouble(); 
                    balance = balance + deposit;
                
                    System.out.println("\nNew Debit balance: R" + balance);
                    System.out.println("\nPress 0 to exit back to Main Menu.. ");
                    mainMenu = scan.nextInt();
                    break;
                    
                case 3:         /* Deposit Into Savings Account */
                    System.out.println("\nCurrent savings balance: R" + savings);
                    System.out.println("\nEnter deposit amount: ");
                    deposit = scan.nextDouble();
                    
                            /* Interest Calculation */ 
                    if (deposit >= 100 && deposit <= 500){
                        interest = 0.5;
                    }
                    else if (deposit > 501 && deposit <= 1000){
                        interest = 2;
                    }
                    else if (deposit > 1000){
                        interest = 5;
                    }
                    
                    System.out.println("\nEnter amount of months to save: ");
                    monthsEntered = scan.nextInt();
                    System.out.println("\nSelect interest type:");
                    System.out.println("1. Simple");
                    System.out.println("2. Compound");
                    interestType = scan.nextInt();
                    
                    switch(interestType){
                        case 1:         /* Simple Interest Calculation */
                            simpleInterest = (deposit * (interest / 100)) * monthsEntered;
                            simpleSavings = simpleInterest + deposit;
                            System.out.println("Savings amount after " + monthsEntered + " months of simple interest= R" + simpleSavings + "\n");
                            break;
                            
                        case 2:         /* Compound Interest Calculation */
                            compoundSavings = deposit * Math.pow((1 + interest / 100), monthsEntered * monthsEntered);
                            compoundInterest = compoundSavings - deposit;
                            System.out.println("Compound savings amount after " + monthsEntered + " months of compound interest= R" + compoundSavings + "\n");
                            break;
                            
                                        /* Invalid Option Handling */
                        default:
                            System.out.println("Please enter a valid option!");
                            interestType = scan.nextInt();
                    }
                    interestAmount = simpleInterest + compoundInterest;
                    savings = simpleSavings + compoundSavings;
                    System.out.println("Total savings amount after interest: R" + savings);
                    System.out.println("\nPress 0 to exit back to Main Menu.. ");
                    mainMenu = scan.nextInt();
                    break;
                    
                case 4:         /* Withdraw From Debit Account */
                    System.out.println("Debit Balance: R" + balance + "\n");
                    System.out.println("Enter withdraw amount: ");
                    withdraw = scan.nextDouble();
                    
                    
                                /* Insuccicient Funds Handling */
                    if (withdraw > balance){
                        System.out.println("INSUFFICIENT FUNDS!\n");
                        System.out.println("Please enter a valid amount: ");
                        break;
                    }
                    else {
                        balance = balance - withdraw;
                        System.out.println("New Debit balance: R" + balance + "\n");
                    }
                    
                    System.out.println("\nPress 0 to exit back to Main Menu.. ");
                    mainMenu = scan.nextInt();
                    break;
                    
                case 5:         /* Withdraw From Savings Account */
                    System.out.println("Savings Balance: R" + savings + "\n");
                    System.out.println("Enter withdraw amount: ");
                    withdraw = scan.nextDouble();
                    
                                /* Insuccicient Funds Handling */
                    if (withdraw > savings){
                        System.out.println("INSUFFICIENT FUNDS!!\n");
                        System.out.println("Please enter a valid amount: ");
                        break;
                    }
                    else {
                        savings = savings - withdraw;
                        System.out.println("New savings balance: R" + savings + "\n");
                    }
                    
                    System.out.println("\nPress 0 to exit back to Main Menu.. ");
                    mainMenu = scan.nextInt();
                    break;
                    
                case 6:         /* Exit Application */
                    System.out.println("Thank you for using the CTU Banking Application!");
                    System.out.println("==============================");
                    System.exit(0); 
                    
                default:       /* Invalid Option Handling */
                    System.out.println("Please enter a valid option!!");
                    mainMenu = 0;
                    }
            }
        }
    }

                           

