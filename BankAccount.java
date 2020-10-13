import java.util.Random;

public class BankAccount {

	private double balance;
	private String customerName;
	private String customerID;
	private int size = 10000;
	private double[] previousTransaction = new double[size];
	private String[] previousTransactionDetails = new String[size];
	private double[] previousBalance = new double[size]; 
	Random random = new Random();
	int counter = 0;
	
	/*---------------------------------------------------------------------------------------------
	* Default Constructor
	---------------------------------------------------------------------------------------------*/
	public BankAccount(double balance, String customerName, String customerID) {
		this.balance = 0.00;
		this.customerName = "Mickey";
		this.customerID = "M00000";
	}
	
	/*---------------------------------------------------------------------------------------------
	 * Transactions
	 ---------------------------------------------------------------------------------------------*/
	public void withdrawal(double num) {
		verifyArraySize();
		num = Math.round(num*100)/100;		//round to two decimal places
		if (num > 0) {
			System.out.println("Error 10005: Enter a negative amount.");
		} else if ((-num) > balance){
			System.out.println("Error: 10007: Your account balance cannot be negative."
					+ "Your withdrawal cannot exceed " + balance + ".");
		} else {
				balance += num;
		}
	}
	
	public void deposit(double num) {
		verifyArraySize();
		num = Math.round(num*100)/100;		//round to two decimal places
		if (num < 0) {
			System.out.println("Error 10006: Enter a positive amount.");
		} else {
			balance += num;
		}
	}
	
	/*-----------------------------------------------------------------------------------
	 * Setters
	 ------------------------------------------------------------------------------------*/
	public void setCustomerName(String customerName) {
		this.customerName = customerName.toUpperCase();
		setCustomerID(this.customerName);	// Auto generates customerID
	}

	public void setCustomerID(String customerName) {
		this.customerID = customerName.substring(0) + random.nextInt(100000);
	}
	
	/*---------------------------------------------------------------------------------
	 * Getters
	 ----------------------------------------------------------------------------------*/
	
	public double getBalance() {
		return balance;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerID() {
		return customerID;
	}
	
	/*---------------------------------------------------------------------------------------
	 * Print
	 ----------------------------------------------------------------------------------------*/
	public void printPreviousTransactions() {
		System.out.println(customerName + " (" + customerID + ").");
		System.out.println(previousTransactionDetails[counter-1]
				+ "\t" + previousTransaction[counter-1] + "\t"
				+ previousBalance[counter-1]);
	}
	
	public void printTenPreviousTransactions() {
		System.out.println(customerName + " (" + customerID + ").");
		System.out.println("Previous Transactions Newest to Oldest");
		for(int i = counter; i > (counter - 10); i--) {
			System.out.println(previousTransactionDetails[i]
					+ "\t" + previousTransaction[i] + "\t"
					+ previousBalance[i]);
		}
	}
	
	/*------------------------------------------------------------------------------------------
	 * End Transaction
	 ------------------------------------------------------------------------------------------*/
	public void verifyArraySize() {
		if (counter == size) {
			System.out.println("Error 30000: Transaction limit exceeded."
					+ " Transaction unsuccessful.");
			System.exit(0);
		}
	}
	public void exitTransaction() {
		System.out.println(customerName + " (" + customerID +
				") has successfully exited transaction.");
		System.exit(0);
	}
}
