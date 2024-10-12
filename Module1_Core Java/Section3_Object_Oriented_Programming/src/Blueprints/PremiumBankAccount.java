// Final Class representing a PremiumBankAccount in a banking system (Cannot be extended)
package Blueprints;

public final class PremiumBankAccount {
    String accountNumber;         
    double balance;               
    String accountHolderName;     
    private static String bankName = "Premium Bank";  

    // Constructor for PremiumBankAccount
    public PremiumBankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Final Method: Print Statement (cannot be overridden by subclasses)
    public final void printStatement() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    // Static Method: Static method to get the bank name
    public static String getBankName() {
        return bankName;
    }
}
