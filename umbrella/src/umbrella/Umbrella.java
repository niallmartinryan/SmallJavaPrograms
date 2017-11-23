package umbrella;
import javax.swing.JOptionPane;

public class Umbrella 		/* This program gives the best option to take if it is raining, if it looks like its going to rain 
										or if it is not raining
				*/
{

	public static void main(String[] args) 
	{
		int questionraining = JOptionPane.showConfirmDialog(null, "Is it raining ?"); 	// Question to determine if it is raining
		boolean raining = (questionraining == JOptionPane.YES_OPTION);	// Checking if answer is yes, and putting it in variable raining
		if (raining)											
		{
			JOptionPane.showMessageDialog(null, "Put up the umbrella ");	// output
			
		}							
		else															
		{
			 int mightitrain = JOptionPane.showConfirmDialog(null, "Does it look like it will rain ?"); 	// Question to determine if it looks like it will rain
			boolean mightItRain = (mightitrain == JOptionPane.YES_OPTION); 		// checking if answer is yes, and putting into the variable (mightItRain)			
			if (mightItRain)							
			{
				JOptionPane.showMessageDialog(null, "Bring an umbrella ");	// Output
			}
			else																
			{
				JOptionPane.showMessageDialog(null ,"Do not bring an umbrella");		
			}
		}
	}

}
