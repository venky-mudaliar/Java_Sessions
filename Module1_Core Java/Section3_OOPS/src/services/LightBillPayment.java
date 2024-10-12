package services;

public class LightBillPayment implements PaymentServiceInterface{

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing LightBill payment of $" + amount);	
		
	}

}
