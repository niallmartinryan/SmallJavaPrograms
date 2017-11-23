package typeOfVertebrates;
import javax.swing.JOptionPane ;



public class TypesofVertebrates2 
{

	public static void main(String[] args) 
	{
		int answer = JOptionPane.showConfirmDialog(null,
				"Does the vertebrate have fins?");
		boolean fins = (answer == JOptionPane.YES_OPTION);
		if (fins)
		{
				System.out.print ("The vertebrate is a fish");
		}
		else 
		{
				answer =JOptionPane.showConfirmDialog(null, "Is the Vertebrate coldblooded");
				boolean coldblooded = (answer == JOptionPane.YES_OPTION);
				if (coldblooded)
				{
							answer =JOptionPane.showConfirmDialog(null, "does the Vertebrate have moist skin");
							boolean moistskin = (answer == JOptionPane.YES_OPTION);
							if (moistskin)
							{
							System.out.print("The Vertebrate is a Amphibian");
							}
							else
							{ 
							System.out.print("The Vertebrate is a Reptile");
							}
				}
				else
				{
							answer =JOptionPane.showConfirmDialog(null,"Does the Vertebrate have feathers");
							boolean feathers = (answer == JOptionPane.YES_OPTION);
							if (feathers)
							{
									System.out.print("The Vertebrate is a Bird");
							}
							else
							{
							System.out.print("The Vertebrate is a Mammal");
							}
				}
							
		}
			
		}
			
				

	}


