import java.util.Scanner;
import java.util.Random;

import javax.swing.JOptionPane;

public class highLow {

	public static final int GUESSES_ALLOWED = 4;
	public static void main(String[] args) {
		boolean playing=true;
		boolean correct=true;
		boolean badInput=false;
		int winCounter;
		DeckOfCards deck = new DeckOfCards();
		PlayingCard currentCard;
		
		try{
			System.out.println("Hello, welcome to HighLow!");
			while(playing==true){
			winCounter=0;
			deck.shuffle();
			PlayingCard guessCard;
			correct=true;
			System.out.println("Would you like to play, type 'yes' or 'no'");
			Scanner scanner = new Scanner(System.in);
			String play = scanner.next();
			if(play.equals("yes")){
				currentCard = deck.deal();
				while (correct==true){
					guessCard = deck.deal();
					System.out.println("Your card is a " + 
							currentCard.toPictograph()+" "+ currentCard.toString());
					System.out.println("Will the next Card be 'higher', 'lower' or 'equal' ");
					String guess = scanner.next();
					
					if (guess.equals("higher")){
						if (currentCard.isRankLessThan(guessCard)){
							if(currentCard.isRankEqual(guessCard)){
								correct=false;
							}
						}
						else correct=false;
					}
					else if(guess.equals("lower")){
						if (currentCard.isRankLessThan(guessCard)){
							correct=false;
						}
						if(currentCard.isRankEqual(guessCard)){
							correct=false;
						}
						
					}
					else if(guess.equals("equal")){
						if(currentCard.isRankEqual(guessCard)){
							
						}
						else correct=false;
					}
					else{
						badInput=true;					
						}
					if(correct==true&& badInput!=true){
						System.out.println("You were correct, the next card was a "+guessCard.toPictograph()+" "+ guessCard.toString());
						winCounter+=1;
					}
					else if(badInput==false){
						System.out.println("you were incorrect, the next card was a "+guessCard.toPictograph()+" "+ guessCard.toString());
					}
					if (badInput!=true){
					currentCard=guessCard;
					}
					else{
						System.out.println("Please enter a valid command");	
					}
					if(winCounter==GUESSES_ALLOWED){
						System.out.println("YEAH! you won the game.. goodjob!");
						correct=false;
					}
				}
			}
				
			else if(play.equals("no")){
				playing=false;
				System.out.print("Goodbye");
			}
			else{
				System.out.println("Please enter a valid command");
			}
			}
		}
		catch(NullPointerException exception){
			
		}
		catch(java.util.NoSuchElementException exception){
			
		}

	}

}
