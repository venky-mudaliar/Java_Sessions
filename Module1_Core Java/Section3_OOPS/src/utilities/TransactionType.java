package utilities;

public enum TransactionType {
	DEPOSIT("Deposit into account", 0.0),
    WITHDRAWAL("Withdrawal from account", 5.0); // Fixed fee for withdrawals

    private String description;
    private double transactionFee;

    // Constructor for the enum
    TransactionType(String description, double transactionFee) {
        this.description = description;
        this.transactionFee = transactionFee;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Getter for the transaction fee
    public double getTransactionFee() {
        return transactionFee;
    }

    // Method to calculate the total amount after applying the transaction fee
    public double calculateFinalAmount(double amount) {
        if (this == WITHDRAWAL) {
            return amount + transactionFee; // Adding fee for withdrawals
        }
        return amount; // No fee for deposits
    }
}
