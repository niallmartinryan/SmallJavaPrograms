import java.util.Scanner ; 
import javax.swing.JOptionPane;
			/* This program prints out the Age and Year of anyone who is currently alive in a selected year, 
			 * if the Maximum range of their age is 123 and
			 * the persons age is the square of the year that they are alive in
			 *  
			 */
public class squaredAge3
{
	public static final int MAXIMUM_RANGE = 123;		//defining constants
	public static void main(String[] args) 				
	{
		String theYear =JOptionPane.showInputDialog("What is the current year");		//input for current year
		Scanner year = new Scanner(theYear);
		int currentYear = year.nextInt();
		year.close();
		int yearsLessThan = currentYear + MAXIMUM_RANGE;			
		int yearsMoreThan = currentYear - MAXIMUM_RANGE;
		int count;
		int squaredAge;
			for (count= 1; count<(MAXIMUM_RANGE+1); count++)			// computation
			{
			squaredAge = count*count;
			
			if (squaredAge < yearsLessThan)
				{
					if (squaredAge >yearsMoreThan && squaredAge - count <= currentYear )
					{
						System.out.println("Age : "+count +" Year :" + squaredAge );			// output
					}
					
				} 

		}

	}
}