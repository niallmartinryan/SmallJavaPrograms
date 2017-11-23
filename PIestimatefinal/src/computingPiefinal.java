import java.util.Scanner;
import javax.swing.JOptionPane;
public class computingPiefinal 
{			// estimates PI to a number of requested digits
	public static void main(String[] args)
	{	
		String digitInput = JOptionPane.showInputDialog(		//input
									null,"please enter the number of digits you wish to view (between 1-8)");
		Scanner digitInputScanner = new Scanner (digitInput);
		if (digitInputScanner.hasNextInt())
		{
			int numberOfDigits = digitInputScanner.nextInt();
			if ( numberOfDigits < 9 && numberOfDigits > 0)
				{	double targetPI = 0;
					double targetEstimate = 0;
					boolean stable = false;
					double tenMul =1;
					int mulNum1 = 2;
					double PI = 3.00;
					int count2 =0;
					int count =0;
					while ( count2 < numberOfDigits )	// could of used math.pow but did'nt think you were allowed
					{
						tenMul = tenMul*10;
						count2 ++;
					}
					while ( stable == false ) 			// computation, while loop
					{	double PIEstimate = PI;
						targetEstimate = PIEstimate;
						double multiplier = mulNum1*(mulNum1+1)*(mulNum1+2);
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
						targetEstimate = PIEstimate*tenMul;				// truncating target estimate of PI
						int currentPIestimate = (int)targetEstimate;
						targetEstimate = currentPIestimate/tenMul;
					
						targetPI = PI*tenMul;					// truncating current estimate of PI
						int currentPI = (int) targetPI;
						targetPI = currentPI/tenMul;
						if (targetEstimate == targetPI)			// boolean if estimate is equal to PI
						{
							stable =true;
						}
						count++;
					}
				JOptionPane.showMessageDialog (null,"PI to "+ numberOfDigits +" digits is " + targetPI);	// output
				System.out.print("PI"+ targetPI);
				digitInputScanner.close();
			}
			else			
			{
				JOptionPane.showMessageDialog (null,"No valid number(s) provided",
										"Error",JOptionPane.ERROR_MESSAGE);
			}
		}	
		else
		{
			JOptionPane.showMessageDialog (null,"No valid number(s) provided",
									"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}