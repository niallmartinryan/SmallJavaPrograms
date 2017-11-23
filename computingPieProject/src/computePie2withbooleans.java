import java.util.Scanner;
import javax.swing.JOptionPane;


public class computePie2withbooleans
{	
	public static void main(String[] args) 
	{	
		boolean plusMinus = true;
		String termInput = JOptionPane.showInputDialog
				(null, "Please enter the number of terms you wish to view of PI( or type exit) ");
		Scanner inputScanner = new Scanner (termInput);
		if (inputScanner.hasNextInt())
		{	
			double computationNumber1 = 2;
			double computationNumber2 = 3;
			double 	computationNumber3 = 4;
			
			int inputTerms = inputScanner.nextInt();
			inputScanner.close() ;
			int terms = inputTerms ;
			double PI = 0.00;
			while (terms!= 0 )
			{	PI =3.00;
				
				double multiplier = computationNumber1*computationNumber2*computationNumber3;
				double division = 4/multiplier;
				if (plusMinus = true)
				{	
					PI = PI + division ;
					plusMinus = false;
				}
				else if (plusMinus = false)		
				{
					PI = PI - division;
					plusMinus = true;
				}	
				computationNumber1 +=2;
				computationNumber2 +=2;
				computationNumber3 +=2;
				terms --;	
			}	
			JOptionPane.showMessageDialog (null,"PI to "+ inputTerms +" terms is " + PI);
		}
		else
		{
			JOptionPane.showMessageDialog (null,"No valid numbers provided",
										"Error",JOptionPane.ERROR_MESSAGE);
		}
			
	}


}



