package highlow;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.Random;
public class Highlow 
/*
 * simulates the game High Low, ace being high
 */
{	
	public static final int GUESSES_ALLOWED = 4; // constants
	public static final int MAX_NUMBER = 12;  // amount of possible cards. ace being high
	public static void main(String[] args) 
	{	
		try
		{
			int counter =0;
			Random generator = new Random ();
			int initialNumber = generator.nextInt(MAX_NUMBER);
			boolean correct = true ;
			while (correct==true && counter<GUESSES_ALLOWED)
			{	
				if(initialNumber==9)
				{
					JOptionPane.showMessageDialog(null,"The card is a jack");
				}	
				else if(initialNumber==10)
				{
					JOptionPane.showMessageDialog(null,"The card is a queen");
				}
				else if (initialNumber==11)
				{
					JOptionPane.showMessageDialog(null,"The card is a king");
				}
				else if (initialNumber==MAX_NUMBER)
				{
					JOptionPane.showMessageDialog(null,"The card is a ace");
				}
				else JOptionPane.showMessageDialog(null,"The card is a " + (initialNumber+2));	 
				// plus 2 to account for the for the fact 0 and 1 are also integers but not used in game																			
				int currentCard = generator.nextInt(MAX_NUMBER+1);								
				String HiLoInput = JOptionPane.showInputDialog(null, 	
						"Please enter whether you think the card will be Higher ('>'), Lower ('<') or equal('=')");
				Scanner input = new Scanner (HiLoInput) ;
				String inputAnswer = input.nextLine();
				input.close();
				if ( inputAnswer.equals(">"))
				{
					if ( currentCard <= initialNumber)
					{
						correct = false;
					}
				}
				else if (inputAnswer.equals("<"))
				{
					if (currentCard >= initialNumber)
					{
						correct = false ;
					}
				}
				else if (inputAnswer.equals("="))
				{
					if (currentCard != initialNumber);
					{
						correct = false;
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null,
							"Invalid input, try typing in one of the suggested options");
					counter+=6;				// to break out of the loop
				}
				counter++ ;
				initialNumber = currentCard ;
			}
			if (counter ==4 && correct == true)
			{
				JOptionPane.showMessageDialog(null, "Well done, you have won HiLo");
			}
			else if (counter >=6)
			{}
			else 
			{
				JOptionPane.showMessageDialog(null, "Unlucky, you have lost the game");
			}
		}
		catch (NullPointerException exception)
		{
		}
		catch (java.util.NoSuchElementException exception2)
		{
			JOptionPane.showMessageDialog(null,"No response entered");
		}
	}
}
