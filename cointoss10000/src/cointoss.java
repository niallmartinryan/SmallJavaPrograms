import java.util.Random;
import javax.swing.JOptionPane;

public class cointoss 
{
	
	public static final int NO_OF_THROWS = 10000 ;
	public static void main(String[] args) 
	{	int heads = 0;
		int tails = 0;
		
		int randomNumber =0 ;
		int count = 0;
		Random generator = new Random();
		for (count = 0; count < NO_OF_THROWS; count= count+1 )
		{   
			randomNumber = generator.nextInt(2);
			if (randomNumber == 1)
			{
			heads +=  1;
			}
			else
			{
			tails += 1;
			}
		}
		if (count == NO_OF_THROWS)
		{	JOptionPane.showMessageDialog(null, "The number of Tails was " + tails +" The number of Heads was " + heads);
			if (randomNumber == 1)
			{
				JOptionPane.showMessageDialog (null,"The last toss was a heads");
			}
			else
			{
				JOptionPane.showMessageDialog (null,"The last toss was a tails");
			}
		
		}
		
		
			
		}
	}



