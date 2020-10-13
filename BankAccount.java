
public class BankAccount {

	private int balance;
	private int transaction;
	private String transactionDetail;
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
	
	public void previousTransactions() {
		System.out.println(previousTransactionDetails[counter-1]
				+ "\t" + previousTransaction[counter-1]);
	}
	
	public void printTenPreviousTransactions() {
		System.out.println();
	}
}
