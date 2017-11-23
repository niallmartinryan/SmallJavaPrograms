import java.util.Scanner;

import javax.swing.JOptionPane;

import java.lang.Math;

public class calculationsPrecision 
{
	public static void main(String[] args)
	{	
		String termInput = JOptionPane.showInputDialog
				(null, "Please enter the number of terms you wish to view of PI ( or type exit) ");
		Scanner inputScanner = new Scanner (termInput);
		if (inputScanner.hasNextDouble())
		{	double tenMul =10;
			int mulNum1 = 2;
			int mulNum2 = 3;
			int	mulNum3 = 4;
			int inputTerms = inputScanner.nextInt();
			inputScanner.close() ;
			int terms = inputTerms ;
			double PI = 3.00;
			double count =0;
				while (count < terms )
				{	
					double multiplier = mulNum1*mulNum2*mulNum3;
					double division = 4/multiplier;
					
					if (count %2==0)
					{	
						PI = PI + division ;
						PI = PI*tenMul;
						long currentDigit = (long) PI;
						PI = currentDigit/tenMul;
					}
					else 		
					{
						PI = PI - division;
						PI = PI*tenMul;
						long currentDigit = (long) PI;
						PI = currentDigit/tenMul;
					}	
					tenMul = tenMul *10;
					mulNum1 +=2;
					mulNum2 +=2;
					mulNum3 +=2;
					count++;	
				}
				JOptionPane.showMessageDialog (null,"PI to "+ inputTerms +" terms is " + PI);
			}
			else
			{
			JOptionPane.showMessageDialog (null,"No valid number(s) provided",
										"Error",JOptionPane.ERROR_MESSAGE);
			}
			
	}


}

