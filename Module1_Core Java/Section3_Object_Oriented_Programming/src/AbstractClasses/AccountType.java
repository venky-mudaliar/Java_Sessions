package AbstractClasses;

public abstract class AccountType {
	// Concrete method to display the account type
    public void displayAccountType(String accountType) {
        System.out.println("This is a " + accountType + " account.");
    }
    
    // Abstract method to get account benefits
    public abstract void getAccountBenefits();
}
