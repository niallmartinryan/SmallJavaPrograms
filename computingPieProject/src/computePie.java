import javax.swing.JOptionPane;
import java.util.Scanner;
import java. ;
public class computePie 
{	public static final int FIRST_DIGIT = 3;
	public static void main(String[] args) 
	{	boolean correctInput = false ;
		while (correctInput = false)
		{
			String termInput = JOptionPane.showInputDialog
					(null, "Please enter the number of terms you wish to view of PI( or type exit) ");
			Scanner inputScanner = new Scanner (termInput);
			if (inputScanner.hasNextInt())
			{
				int terms = inputScanner.nextInt();
				inputScanner.close() ;
			
		
				while (terms!= 0 ) 
				{
					
				}
			}
			else
			{
				JOptionPane.showMessageDialog (null,"No valid numbers provided",
											"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
