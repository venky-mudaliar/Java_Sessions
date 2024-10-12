package accounts;

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
    	System.out.println("Method Overriden from sub sub class");
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Exceeded overdraft limit.");
        }
        super.checkBalance(); // Calling method from Superclass
    }
    
    // Error - Final methods cannot be overridden
    /*
    @Override
    public void printAccountDetails()
    {
    	
    }*/
    
}
