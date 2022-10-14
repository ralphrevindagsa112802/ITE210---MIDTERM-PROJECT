public class Main {
    
    public static void main(String[] args) {
        
        BankSystem system = new BankSystem();
		
		//Welcome display, end user inputs name
		system.display(); 
		System.out.println("\n\n\n\n");
		
		while (system.getCustomerChoice() != 3) {
			
			//End user selects if Credit or Debit
			system.displayMenu();
			System.out.println("\n\n\n\n");
			
			
			switch (system.getCustomerChoice()) {
			case 1:
				//If end user chooses credit
				system.displayCredit();
				System.out.println("\n\n\n\n");
				
				//If end user cannot pay before the deadline
				if (system.getCustomerDueDate() > 30)
					system.displayPenalty();
				System.out.println("\n\n\n\n");
					
				break;
				
			case 2:
				//If end user chooses debit
				system.displayDebit();
				System.out.println("\n\n\n\n");
				break;
				
			case 3:
				//If end user chooses exit
				system.displayExit();
				break;

			default:
				//If end user enters an option out of the given options
				System.out.println("ERROR! Invalid Input....");
				System.out.println("\n\n\n\n");
				break;
            }
        }
    }
}
