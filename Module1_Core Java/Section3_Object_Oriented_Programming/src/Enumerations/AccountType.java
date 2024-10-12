package Enumerations;

public enum AccountType {
	SAVINGS(500) {
        @Override
        public String getBenefits() {
            return "Savings Account Benefits: Earn interest on your savings, lower fees.";
        }
    },
    CHECKING(100) {
        @Override
        public String getBenefits() {
            return "Checking Account Benefits: Unlimited transactions, easy access to funds.";
        }
    },
    PREMIUM(1000) {
        @Override
        public String getBenefits() {
            return "Premium Account Benefits: Higher transaction limits, exclusive services.";
        }
    };

    // Field to hold the minimum balance for each account type
    private final int minimumBalance;

    // Constructor to initialize the minimum balance
    AccountType(int minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    // Method to get the minimum balance
    public int getMinimumBalance() {
        return minimumBalance;
    }

    // Abstract method to get the account benefits (implemented by each enum constant)
    public abstract String getBenefits();
}
