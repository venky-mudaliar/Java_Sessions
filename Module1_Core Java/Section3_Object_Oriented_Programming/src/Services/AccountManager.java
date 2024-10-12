package Services;

import Blueprints.BankAccount;
import Exceptions.InsufficientFundsException;

public class AccountManager implements AccountServices {

	@Override
	public void transferFunds(BankAccount fromAccount, BankAccount toAccount, double amount) throws InsufficientFundsException {
		if (fromAccount == null || toAccount == null) {
            System.out.println("Invalid account(s) provided.");
            return;
        }

        if (amount > 0 && fromAccount.balance >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred $" + amount + " from " + fromAccount.accountNumber + " to " + toAccount.accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid transfer amount.");
        }
		
	}

	@Override
	public void generateStatement(BankAccount account) {
		if (account != null) {
            System.out.println("Account Statement:");
            System.out.println("Account Holder: " + account.accountHolderName);
            System.out.println("Account Number: " + account.accountNumber);
            System.out.println("Balance: $" + account.balance);
        } else {
            System.out.println("Invalid account provided.");
        }
		
	}
}
