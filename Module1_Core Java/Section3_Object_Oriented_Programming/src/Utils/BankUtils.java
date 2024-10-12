package Utils;

import Blueprints.BankAccount;

public class BankUtils {
	// A utility method to print account summary
    public static void printAccountSummary(BankAccount account) {
        System.out.println("Printing account summary:");
        account.checkBalance();
    }
}
