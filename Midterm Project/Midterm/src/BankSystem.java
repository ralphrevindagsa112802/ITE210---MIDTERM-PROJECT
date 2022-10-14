import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class ThreadPause {
    public void wait(int sec) {
        try {
            Thread.currentThread();
           Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class BankSystem {
    private String customerName;
	private int customerChoice;
	private double customerCredit = 50000;
	private double customerCreditAmount;
	private double customerBalance = 50000;
	private int customerDueDate;
	
	ThreadPause TP = new ThreadPause();
	
	
	public void setCustomerChoice(int customerChoice) {
		this.customerChoice = customerChoice;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}
	
	public int getCustomerChoice() {
		return customerChoice;
	}
	
	public int getCustomerDueDate() {
		return customerDueDate;
	}
	
	//Method for displaying Banking System
	@SuppressWarnings("resource")
	public void display() { 
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("=====================================================================");
		System.out.println("~~~~~~~~~~~~BANKING SYSTEM~~~~~~~~~~~~");
		System.out.printf("\nEnter your name: ");
		String name = input.nextLine();
		customerName = name;
		System.out.println("=====================================================================");
		TP.wait(2);
		
	}
	
	//Method for displaying the menu
	@SuppressWarnings("resource")
	public void displayMenu() { 
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("=====================================================================");
		System.out.println("~~~~~~~~~~~~BANKING SYSTEM~~~~~~~~~~~~");
		System.out.println(customerName + ", what type of card do you want to construct with?");
		System.out.println();
		System.out.println("1. Credit");
		System.out.println("2. Debit");
		System.out.println("3. Exit");
		System.out.println("=====================================================================");
		System.out.printf("\nEnter your choice: ");
		int choice = input.nextInt();
		customerChoice = choice;
		TP.wait(2);

	}
	
	 //Method if end user chooses credit option
	@SuppressWarnings("resource")
	public void displayCredit() {
		
		Scanner input = new Scanner(System.in);
		Date thisDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/Y");
		
		System.out.println("=====================================================================");
		System.out.println("~~~~~~~~~~~~CREDIT SYSTEM~~~~~~~~~~~~");
		System.out.println("Total Credit Limit: P" + customerCredit);
		System.out.println("=====================================================================");
		System.out.printf("\nEnter amount to spend: ");
		double amount = input.nextDouble();
		customerCreditAmount = amount;
		customerCredit = customerCredit - amount;
		TP.wait(2);
		
		System.out.println("\n=====================================================================");
		System.out.println("~~~~~~~~~~~~CREDIT SYSTEM~~~~~~~~~~~~");
		System.out.println("Total Credit Limit: P" + customerCredit);
		System.out.println();
		System.out.println("Reminder: To avoid the 3% per day penalty, please settle the amount 30 days after " + dateFormat.format(thisDate) + ".");
		System.out.println();
		System.out.println("When can you pay the P" + amount + "?");
		System.out.println("=====================================================================");
		System.out.printf("\nEnter expected day you can pay the P" + amount + " : ");
		int dueDate = input.nextInt();
		customerDueDate = dueDate;
		TP.wait(2);
		
	}
	
	//Method if end user cannot pay before the deadline
	public void displayPenalty() { 
		
		int dueDate = customerDueDate;
		double percentage = 0;
		double amount = customerCreditAmount;
		
		System.out.println("=====================================================================");
		System.out.println("~~~~~~~~~~~~INTEREST~~~~~~~~~~~~");
		for (int i = 31; i <= dueDate; i++) {
			percentage += amount * .3;
			System.out.printf("\nDay " + i + " = P" + "%.2f",percentage);
		}
		System.out.println("\n=====================================================================");
		TP.wait(3);
	}
	
	//Method if end user chooses debit option, it shows debit system menu
	@SuppressWarnings("resource")
	public void displayDebit() { 
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("=====================================================================");
		System.out.println("~~~~~~~~~~~~DEBIT SYSTEM~~~~~~~~~~~~");
		System.out.println("Total balance of your card: " + customerBalance);
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("=====================================================================");
		System.out.printf("\nEnter your choice: ");
		int choice = input.nextInt();
		TP.wait(2);
			//If end user chooses deposit option
			if(choice == 1) { 
				System.out.println("\n\n\n\n");
				System.out.println("=====================================================================");
				System.out.println("~~~~~~~~~~~~DEPOSIT~~~~~~~~~~~~");
				System.out.println("Total balance of your card: P" + customerBalance);
				System.out.println("=====================================================================");
				System.out.printf("\nEnter amount to deposit: ");
				double amount = input.nextDouble();
				customerBalance += amount;
				TP.wait(2);
				System.out.println("\n\n=====================================================================");
				System.out.println("Total balance of your card: P" + customerBalance);
				System.out.println("=====================================================================");
				TP.wait(3);
			}
			//If end user chooses withdraw option
			else if(choice == 2) { 
				System.out.println("\n\n\n\n");
				System.out.println("=====================================================================");
				System.out.println("~~~~~~~~~~~~WITHDRAW~~~~~~~~~~~~");
				System.out.println("Total balance of your card: P" + customerBalance);
				System.out.println("=====================================================================");
				System.out.printf("\nEnter amount to withdraw: ");
				double amount = input.nextDouble();
				customerBalance -= amount;
				TP.wait(2);
				System.out.println("\n\n=====================================================================");
				System.out.println("Total balance of your card: P" + customerBalance);
				System.out.println("=====================================================================");
				TP.wait(3);
			} 
			else { 
				System.out.println("\n\n\n\n");
				System.out.println("ERROR! Invalid Input...");
				TP.wait(2);
			}
	}
	
	//Method if end user chooses stop option
	public void displayExit() { 
		
		System.out.println("=====================================================================");
		System.out.println("Thanks for using the Banking System, " + customerName + "!!");
		System.out.println("=====================================================================");
		System.out.println();
		System.out.println("Exiting Program...");
		TP.wait(3);
		System.out.println();
		System.out.println("Program exited.");
	}
    
}