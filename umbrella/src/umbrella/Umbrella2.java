package umbrella;
import javax.swing.JOptionPane;

public class Umbrella2 {

	public static void main(String[] args) 
	{
		{
			int questionraining = JOptionPane.showConfirmDialog(null, "Is it raining ?"); 	// Question to determine if it is raining
			
			if (questionraining == JOptionPane.YES_OPTION) 											
			{
				JOptionPane.showMessageDialog(null, "Put up the umbrella ");	// output
			}
			else if (questionraining == JOptionPane.CANCEL_OPTION)
			{
			}
			else															
			{
				int mightitrain = JOptionPane.showConfirmDialog(null, "Does it look like it will rain ?"); 	// Question to determine if it looks like it will rain
				
				if (mightitrain == JOptionPane.YES_OPTION)							
				{
					JOptionPane.showMessageDialog(null, "Bring an umbrella ");	// Output
				}
				else if (mightitrain == JOptionPane.CANCEL_OPTION)
				{	
				}
				else																
				{
					JOptionPane.showMessageDialog(null ,"Do not bring an umbrella");		
				}
			}
		}

	}

}


