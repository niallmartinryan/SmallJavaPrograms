import javax.swing.JOptionPane;

import java.util.Scanner;

public class testing 
{
	public static void main(String[] args)
	{	
		String digitInput = JOptionPane.showInputDialog(
					null,"please enter the number of digits you wish to view (between 1-8)");
		Scanner digitInputScanner = new Scanner (digitInput);
		if (digitInputScanner.hasNextInt())
		{	
			int numberOfDigits = digitInputScanner.nextInt();
			digitInputScanner.close();
			double tenMul =10;
			int mulNum1 = 2;
			int mulNum2 = 3;
			int mulNum3 = 4;
			double PI = 3.00;
			double count =0;
			boolean stable = false;
			while (count < numberOfDigits*2 )
				while ( stable == false )
				{	double PIEstimate = PI;
					double multiplier = mulNum1*mulNum2*mulNum3;
					double division = 4/multiplier;
					if (count %2==0)
					{	
						PI = PI + division ;
					}
					else 		
					{
						PI = PI - division;
					}	
					mulNum1 +=2;
					mulNum2 +=2;
					mulNum3 +=2;
					PI = PI*tenMul;
					int currentPI = (int) PI;
					PI = currentPI / tenMul;
					if (PIEstimate == PI)
					{
						stable =true;
					}
					count++;
				}
				
				
	}	
			JOptionPane.showMessageDialog (null,"PI to "+ numberOfDigits +" digits is " + PI);
	
		else
		{
			JOptionPane.showMessageDialog (null,"No valid number(s) provided",
						"Error",JOptionPane.ERROR_MESSAGE);
		}

	}


}
