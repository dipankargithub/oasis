package oasis_infobyte;

import Transaction.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

    public class Atm_Interface {
        private static ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
        private static Scanner scanner = new Scanner(System.in);
        private static int userId;
        private static int userPin;
        private static boolean loggedIn = false;
        private static int balance = 1000; // initial balance

        public static void main(String[] args)
        {
            // initialize user id and pin
            userId = 62903328;
            userPin = 8583;

            // prompt for user id and pin
            System.out.print("########## WELCOME TO CHAKRABORTY BANK ATM ########## ");
            System.out.print("\nENTER USER ID : ");
            int inputId = scanner.nextInt();
            System.out.print("ENTER USER PIN: ");
            int inputPin = scanner.nextInt();

            // authenticate user
            if (inputId == userId && inputPin == userPin)
            {
                loggedIn = true;
                //   System.out.println("Welcome to CHAKRABORTY BANK ATM ");
                displayMenu();
            }
            else
            {
                System.out.println("INVALID USER ID OR PIN");
            }
        }

        public static void displayMenu() {
            while (loggedIn) {
                System.out.println("\n SELECT ANY OPTION :");
                System.out.println("1. TRANSACTION HISTORY");
                System.out.println("2. WITHDRAW");
                System.out.println("3. DEPOSIT");
                System.out.println("4. TRANSFER");
                System.out.println("5. VIEW BALANCE");
                System.out.println("6. QUIT");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        viewTransactionHistory();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        viewBalance();
                        break;
                    case 6:
                        loggedIn = false;
                        System.out.println("THANK YOU VISIT AGAIN!! ");
                        break;
                    default:
                        System.out.println(" INVALIED CHOICE . PLEASE TRY AGAIN");
                        break;
                }
            }
        }
        public static void viewTransactionHistory()
        {
            if (transactionHistory.size() == 0)
            {
                System.out.println("NO TRANSACTION HISTORY");
            }
        }
        public static void withdraw()
        {
            System.out.print("ENTER AMOUNT TO WITHDRAW : $");
            int amount = scanner.nextInt();
            if (amount > balance)
            {
                System.out.println("INSUFFICIENT BALANCE.");
            }
            else
            {
                balance -= amount;
                Transaction transaction = new Transaction("withdrawal", amount);
                transactionHistory.add(transaction);
                System.out.println("$" + amount + " WITHDRAW SUCCESSFULLY.");
            }
        }
        public static void deposit()
        {
            System.out.print("ENTER AMOUNT TO DEPOSIT: $");
            int amount = scanner.nextInt();
            balance += amount;
            Transaction transaction = new Transaction("deposit", amount);
            transactionHistory.add(transaction);
            System.out.println("$" + amount + " DEPOSIT  SUCCESSFULLY.");
        }
        public static void transfer()
        {
            System.out.print("ENTER RECIPIENT USER ID: ");
            int recipientId = scanner.nextInt();
            System.out.print("ENTER AMOUNT TO TRANSFER: $");
            int amount = scanner.nextInt();
            if (amount > balance)
            {
                System.out.println("INSUFFICIENT BALANCE.");
            }
            else
            {
                balance -= amount;
                Transaction transaction = new Transaction("transfer", amount);
                transactionHistory.add(transaction);
                System.out.println("$" + amount + " transferred to user " + recipientId + " successfully.");
            }
        }
        public static void viewBalance()
        {
            System.out.println("YOUR BALANCE IS: $" + balance);
        }
    }




