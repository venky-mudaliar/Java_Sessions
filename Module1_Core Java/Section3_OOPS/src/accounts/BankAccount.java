package accounts;

import exceptions.InsufficientFundsException;
import utilities.TransactionType;

public class BankAccount {
	
	// CHAPTER - CLASSES
	// Fields (Attributes)
    public String accountNumber;         // Account number of the bank account
    public double balance;               // Balance of the account
    public String accountHolderName;     // Name of the account holder
    private static String bankName = "XYZ Bank";  // Static bank name shared across all accounts
    
    // CHAPTER - METHODS
    // Instance Method: Method to check the current balance
    // Instance methods require an object to be called.
    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Balance: " + balance);
    }

    // Static Method: Static method to get the bank name
    // Static methods can be called without creating an object.
    public static String getBankName() {
        return bankName;
    }

    // Void Method: Method to deposit money (does not return any value)
    // Void methods perform an action without returning a result.
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;  // Update the balance
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Parameterized Method: Method to withdraw money, accepting the withdrawal amount as a parameter
    // Parameterized methods accept inputs to perform tasks with.
    /*
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;  // Deduct the amount from the balance
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }*/
    // COMMENTING PREV METHOD FOR CHAPTER - EXCEPTIONS - ADDING EXCEPTION LOGIC TO WITHDRAW method
    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientFundsException {
    if (amount > balance) {
        throw new InsufficientFundsException("Insufficient balance. Available balance is: $" + balance);
    }
    balance -= amount;
    System.out.println("Withdrawal of $" + amount + " successful. Remaining balance: $" + balance);
	}


    // CHAPTER - METHOD OVERLOADING
    // Overloaded method to deposit an amount with a message
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
    
    
    /// CHAPTER - CONSTRUCTORS
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
    
    // CHAPTER - FINAL METHODS
    // Final Method: Print Account Details (cannot be overridden)
    public final void printAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    
    
    // CHAPTER ENUMS
    // Method to handle deposit or withdrawal, applying fees and checking balance
    public void performTransaction(double amount, TransactionType transactionType) throws InsufficientFundsException {
        double finalAmount = transactionType.calculateFinalAmount(amount);

        if (transactionType == TransactionType.WITHDRAWAL) {
            if (finalAmount > balance) {
                throw new InsufficientFundsException("Insufficient balance. Available balance: $" + balance);
            }
            balance -= finalAmount;
            System.out.println(transactionType.getDescription() + ": $" + amount + " (Fee: $" + transactionType.getTransactionFee() + "). Remaining balance: $" + balance);
        } else if (transactionType == TransactionType.DEPOSIT) {
            balance += finalAmount;
            System.out.println(transactionType.getDescription() + ": $" + amount + ". New balance: $" + balance);
        }
    }
    
}

