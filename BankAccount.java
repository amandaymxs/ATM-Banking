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
	int idNum;

	/*---------------------------------------------------------------------------------------------
	* Default Constructor and Constructors
	---------------------------------------------------------------------------------------------*/
	public BankAccount() {
		this.balance = 0.00;
		this.customerName = "MICKEY";
		this.customerID = "M00000";
	}

	public BankAccount(double balance, String customerName) {
		this.balance = balance;
		setCustomerName(customerName);
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
		idNum = random.nextInt(100000);
		String stringIDNum = Integer.toString(idNum);
		this.customerID = customerName.charAt(0) + stringIDNum;
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
		System.out.printf("Your current balance is $%.2f.\n", balance);
	}
		
	public void printPreviousTransactions() {
		System.out.println("\n" + customerName + " (" + customerID + ").");

		if (counter == 0) {
			System.out.println("No previous transactions available.");
		} else {
			System.out.println("\nTransaction Details\tAmount\tBalance");
			System.out.printf(previousTransactionDetails[counter - 1] + "\t\t\t$ %.2f\t$ %.2f\n",
					previousTransaction[counter - 1], previousBalance[counter - 1]);
		}
	}

	public void printTenPreviousTransactions() {
		System.out.println("\n" + customerName + " (" + customerID + ").");
		if (counter == 0) {
			System.out.println("No previous transactions available.");
		} else if (counter < 10){
				System.out.println("Previous Transactions Newest to Oldest");
				System.out.println("\nTransaction Details\tAmount\tBalance");
				for (int i = counter-1; i >= 0; i--) {
					System.out.printf(previousTransactionDetails[i] + "\t\t\t$ %.2f\t$ %.2f\n",
							previousTransaction[i], previousBalance[i]);

				}
			} else {
			System.out.println("Previous Transactions Newest to Oldest");
			System.out.println("\nTransaction Details\tAmount\tBalance");
			for (int i = counter-1; i > (counter - 10); i--) {
				System.out.printf(previousTransactionDetails[i] + "\t\t\t$ %.2f\t$ %.2f\n",
						previousTransaction[i], previousBalance[i]);

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
