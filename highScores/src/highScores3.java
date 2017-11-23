
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner ; 
public class highScores3 
{	/*	This program maintains high scores for a game.
	*
	*/
	
	public static void main(String[] args) 
	{
		System.out.print(
				"please enter how many high scores you wish to maintain");
		Scanner scanner = new Scanner (System.in);
		int maxHighScores = scanner.nextInt();
		boolean finished = true ;
		if (maxHighScores<1)
		{
			finished= false;
			System.out.print("please enter a positive integer");
		}
		try
		{
			int [] scoresArray = new int [maxHighScores];
			intialiseHighScores(maxHighScores,scoresArray);
			do 
			{
				System.out.print(
						"Please enter your high score, -2 to reset highscores to zero or input '-1' to quit");
				int nextScore = scanner.nextInt();	
				if (nextScore<-2)
				{
					finished= false;
					System.out.print("Please enter a positive number");
				}
				else 
				{
					if (nextScore == -1)
					{
						finished = false;
						System.out.print("Goodbye");
					}
					if( nextScore == -2)
					{
						intialiseHighScores(maxHighScores,scoresArray);
					}
					if (higherThan( nextScore, scoresArray)==true&& finished==true)
					{	
						insertScore(nextScore, scoresArray, maxHighScores);
					}
					if (finished==true)
					printHighScores( scoresArray);
					}
			}		while(finished != false);
			scanner.close();
		}
		catch (NullPointerException exception)
		{
		}
		catch (InputMismatchException exception)
		{
			System.out.println("Please enter a valid number ");
		}	
		catch (NegativeArraySizeException exception)
		{
			System.out.println("Please enter a positive number ");
		}	
		catch (NoSuchElementException exception)
		{
		}
		
	}
	public static void intialiseHighScores (int maxHighScores,int[] scoresArray)
	{	
		for (int counter=0;counter<maxHighScores;counter++)
		{
			scoresArray[counter]= 0;
		}
		
	}
	public static void printHighScores (int [] scoresArray)
	{
		System.out.println("The high scores are ");
		for (int index=0; index<scoresArray.length; index++)
		{
			System.out.print(scoresArray[index]);
			System.out.print(" ");
		}
		System.out.println(" ");
	}
	public static boolean higherThan (int nextScore ,int[] scoresArray)
	{
		if (scoresArray == null)
		{
			return true;
		}
		return nextScore> (scoresArray [scoresArray.length-1]);
	}
	public static void insertScore (int nextScore, int[] scoresArray, int maxHighScores)
	{	int index = maxHighScores;
		int lowerHighScore= 0;
		scoresArray[index-1]= nextScore;
		while (index>1 && nextScore>scoresArray[index-2] )
		{
			lowerHighScore=	scoresArray[index-2];
			scoresArray[index-2]= nextScore;
			scoresArray[index-1]= lowerHighScore;
			index--;
		}
	}
}
