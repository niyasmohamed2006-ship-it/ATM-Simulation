package ATM;

import java.util.ArrayList;

public class Account {
	int accountNumber;
	double balance;
	ArrayList<Transaction> transaction;
	Account(int accountNumber,double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
		transaction = new ArrayList<>();
	}
	void deposit(double amount) {
		balance += amount;
		transaction.add(new Transaction("Deposit",amount));
		System.out.println("Account Deposited Successfully");
	}
	void withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			transaction.add(new Transaction("Withdraw",amount));
			System.out.println("Amount Withdrawn Successfully");
		}else {
			System.out.println("Insufficient Balance");
		}
	}
	void checkBalance() {
		System.out.println("Current Balance:"+ balance);
	}
	void showTransaction() {
		System.out.println("Transaction History:");
		for(Transaction t : transaction) {
			t.display();
		}
	}
}
