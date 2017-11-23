import java.util.Scanner;

import javax.swing.JOptionPane;


public class PI 
{

	public static void main(String[] args) 
	{
		String termInput = JOptionPane.showInputDialog
				(null, "Please enter the number of terms you wish to view of PI ( or type exit) ");
Scanner inputScanner = new Scanner (termInput);
String digitInput = JOptionPane.showInputDialog(
					null,"please enter the number of digits you wish to view (between 1-8)");
Scanner digitInputScanner = new Scanner (digitInput);
int numberOfDigits = digitInputScanner.nextInt();
digitInputScanner.close();
if (inputScanner.hasNextInt())
{	
double tenMul =10;
int mulNum1 = 2;
int mulNum2 = 3;
int	mulNum3 = 4;
int inputTerms = inputScanner.nextInt();
inputScanner.close() ;
int terms = inputTerms ;
double PI = 3.00;
double count =0;
while (count < numberOfDigits*2 )
{	
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
	count++;	
}
if (numberOfDigits>0)
{	
	for (int count2 =0;count2 != numberOfDigits; count2++) 
	{
		tenMul = tenMul*tenMul;
	}
	Math.ceil(PI);
	PI = PI*tenMul;
	double remainingNumber = PI;
	int numberOfDigitsCounter = numberOfDigits;
	while (numberOfDigitsCounter-1>0)
	{	int tenMul2 =1;
		PI = (remainingNumber % 10)*tenMul2 ;
		PI =remainingNumber+PI;
		tenMul2= tenMul2*10;
	}
	PI= PI/tenMul;
}	
JOptionPane.showMessageDialog (null,"PI to "+ numberOfDigits +" digits is " + PI);
}
else
{
JOptionPane.showMessageDialog (null,"No valid number(s) provided",
						"Error",JOptionPane.ERROR_MESSAGE);
}

	}

}
