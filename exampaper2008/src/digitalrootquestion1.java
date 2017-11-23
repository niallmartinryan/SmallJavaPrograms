import javax.swing.JOptionPane;

import java.util.Scanner;
public class digitalrootquestion1 
{

	public static void main(String[] args) 
	{	int addedDigits2 = 0;
		int addedDigits3 = 0;
		int digitalRoute = 0;
		int originalNumber = 0;
		int digit;
		int addedDigits = 0;
		int userNumber = 0;
		String whatIsYourNumber = JOptionPane.showInputDialog(null, "Please enter your number");
		Scanner numberInput = new Scanner(whatIsYourNumber);
		originalNumber = numberInput.nextInt();
		numberInput.close();
		userNumber = originalNumber ;
		
		while (userNumber > 0) 
		{
				
				digit =userNumber % 10;
				userNumber = userNumber / 10;
				addedDigits += digit;
		}
		if (addedDigits>9)
		{	while (addedDigits>0)
		
			{
				digit = addedDigits% 10 ;
				addedDigits = addedDigits /10;
				addedDigits2 += digit ;		
			}	
		}	
		if (addedDigits2>9)
		{
			while (addedDigits2>0)
			{
				digit = addedDigits%10;
				addedDigits2 = addedDigits2/10;
				addedDigits3 += digit ;
			}
		}
		JOptionPane.showMessageDialog(null,"The Digital route is : " + addedDigits3 );
	}
		
}


