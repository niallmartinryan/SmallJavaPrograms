
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;
public class squaredage2.1 ;



	public static void main(String[] args)
	{		String theYear =JOptionPane.showInputDialog("What is the current year");
			Scanner year = new Scanner(theYear);
			int currentYear = year.nextInt();
			int yearsLessThan = currentYear + 123;
			int yearsMoreThan = currentYear - 123;
			int count;
			int squaredAge;
			for (count= 1; count<124; count++)
			{
				squaredAge = count*count;
				
				if (squaredAge < yearsLessThan)
					{
						if (squaredAge >yearsMoreThan)
						{
							System.out.println("Age : "+count +" Year :" + squaredAge );
						}
						
					} 
				
				
				}
			
		}

	}


