// Main class to demonstrate the usage of instance, static, void, and parameterized methods
package Application;

import Utils.BankUtils;
import AbstractClasses.StandardAccountType;
import Blueprints.*;
import Exceptions.InsufficientFundsException;
import Services.AccountManager;
import Services.AccountServices;

public class BankSystem {

    public static void main(String[] args) throws InsufficientFundsException {
        // Creating objects (Bank Accounts) from the BankAccount class using constructors

        // Using default constructor
        BankAccount defaultAccount = new BankAccount();
        defaultAccount.checkBalance(); // Should show default values

        // Using parameterized constructor with all details
        BankAccount customAccount = new BankAccount("LazyCoffee", "24", 1500);
        customAccount.checkBalance(); // Should show initialized values

        // Using constructor with only the account holder name (constructor chaining will apply)
        BankAccount simpleAccount = new BankAccount("SimpleUser");
        simpleAccount.checkBalance(); // Should show default balance and account number

        // Accessing the behavior (methods) of the objects

        // Instance Method: Checking the balance of the account
        customAccount.checkBalance();

        // Static Method: Getting the bank name without creating an object
        System.out.println("Bank Name: " + BankAccount.getBankName());

        // Void Method: Depositing an amount of money
        customAccount.deposit(2500);  // Depositing 2500

        // Parameterized Method: Withdrawing an amount of money
        customAccount.withdraw(500);  // Withdrawing 500

        // Check balance again after transactions
        customAccount.checkBalance();

        // Calling different overloaded versions of the deposit method
        customAccount.deposit(100.0);  // Simple deposit
        customAccount.deposit(200.0, "Monthly Salary Deposit");  // Deposit with a message
        customAccount.deposit("CHK123456", 500.0);  // Deposit via check

        // Check final balance after multiple transactions
        customAccount.checkBalance();
        
        
     // SavingsAccount object with interest rate
        SavingsAccount savingsAccount = new SavingsAccount("John Doe", "789456", 2000.0, 5.0);
        savingsAccount.checkBalance();
        savingsAccount.applyInterest();  // Apply interest and check balance again
        savingsAccount.checkBalance();

        // CheckingAccount object with overdraft limit
        CheckingAccount checkingAccount = new CheckingAccount("Jane Smith", "654321", 1000.0, 500.0);
        checkingAccount.checkBalance();
        checkingAccount.withdraw(1200);  // Withdraw within overdraft limit
        checkingAccount.checkBalance();
        checkingAccount.withdraw(500);  // Exceed overdraft limit
        checkingAccount.checkBalance();
        
        // Final Class: PremiumBankAccount
        PremiumBankAccount premiumAccount = new PremiumBankAccount("RichUser", "987654", 10000.0);
        premiumAccount.deposit(2000);
        premiumAccount.printStatement(); // Final method from PremiumBankAccount class
        premiumAccount.withdraw(5000);
        premiumAccount.printStatement();
        
        //Calling the Class and Method from Package 
        BankUtils.printAccountSummary(checkingAccount);  // Using utility function
        
        
        BankAccount account1 = new SavingsAccount("John Doe", "123456", 1000.0, 5.0);
        BankAccount account2 = new CheckingAccount("Jane Smith", "654321", 500.0, 200.0);
        
        // Create an instance of AccountManager (which implements AccountServices)
        AccountServices accountManager = new AccountManager();
        // Transfer funds from account1 to account2
        accountManager.transferFunds(account1, account2, 300.0);

        // Generate statements for both accounts
        accountManager.generateStatement(account1);
        accountManager.generateStatement(account2);
        
        
        // Create an object of StandardAccountType (concrete class extending abstract class)
        StandardAccountType standardAccountType = new StandardAccountType();
        
        // Display account type and benefits using the abstract class methods
        standardAccountType.displayAccountType("Standard");
        standardAccountType.getAccountBenefits();
        
        // Adding Exception handling Logic
        try {
            // Attempt to withdraw more than the balance in SavingsAccount
            savingsAccount.withdraw(1200);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Withdraw within balance in CheckingAccount
		checkingAccount.withdraw(600);  // Within overdraft limit
		// Attempt to withdraw more than the balance and overdraft in CheckingAccount
		checkingAccount.withdraw(1000);

        // Check final balances
        savingsAccount.checkBalance();
        checkingAccount.checkBalance();
        
        
        // Creating Object to include the Enum Account type
        BankAccount savingsAccount_enum = new SavingsAccount("John Doe", "123456", 1000.0, 5.0);
        
     // Check account details and balance
        System.out.println("Savings Account Details:");
        savingsAccount_enum.checkBalance();

    }
}