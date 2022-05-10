// Simulates a basic ATM using accounts created from the "Account" class, that conatins and ID, balance, interest rate, and date created
// ATM functions are withdraws, deposits, and check balance operations.
import java.util.Date;
import java.util.Scanner;
public class ATM {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account[] accounts = new Account[10];
		double initBalance = 100, amount = 0;
		boolean foundId;
		int i, tempId, choice = -1;
		
		// Creates ten accounts with simple IDs for testing
		for (i = 0; i < 10; i++)
			accounts[i] = new Account(i, initBalance);
		
		while(true) {
			
			foundId = false;
			System.out.printf("Enter your account id: ");
			tempId = input.nextInt();
			System.out.printf("\n");
			
			// Checks if the id entered is a valid id
			for (i = 0; i < accounts.length; i++) {
				
				if (tempId == accounts[i].getId()) {
					
					foundId = true;
					break;
					
				}
				
			}
			if (foundId == false) {
				
				System.out.printf("Invalid ID inputted, try again\n\n");
				continue;
			}
			
			// If id is valid, continues to the main menu
			while (choice != 4) {
				
				System.out.printf("Main Menu\n");
				System.out.printf("1: check balance\n");
				System.out.printf("2: withdraw\n");
				System.out.printf("3: deposit\n");
				System.out.printf("4: exit\n");
				System.out.printf("Enter a choice: ");
				
				choice = input.nextInt();
				
				// Performs various account functions based on the customer's choice of option
				switch (choice) {
					
					case 1:
					System.out.printf("Your current balance is $%.2f\n\n", accounts[tempId].getBalance());
					break;
					
					case 2:
					System.out.printf("Enter an amount to withdraw: ");
					amount = input.nextDouble();
					accounts[tempId].withdraw(amount);
					System.out.printf("\n");
					break;
					
					case 3:
					System.out.printf("Enter an amount to deposit: ");
					amount = input.nextDouble();
					accounts[tempId].deposit(amount);
					System.out.printf("\n");
					break;
					
					case 4:
					System.out.printf("Have a great Day!\n\n");
					break;
					
					default:
					System.out.printf("Invalid choice selected, please try again\n\n");
					break;
					
				}
				
			}
			
		}
		
	}
	
	
}

// Class that holds a customer's data (ID, balance, interest rate, and date of creation
// Has methods for withdrawing and depositing
class Account {
	
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	Account() {
		
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
		
	}
	
	Account(int id, double balance) {
		
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
		
	}
	
	int getId() {
		
		return this.id;
		
	}
	void setId(int newId) {
		
		this.id = newId;
		
	}
	
	double getBalance() {
		
		return this.balance;
		
	}
	void setBalance(double newBalance) {
		
		this.balance = newBalance;
		
	}
	
	double getAnnualInterestRate() {
		
		return this.annualInterestRate;
		
	}
	void setAnnualInterestRate(double newAnnualInterestRate) {
		
		this.annualInterestRate = newAnnualInterestRate;
		
	}
	
	Date getDate() {
		
		return this.dateCreated;
		
	}
	
	double getMonthlyInterestRate() {
		
		return this.annualInterestRate / 12;
		
	}
	double getMonthlyInterest() {
		
		return (this.annualInterestRate / 12) * this.balance;
		
	}
	
	void withdraw(double amount) {
		
		this.balance -= amount;
		
	}
	void deposit(double amount) {
		
		this.balance += amount;
		
	}
	
}