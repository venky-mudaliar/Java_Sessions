// Subclass of BankAccount for savings accounts
package Blueprints;

public class SavingsAccount extends BankAccount {
    double interestRate;

    // Constructor for SavingsAccount
    public SavingsAccount(String accountHolderName, String accountNumber, double balance, double interestRate) {
        super(accountHolderName, accountNumber, balance);  // Call the parent class constructor
        this.interestRate = interestRate;
    }

    // Method specific to apply interest in SavingsAccount
    public void applyInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);  // Reuse the deposit method from BankAccount
        System.out.println("Interest applied: $" + interest);
    }
}
