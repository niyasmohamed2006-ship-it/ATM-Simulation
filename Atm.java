package ATM;

import java.util.HashMap;
import java.util.Scanner;

public class Atm {
	static HashMap<Integer,Account> accounts = new HashMap<>();
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		accounts.put(1001, new Account(1001,5000));
		System.out.println("Enter Account Number: ");
		int accNo = sc.nextInt();
		if(!accounts.containsKey(accNo)) {
			System.out.println("Account Not Found!");
			return;
		}
		Account user = accounts.get(accNo);
		int choice;
		do {
			System.out.println("\n===== ATM MENU =====");
			System.out.println("1. Check balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Transaction History");
			System.out.println("5. Exit");
			System.out.println("Enter Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				user.checkBalance();
				break;
				
			case 2:
				System.out.println("Enter Amount to Deposit: ");
				double depositAmount = sc.nextDouble();
				user.deposit(depositAmount);
			case 3:
				System.out.println("Enter Amount to Withdraw: ");
				double withdrawAmount = sc.nextDouble();
				user.withdraw(withdrawAmount);
				break;
			case 4:
				user.showTransaction();
				break;
			case 5:
				System.out.println("Thank You!");
				break;
			default:
				System.out.println("Invalid Choice!");
			}
		}while (choice != 5);
		sc.close();
	}
}