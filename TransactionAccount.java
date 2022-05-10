// Edit the account class to hold an ArrayList of transactions with a small description of each
import java.util.*;
public class TransactionAccount {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		Account[] accounts = new Account[10];
		String[] names = {"Alex", "Brandon", "Charles", "Dimitri", "Ellie", "Francis", "George", "Heidi", "Ivan", "James"};
		double initBalance = 100, amount = 0;
		boolean foundId;
		int i, tempId, choice = -1;
		
		// Test with ten accounts with different names
		for (i = 0; i < 10; i++)
			accounts[i] = new Account(names[i], i, initBalance);
		
		// Always runs
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
			while (choice != 5) {
				
				System.out.printf("Main Menu\n");
				System.out.printf("1: check balance\n");
				System.out.printf("2: withdraw\n");
				System.out.printf("3: deposit\n");
				System.out.printf("4: print account history\n");
				System.out.printf("5: logout\n");
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
					System.out.printf("\nAccount Info\n");
					accounts[tempId].printInfo();
					break;
					
					case 5:
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

// Holds information about each transaction made by an 'Account'
class Transaction {
	
	private Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	Transaction(char type, double amount, double balance, String description) {
		
		this.date = new Date();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
		
	}
	
	Date getDate() {
		
		return this.date;
	}
	
	char getType() {
		
		return this.type;
	}
	
	double getAmount() {
		
		return this.amount;
	}
	
	double getBalance() {
		
		return this.balance;
	}
	
	String getDescription() {
		
		return this.description;
		
	}
	
}

// Contains all information pertaining to a customer's account
// has methods for withdrawing, depositing, and printing all information about the account
class Account {
	
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	private List<Transaction> transactions;
	private String name;
	
	Account() {
		
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
		this.transactions = new ArrayList<>();
	}
	
	Account(String name, int id, double balance) {
		
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.transactions = new ArrayList<>();
		this.annualInterestRate = 1.5;
	}
	
	Account(int id, double balance) {
		
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
		this.transactions = new ArrayList<>();
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
	
	// Withdraws money from an account and adds a new transaction
	void withdraw(double amount) {
		
		this.balance -= amount;
		this.transactions.add(new Transaction('W', amount, this.balance, "Withdraw")); 
		
	}
	
	// Desposits money into the account and adds a new transaction
	void deposit(double amount) {
		
		this.balance += amount;
		this.transactions.add(new Transaction('D', amount, this.balance, "Deposit")); 

	}
	
	// Prints all useful info contained in the account,
	// as well as every transaction made in the current session
	void printInfo() {
		
		System.out.printf("Name: %s\nInterest Rate: %s%%\nBalance: $%s\n\n", 
		this.name, this.annualInterestRate, this.balance);
		
		for (int i = 0; i < this.transactions.size(); i++) {
			
			System.out.printf("Transaction %d: %s of $%.2f\n",
			i + 1, this.transactions.get(i).getDescription(), this.transactions.get(i).getAmount()); 
			
		}
		
	}
	
}