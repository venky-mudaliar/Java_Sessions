package customer;

public class CustomerDetails {
	
	private String customerName;
	private String customerAddress;
	private String customerNominee;
	
	public CustomerDetails(String customerName, String customerAddress,
			String customerNominee) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerNominee = customerNominee;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", customerNominee=" + customerNominee + "]";
	}

	
	

}
