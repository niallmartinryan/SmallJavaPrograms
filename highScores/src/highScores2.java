import javax.swing.JOptionPane ;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner ; 
public class highScores2 
{
	
	public static void main(String[] args) 
	{
		String input= JOptionPane.showInputDialog(null,
				"please enter how many high scores you wish to maintain");
		Scanner scanner = new Scanner (input);
		int maxHighScores = scanner.nextInt();
		scanner.close();
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
				String inputScores =JOptionPane.showInputDialog(null,
						"Please enter your high score or input '-1' to quit");
				Scanner scoreScanner = new Scanner (inputScores);
				int nextScore = scoreScanner.nextInt();		
				if (nextScore == -1)
				{
					finished = false;
				}
				if (higherThan( nextScore, scoresArray)==true)
				{	
					insertScore(nextScore, scoresArray, maxHighScores);
				}
				printHighScores( scoresArray);
				scoreScanner.close();
			}		while(finished != false);
		}
		catch (NullPointerException exception)
		{
		}
		catch (InputMismatchException exception)
		{
			System.out.print("Please enter a valid number");
		}	
		catch (NegativeArraySizeException exception)
		{
			System.out.print("Please enter a positive number");
		}	
		catch (NoSuchElementException exception)
		{
		}
	}
	public static void intialiseHighScores (int maxHighScores,int[] scoresArray)
	{	scoresArray = new int [maxHighScores];
		for (int counter=0;counter<scoresArray.length;counter++)
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
