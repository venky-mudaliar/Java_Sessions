
public class Ch31_StringBuilder_StringBuffer {
public static void main(String[] args) {
        
        // 1. Using StringBuilder to Generate Transaction Summaries
        System.out.println("---- Using StringBuilder ----");
        
        StringBuilder transactionSummary = new StringBuilder();
        
        String customerName = "John Doe";
        String accountNumber = "SA12345";
        double depositAmount = 1000.0;
        double withdrawalAmount = 500.0;
        
        transactionSummary.append("Transaction Summary for ").append(customerName).append(":\n")
                          .append("Account Number: ").append(accountNumber).append("\n")
                          .append("Deposited: $").append(depositAmount).append("\n")
                          .append("Withdrew: $").append(withdrawalAmount).append("\n")
                          .append("Current Balance: $").append(depositAmount - withdrawalAmount);
        
        System.out.println(transactionSummary.toString());
        
        // 2. Using StringBuffer to Maintain a Transaction Log
        System.out.println("\n---- Using StringBuffer ----");
        
        StringBuffer transactionLog = new StringBuffer();
        
        // Adding first transaction
        transactionLog.append("Customer: ").append(customerName)
                      .append(", Account: ").append(accountNumber)
                      .append(", Deposited: $").append(depositAmount).append("\n");
        
        // Adding another transaction
        String customerName2 = "Jane Smith";
        String accountNumber2 = "SA54321";
        double depositAmount2 = 2000.0;
        transactionLog.append("Customer: ").append(customerName2)
                      .append(", Account: ").append(accountNumber2)
                      .append(", Deposited: $").append(depositAmount2).append("\n");
        
        // Adding a withdrawal transaction for the first customer
        double withdrawalAmount2 = 300.0;
        transactionLog.append("Customer: ").append(customerName)
                      .append(", Account: ").append(accountNumber)
                      .append(", Withdrew: $").append(withdrawalAmount2).append("\n");
        
        // Print the transaction log
        System.out.println(transactionLog.toString());
        
        // 3. Comparing Performance of StringBuilder vs StringBuffer
        System.out.println("---- Performance Comparison ----");
        
        // Using StringBuilder for performance comparison
        StringBuilder builder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            builder.append("Transaction ").append(i).append(": Completed.\n");
        }
        long endTimeBuilder = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTimeBuilder - startTimeBuilder) + " ns");
        
        // Using StringBuffer for performance comparison
        StringBuffer buffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            buffer.append("Transaction ").append(i).append(": Completed.\n");
        }
        long endTimeBuffer = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTimeBuffer - startTimeBuffer) + " ns");
    }
}
