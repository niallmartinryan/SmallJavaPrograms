import java.util.Scanner;
import javax.swing.JOptionPane;


public class computingPie4 {
	public static void main(String[] args)
	{	
		String digitInput = JOptionPane.showInputDialog(
									null,"please enter the number of digits you wish to view (between 1-8)");
		Scanner digitInputScanner = new Scanner (digitInput);
		int numberOfDigits = digitInputScanner.nextInt();
		if (digitInputScanner.hasNextInt()&& numberOfDigits < 9 && numberOfDigits > 0)
			{	
				boolean stable = false;
				double tenMul =10;
				int mulNum1 = 2;
				int mulNum2 = 3;
				int	mulNum3 = 4;
			
				double PI = 3.00;
				double count =0;
				for (int count2 =0;count2 != numberOfDigits; count2++) 
				{
					tenMul = tenMul*tenMul;
				}	
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
		
			JOptionPane.showMessageDialog (null,"PI to "+ numberOfDigits +" digits is " + PI);
			digitInputScanner.close();
		}
			
	
	else
	{
		JOptionPane.showMessageDialog (null,"No valid number(s) provided",
										"Error",JOptionPane.ERROR_MESSAGE);
	}
			
	}
	

}
