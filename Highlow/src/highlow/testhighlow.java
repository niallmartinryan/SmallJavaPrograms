package highlow;
import java.util.Random;
import javax.swing.JOptionPane;
public class testhighlow 
{
	public static final int GUESSES_ALLOWED = 4; // constants
	public static final int MAX_NUMBER = 12  ;  // amount of possible cards. ace being high
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
				int currentCard = generator.nextInt(MAX_NUMBER+1);
				String[] buttonOptions = new String[] {"Higher", "Lower", "Equal", "Cancel"};
				int cardChoice = JOptionPane.showOptionDialog(null, "Do you think the card will be higher, lower or equal?", "HighLow",
		    		JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		    		null, buttonOptions, buttonOptions[0]);
				if ( cardChoice == 0)
				{
					if ( currentCard <= initialNumber)
					{
						correct = false;
					}
				}
				else if (cardChoice ==1)
				{
					if (currentCard >= initialNumber)
					{
						correct = false ;
					}
				}
				else if (cardChoice ==2)
				{
					if (currentCard != initialNumber);
					{
						correct = false;
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null,
							"Cancelled");
					counter+=6;
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