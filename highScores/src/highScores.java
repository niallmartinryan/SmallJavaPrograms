import javax.swing.JOptionPane ;

import java.util.Scanner ; 
public class highScores {

	public static void main(String[] args)
	{
		System.out.print("please enter how many high scores you wish to maintain");
		Scanner scanner = new Scanner (System.in);
		int maxHighScores = scanner.nextInt();
		scanner.close();
		
		boolean finished = true ;
		//int [] scoresArray = {};				// remember syntax for arrays...
		do 
		{
			System.out.print("Please enter your high score or input '-1' to quit");
			Scanner scoreScanner = new Scanner (System.in);
			int nextScore = scoreScanner.nextInt();		// have to be able to continually enter in new high scores...change this.. perhaps while loop..
			if (nextScore == -1)
			{
				finished = false;
			}
					
			//int [] newScoreArray = new int[(scoresArray==null)?1:scoresArray.length+1];
			int [] scoresArray = new int [maxHighScores];
			if (higherThan( nextScore, scoresArray)==true)
			{
				insertScore(nextScore, scoresArray);
			}
		//	if (scoresArray!=null)
			//{
			//	System.arraycopy (scoresArray,0,newScoreArray,0,scoresArray.length);
		//	}
		//	newScoreArray [newScoreArray.length-1]= nextScore;
		//	scoresArray= newScoreArray;
			scoreScanner.close();
		}	while(finished != false);
		
			
	}
	public static void intialiseHighScores (int[] scoresArray)
	{
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
	public static boolean higherThan (int newScore ,int[] scoresArray)
	{
		return newScore> (scoresArray [scoresArray.length-1]);
	}
	public static void insertScore (int newScore, int[] scoresArray)
	{	int index = scoresArray.length;
		int lowerHighScore= 0;
		while (newScore>scoresArray[index])
		{
			scoresArray[scoresArray.length-1]= newScore;
			if (scoresArray[index-1]>scoresArray[index-2])
			{
			lowerHighScore=	scoresArray[index-2];
			scoresArray[index-2]= newScore;
			scoresArray[index-1]= lowerHighScore;
			index--;
			}
		}
	}
}
