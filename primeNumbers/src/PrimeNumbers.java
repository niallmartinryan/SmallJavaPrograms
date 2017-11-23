import java.util.Scanner;

import javax.swing.JOptionPane ;
public class PrimeNumbers {

	public static void main(String[] args) 
	{	int currentNumber = 0;
		boolean itsAPRIME = true;
		int currentNumChk = 0;
		int numChkFinder = 0;
		int maxNum =0;
		String input = JOptionPane.showInputDialog (null,"please enter the maximum integer that primes are to be found");
		Scanner inputScanner = new Scanner (input);
		maxNum = inputScanner.nextInt();
		inputScanner.close();
		for (currentNumChk=2; currentNumChk<= maxNum; currentNumChk++)
		{
			for (numChkFinder=2; numChkFinder< currentNumChk; numChkFinder++)
			{
				currentNumber = currentNumChk% numChkFinder ;
				if (currentNumber ==0)
				{
					itsAPRIME = false ;
					// its not a prime lads
				}
				else {}
			}
			if (itsAPRIME==true)
			{
				JOptionPane.showMessageDialog(null, "IT IS A PRIME NUMBER LADS :"+ currentNumChk);
			}
			else {}
		}
		

	}

}
