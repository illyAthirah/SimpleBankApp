
//import built in class scanner to read user input
import java.util.Scanner;

public class Account {
	//declare Class variables
	int balance;
	int prevTransaction;
	String custName;
	String custID;
	
	//Class constructor
	Account(String cname, String cid){
		
		custName = cname;
		custID = cid;
	
	}
	
	//function for make deposit money
	void deposit(int amount) {
		
		if (amount != 0) {
			balance = balance + amount;
			prevTransaction = amount;
		}
	}
	
	//function for withdraw money
	void withdrawal(int amount) {
		
		if (amount !=0) {
			balance = balance - amount;
			prevTransaction = -amount;
		}
	}
	
	//function show prev transaction
	void getPrevTransaction() {
		
		if (prevTransaction > 0) {
			System.out.println("Deposited: " + prevTransaction);
		} else if (prevTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(prevTransaction));
		} else {
			System.out.println("No Transaction Happened");
		}
		
	}
	
	//function calculate interest of current funds after a number of X years
	void calculateInterest(int years) {
		double interestRate = .0155;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("Current interest rate is " + (100 * interestRate));
		System.out.println("Balance after " + years + " years: " + newBalance);
	
	}
	
	//function show main menu
	void mainMenu() {
		
		char option = '\0';
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Welcome, " + custName + "!");
			System.out.println("Your Id: " + custID);
			System.out.println();
			System.out.println("Choose option to continue: ");
			System.out.println();
			System.out.println("A. Check balance");
			System.out.println("B. Make deposit");
			System.out.println("C. Make withdrawal");
			System.out.println("D. View previous transaction");
			System.out.println("E. Calculate interest");
			System.out.println("F. Exit");
			
			do {
				
				System.out.println();
				System.out.println("Enter an option: ");
				char option1 = scanner.next().charAt(0);
				option = Character.toUpperCase(option1);
				System.out.println();
				
				switch(option) {
				//'A' allows user to check account balance
				case 'A' :
					System.out.println("#############################################");
					System.out.println("Balance = RM " + balance);
					System.out.println("#############################################");
					System.out.println();
					break;
				//'B' allows user deposit money into their account
				case 'B' : 
					System.out.println("Enter deposit amount: ");
					int amount = scanner.nextInt();
					deposit(amount);
					System.out.println();
					break;
				//'C' allows user to withdraw money from their account
				case 'C' :
					System.out.println("Enter withdraw amount: ");
					int amount2 = scanner.nextInt();
					withdrawal(amount2);
					System.out.println();
					break;
				//'D' allows user to view their most recent transaction
				case 'D' :
					System.out.println("###############################################");
					getPrevTransaction();
					System.out.println("###############################################");
					System.out.println();
					break;
				//'E' calculates the accrued interest on the account after X years
				case 'E' :
					System.out.println("Enter how many years of accrued interest: ");
					int years = scanner.nextInt();
					calculateInterest(years);
					break;
				//'F' exits the user from account
				case 'F' :
					System.out.println("################################################");
					break;
				//the default case let's user know that they entered an invalid characters
				default:
					System.out.println("Error: invalid option. Please enter A, B, C, D or E to access services. Enter F for exit services");
					break;
					
				}
			}	while(option != 'F');
		}
		System.out.println("Thank you for use our service!");
	}
	
	

}

