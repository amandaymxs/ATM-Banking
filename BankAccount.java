
public class BankAccount {

	private int balance;
	private String customerName;
	private int customerID;
	private int size = 100;
	private double[] previousTransaction = new double[size];
	private String[] previousTransactionDetails = new String[size];
	private double[] previousBalance = new double[size]; 
	
	int counter = 0;
	
	public int getBalance() {
		return balance;
	}
	
	public String customerName() {
		return customerName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void previousTransactions() {
		System.out.println(previousTransactionDetails[counter-1]
				+ "\t" + previousTransaction[counter-1] + "\t"
				+ previousBalance[counter-1]);
	}
	
	public void printTenPreviousTransactions() {
		System.out.println("Previous Transactions Newest to Oldest");
		for(int i = counter; i > (counter - 10); i--) {
			System.out.println(previousTransactionDetails[i]
					+ "\t" + previousTransaction[i] + "\t"
					+ previousBalance[i]);
		}
	}
	
}
