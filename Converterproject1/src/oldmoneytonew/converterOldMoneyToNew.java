package oldmoneytonew;
import java.util.Scanner;
import javax.swing.JOptionPane;

	public class converterOldMoneyToNew {
		
		public static final int OLD_SHILLINGS_PER_OLD_POUND = 20;// creating static values for currency
		public static final int OLD_PENNIES_PER_OLD_SHILLINGS = 12;	
		public static final int NEW_PENNIES_PER_OLD_PENNIES = 67;
		public static final int NEW_PENNIES_PER_NEW_POUND = 100;
		public static void main(String[] args)
		{
			String totalOldMoneyInput =JOptionPane.showInputDialog(	// getting input using scanner
								"insert amounts of old money (pounds : shillings : pennies)");
			Scanner inputScanner = new Scanner (totalOldMoneyInput);
			inputScanner.useDelimiter(":");							// using delimiter to separate input values
			int oldPounds = inputScanner.nextInt();
			int oldShillings = inputScanner.nextInt();
			int oldPennies = inputScanner.nextInt();
			inputScanner.close();
			
			int totalConvertedShillings = oldPounds * OLD_SHILLINGS_PER_OLD_POUND ; //converting all old pounds to old shillings
			int totalConvertedOldPennies = (totalConvertedShillings + oldShillings) * // converting all old shillings to old pennies
														OLD_PENNIES_PER_OLD_SHILLINGS;
			double totalConvertedPennies =(totalConvertedOldPennies + oldPennies) 	// converting all old pennies to new pennies 
												* NEW_PENNIES_PER_OLD_PENNIES;
			double totalNewPounds = totalConvertedPennies / NEW_PENNIES_PER_NEW_POUND; // converting all new pennies to new pounds
			
			JOptionPane.showMessageDialog(null,				// output of value in New Pounds
					"Your converted amount of pounds and pennies is " + 
					totalNewPounds );
			
			
		}	
}
