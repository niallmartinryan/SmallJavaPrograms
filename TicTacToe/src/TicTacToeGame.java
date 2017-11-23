import java.util.Scanner;
import java.awt.Color;
import java.util.Random;

public class TicTacToeGame {
	public static final int BOARD_HEIGHT_WIDTH=3;
	public static final int PLAYER_ONE = 1;
	public static final int PLAYER_TWO = 2;
	private boolean winner;
	private int type = 1;
	private TicTacToeBoard game;
	public TicTacToeGame(){
		game = new TicTacToeBoard();
	}
	public int[] chooseSquare(int type, int row, int column){
		int[] location;
		if(game.isSquareFull(row, column)==false){
			game.move(type, row, column);
			return location = new int[]{row,column};
		}
		else{
			System.out.println("Sorry, that square already has a piece in it");
			return null;
		}
	}
	public void play(){
		boolean playing =true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tic-Tac-Toe");
		System.out.println(game.toString());
		while(playing==true){
			while(winner==false && game.isBoardFull()==false){
				if(type==1){
					System.out.println("Player 1- enter where you wish to move a piece ('row column')");
				}
				else{
					System.out.println("Player 2- enter where you wish to move a piece ('row column')");
				}
				int row = scanner.nextInt();
				int column = scanner.nextInt();
				if(row<0 ||row>BOARD_HEIGHT_WIDTH ||column>BOARD_HEIGHT_WIDTH || column<0){
					System.out.println("Please choose a valid position");
				}
				else{
					if(null!=chooseSquare(type,row, column)){

						if(type==PLAYER_ONE){
							type=PLAYER_TWO;				
						}
						else{
							type=PLAYER_ONE;
						}
					}
					else{
						System.out.println("Please choose a different location");
					}
					if(game.winner()){
						winner=true;
					}
					System.out.println(game.toString());
				}
				if(winner==true){
					if(game.isBoardFull()){
						System.out.println("It seems it has ended in a draw"); // add more to this.. maybe ask if they want to quit or play again etc
					}
					else{
						if(type==PLAYER_ONE){
							System.out.println("Player 2 has won the game");
						}
						else{
							System.out.println("Player 1 has won the game");
						}
					}
					boolean answer =false;
					while(answer==false){
						System.out.println("Do you wish to continue playing? 'yes','no'");
						String keepPlaying = scanner.next();
						if(keepPlaying.equals("no")){
							playing=false;
							winner=true;
							answer=true;
						}
						else if(keepPlaying.equals("yes")){
							game.resetBoard();
							winner=false;
							answer= true;
							type = 2;						//switches who starts the game
						}
						else{
							System.out.println("its one or the other");
						}
					}
				}
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.play();
	}

}
