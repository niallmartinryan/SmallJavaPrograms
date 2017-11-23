import javax.swing.JOptionPane;
import java.util.Scanner;
public class prepETest 
{

	public static void main(String[] args) 
	{
		String input = JOptionPane.showInputDialog (null,"please enter the number to calculate each number of digits");
		Scanner inputDigit = new Scanner (input);
		int numberInput = inputDigit.nextInt();
		inputDigit.close();
		int divider = 10;
		int firstNumber = numberInput%divider;
		System.out.print("number divider"+ firstNumber);
		int currentNumber = 0;
		
		while ( firstNumber!=currentNumber)
		{
			
		}
	}

}
