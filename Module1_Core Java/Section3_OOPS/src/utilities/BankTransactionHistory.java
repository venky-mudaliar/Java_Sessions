package utilities;

import java.util.ArrayList;

// CHAPTER 27 - Trype Wrappers, Autoboxing and Unboxing
public class BankTransactionHistory {
    private ArrayList<Double> transactionAmounts;  // Using the Double wrapper class

    public BankTransactionHistory() {
        this.transactionAmounts = new ArrayList<>();  // Autoboxing will happen when adding primitives
    }

    // Method to add a transaction (demonstrating autoboxing)
    public void addTransaction(double amount) {
        transactionAmounts.add(amount);  // Autoboxing: primitive 'double' is automatically converted to 'Double'
        System.out.println("Transaction of $" + amount + " added.");
    }

    // Method to calculate the total of all transactions (demonstrating unboxing)
    public double calculateTotalTransactions() {
        double total = 0.0;

        for (Double transaction : transactionAmounts) {
            total += transaction;  // Unboxing: 'Double' is automatically converted to 'double'
        }

        return total;
    }

    // Method to print the transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (Double transaction : transactionAmounts) {
            System.out.println("$" + transaction);  // Unboxing: Double to double for display
        }
    }
}