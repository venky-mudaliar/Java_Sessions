package exceptions;

//Custom exception class for insufficient funds
public class InsufficientFundsException extends Exception {

// Constructor that accepts a custom message
public InsufficientFundsException(String message) {
   super(message);
}
}
