package Services;

import Blueprints.BankAccount;
import Exceptions.InsufficientFundsException;

public interface AccountServices {
	// Transfer funds between two accounts
    void transferFunds(BankAccount fromAccount, BankAccount toAccount, double amount) throws InsufficientFundsException;

    // Generate a simple account statement
    void generateStatement(BankAccount account);
}
