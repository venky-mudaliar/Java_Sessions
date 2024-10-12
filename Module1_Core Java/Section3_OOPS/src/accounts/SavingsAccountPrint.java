package accounts;

public class SavingsAccountPrint extends SavingsAccount{
	
	double printReceipt;

	public SavingsAccountPrint(String accountHolderName, String accountNumber, double balance, double interestRate, double printReceipt)
	{
		super(accountHolderName, accountNumber, balance, interestRate);
		this.printReceipt = printReceipt;
	}
	
	public void printSavingsAccount()
	{
		System.out.println("--- PRINT SAVING ACCOUNT DETAILS ---");
		System.out.println("accountHolderName---"+accountHolderName);
		System.out.println("accountNumber---"+accountNumber);
		System.out.println("balance---"+balance);
		System.out.println("interestRate---"+interestRate);
		System.out.println("printReceipt---"+printReceipt);
		
	}
	
	public void checkBalance() {
		
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Balance: " + balance);
    }
}
