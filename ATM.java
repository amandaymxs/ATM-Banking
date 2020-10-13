
public class ATM {

	public static void main(String[] args) {
		BankAccount newAccount = new BankAccount();
		newAccount.setCustomerName("Katerina");
		newAccount.deposit(200);
		newAccount.withdrawal(-10);
		newAccount.deposit(20);
		newAccount.deposit(10);
		newAccount.deposit(30);
		newAccount.withdrawal(-100);
		newAccount.deposit(15);
		newAccount.deposit(20);
		newAccount.deposit(10);
		newAccount.printTenPreviousTransactions();
		
	}

}
