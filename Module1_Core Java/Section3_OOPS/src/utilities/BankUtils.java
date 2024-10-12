package utilities;

import accounts.BankAccount;

public class BankUtils {
	// A utility method to print account summary
    public static void printAccountSummary(BankAccount account) {
        System.out.println("BankUtils:\t--------Printing account summary--------");
        account.checkBalance();
    }
}

