package oldmoneytonew;
import java.util.Scanner;
import javax.swing.JOptionPane;

	public class Oldmoneytonew {
		
		public static final double OLD_SHILLINGS_PER_OLD_POUND = 20;// creating static values for currency
		public static final double OLD_PENNIES_PER_OLD_SHILLINGS = 12;	
		public static final double NEW_PENNIES_PER_OLD_PENNIES = 67;
		public static final double NEW_PENNIES_PER_NEW_POUND = 100;
		public static void main(String[] args)
		{
			String totalOldMoneyInput =JOptionPane.showInputDialog(	// getting input using scanner
								"insert amouts of old money (pounds : shillings : pennies)");
			Scanner inputScanner = new Scanner (totalOldMoneyInput);
			inputScanner.useDelimiter(":");							// using delimiter to separate input values
			double oldPounds = inputScanner.nextDouble();
			double oldShillings = inputScanner.nextDouble();
			double oldPennies = inputScanner.nextDouble();
			inputScanner.close();
			
			double totalConvertedShillings = oldPounds * OLD_SHILLINGS_PER_OLD_POUND ; //converting all old pounds to old shillings
			double totalConvertedOldPennies = (totalConvertedShillings + oldShillings) * // converting all old shillings to old pennies
														OLD_PENNIES_PER_OLD_SHILLINGS;
			double totalConvertedPennies =(totalConvertedOldPennies + oldPennies) 	// converting all old pennies to new pennies 
												* NEW_PENNIES_PER_OLD_PENNIES;
			double totalNewPounds = totalConvertedPennies / NEW_PENNIES_PER_NEW_POUND; // converting all new pennies to new pounds
			
			JOptionPane.showMessageDialog(null,				// output of value in New Pounds
					"Your converted amount of pounds and pennies is " + 
					totalNewPounds );
			
			
		}	
}
