// Subclass of BankAccount for checking accounts with overdraft limit
package Blueprints;

public class CheckingAccount extends BankAccount {
    double overdraftLimit;

    // Constructor for CheckingAccount
    public CheckingAccount(String accountHolderName, String accountNumber, double balance, double overdraftLimit) {
        super(accountHolderName, accountNumber, balance);  // Call the parent class constructor
        this.overdraftLimit = overdraftLimit;
    }

    // Overriding the withdraw method to account for overdraft
    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Exceeded overdraft limit.");
        }
    }
}
