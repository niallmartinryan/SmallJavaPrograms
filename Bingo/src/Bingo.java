import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Bingo {
	public static int cardCallsToWin =0;

	public static void main(String[] args) {
		int numberOfPlayers;
		double currentAverage;
		int sampleSize;
		double additionScores = 0;
		boolean playingBingo =true;
		boolean inGame=true;
		System.out.println("Welcome to bingo");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Sample size?");
		sampleSize = scanner.nextInt();
		System.out.println("Calculate 1-500?");
		numberOfPlayers = scanner.nextInt();
		for(int i=0;i<sampleSize;i++){
			BingoCard[] cards= new BingoCard[numberOfPlayers];
			for(int j=0;j<numberOfPlayers;j++){
				cards[j]= new BingoCard();
			}
			BingoGame game= new BingoGame(cards);
			while(inGame==true){
				game.checkCards();
				if(game.winner()==true){
					inGame=false;
				}
				if(game.allCalled()==true){
					System.out.println("OHHH...All the numbers have been called");
					inGame=false;
				}
				//game.string();
			}
			
			inGame=true;
			additionScores += game.numbersCalled();
			currentAverage = additionScores/i;
			System.out.println("current average = "+ currentAverage);
		}
	}
}
