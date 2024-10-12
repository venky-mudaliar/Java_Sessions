// Class representing a bank account in a banking system
package Blueprints;

import Enumerations.AccountType;
import Exceptions.InsufficientFundsException;

public class BankAccount {
    // Fields (Attributes)
    public String accountNumber;         // Account number of the bank account
    public double balance;               // Balance of the account
    public String accountHolderName;     // Name of the account holder
    private static String bankName = "ABC Bank";  // Static bank name shared across all accounts
    
    protected AccountType accountType;  // Add account type field


    // Constructors

    // Default Constructor
    public BankAccount() {
        // Calling the parameterized constructor with default values
        this("Unknown", "000000", 0.0);
    }

    // Parameterized Constructor (full parameters)
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Constructor with only account holder name
    public BankAccount(String accountHolderName) {
        // Calling the parameterized constructor with default balance and account number
        this(accountHolderName, "000000", 1000.0);  // Default balance and account number
    }

    // Instance Method: Method to check the current balance
    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Balance: " + balance);
    }

    // Static Method: Static method to get the bank name
    public static String getBankName() {
        return bankName;
    }

    // Void Method: Method to deposit money (does not return any value)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Parameterized Method: Method to withdraw money
    // Adding Exception logic for Chapter 25
    public void withdraw(double amount) throws InsufficientFundsException
    { 
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
            throw new InsufficientFundsException("Insufficient funds for withdrawal. Available balance: " + balance);
        }
    }

    // Overloaded method to deposit with a message
    public void deposit(double amount, String message) {
        balance += amount;
        System.out.println(message);
        System.out.println("Deposited: $" + amount);
        System.out.println("New Balance: $" + balance);
    }

    // Overloaded method to deposit a check
    public void deposit(String checkNumber, double amount) {
        balance += amount;
        System.out.println("Deposited check #" + checkNumber + " for $" + amount);
        System.out.println("New Balance: $" + balance);
    }
    
 // Final Method: Print Account Details (cannot be overridden)
    public final void printAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    
    
    
    // Cibnstrucotr to include the Addition field from Enums
    public BankAccount(String accountHolderName, String accountNumber, double balance, AccountType accountType) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

}