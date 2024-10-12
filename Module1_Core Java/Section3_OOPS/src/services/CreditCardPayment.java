package services;

public class CreditCardPayment implements PaymentServiceInterface{

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing credit card payment of $" + amount);		
	}

}
