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
	* Default Constructor and Constructors
	---------------------------------------------------------------------------------------------*/
	public BankAccount() {
		this.balance = 0.00;
		this.customerName = "Mickey";
		this.customerID = "M00000";
	}

	public BankAccount(double balance, String customerName, String customerID) {
		this.balance = balance;
		this.customerName = customerName;
		this.customerID = customerID;
	}

	/*---------------------------------------------------------------------------------------------
	 * Transactions
	 ---------------------------------------------------------------------------------------------*/
	public void withdrawal(double num) {
		verifyArraySize();
		if (num > 0) {
			System.out.println("Error 10005: Enter a negative amount.");
		} else if ((-num) > balance) {
			System.out.printf("Error: 10007: Your account balance cannot be negative."
					+ "Your withdrawal cannot exceed $%.2f", balance);
			System.out.println(".");
		} else {
			balance += num;
			System.out.printf("Withdrawal of $%.2f", num); 
			System.out.println(" is completed.");
			previousTransaction[counter] = num;
			previousTransactionDetails[counter] = "Withdrawal";
			previousBalance[counter++] = balance;
		}
	}

	public void deposit(double num) {
		verifyArraySize();
		if (num < 0) {
			System.out.println("Error 10006: Enter a positive amount.");
		} else {
			balance += num;
			System.out.printf("Deposit of $%.2f", num); 
			System.out.println(" is completed.");
			previousTransaction[counter] = num;
			previousTransactionDetails[counter] = "Deposit";
			previousBalance[counter++] = balance;
		}
	}

	/*-----------------------------------------------------------------------------------
	 * Setters
	 ------------------------------------------------------------------------------------*/
	public void setCustomerName(String customerName) {
		this.customerName = customerName.toUpperCase();
		setCustomerID(this.customerName); // Auto generates customerID
	}

	private void setCustomerID(String customerName) {
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
	public void printBalance() {
		System.out.printf("Your current balance is $%.2f", balance);
		System.out.println(".");
	}
		
	public void printPreviousTransactions() {
		if (counter == 0) {
			System.out.println("No previous transactions available.");
		} else {
			System.out.println(customerName + " (" + customerID + ").");
			System.out.print(previousTransactionDetails[counter - 1] + "\t");
			System.out.printf("$%.2f", previousTransaction[counter - 1]);
			System.out.print("\t");
			System.out.printf("$%.2f", previousBalance[counter - 1]);
			System.out.println();
		}
	}

	public void printTenPreviousTransactions() {
		if (counter == 0) {
			System.out.println("No previous transactions available.");
		} else {
			System.out.println(customerName + " (" + customerID + ").");
			System.out.println("Previous Transactions Newest to Oldest");
			for (int i = counter; i > (counter - 10); i--) {
				System.out.printf("$%2f", previousTransactionDetails[i]);
				System.out.print("\t");
				System.out.printf("$%.2f", previousTransaction[i]);
				System.out.print("\t");
				System.out.printf("$%.2f", previousBalance[i]);
				System.out.println();
			}
		}
	}

	/*------------------------------------------------------------------------------------------
	 * End Transaction
	 ------------------------------------------------------------------------------------------*/
	public void verifyArraySize() {
		if (counter == size) {
			System.out.println(" Transaction unsuccessful.");
			System.out.println("Error 30000: Transaction limit exceeded.");
			System.exit(0);
		}
	}

	public void exitTransaction() {
		System.out.println(customerName + " (" + customerID +
				") has successfully exited transaction.");
		System.exit(0);
	}
}
