import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class BingoCard {
	private int [][][] card= new int[5][5][2];
	
	BingoCard(){
		boolean duplicate=true;
		int currentNum=0;
		int currentMax=15;
		int currentMin=1;
		int offset = 15;
		Random ran = new Random();
		for(int i=0;i<card.length;i++){
			for(int j=0;j<card[1].length;j++){
				card[i][j][1]=0;
				while(duplicate==true){
					duplicate=false;
					currentNum = ran.nextInt((currentMax-currentMin)+1)+currentMin;
					for(int a=0;a<card.length;a++){
						for(int b=0;b<card[1].length;b++){
							if(currentNum==card[a][b][0]){
								duplicate=true;
							}
						}
					}
	//				System.out.println(i);
	//				System.out.println(j);
				}
				duplicate=true;
				card [i][j][0]= currentNum;
				currentMax += offset;
				currentMin += offset;
			}
			currentMax=15;
			currentMin=1;
		}
		card[2][2][1]=1;				// free position
		card[2][2][0]=0;
	}
	void CheckCard(int call){
			for(int j=0;j<card.length;j++){
				for(int k=0;k<card[1].length;k++){
					if(call==card[j][k][0]){
						card[j][k][1]=1;
					}
				}
			}
	}
	boolean winner(){
		boolean winner=true;
		for(int i=0;i<card.length;i++){
			winner=true;
			for(int j=0;j<card[1].length-1;j++){
				if(card[i][j][1]!=card[i][j+1][1]||card[i][j][1]==0){
					winner=false;
				}
			}
			if(winner==true){
				return winner;
			}
		}
		for(int i=0;i<card.length;i++){
			winner=true;
			for(int j=0;j<card[1].length-1;j++){
				if(card[j][i][1]!=card[j+1][i][1]||card[j][i][1]==0){
					winner=false;
				}
			}
			if(winner==true){
				return winner;
			}
		}					//diagonals
		winner=true;
		for(int i=0;i<card.length-1;i++){
			if(card[i][card.length-1-i][1]!=card[i+1][card.length-1-i-1][1]||card[i][card.length-1-i][1]==0){
				winner=false;
			}
		}
		if(winner==true){
				return winner;
			}
		winner=true;
		for(int i=0;i<card.length-1;i++){
			if(card[i][i][1]!=card[i+1][i+1][1]|card[i][i][1]==0){
				winner=false;
			}
		}
		if(winner==true){
			return winner;
		}
		return winner;
	}
	void string(){
		for(int i=0;i<card.length;i++){
			System.out.println(" ");
			for(int j=0;j<card[1].length;j++){
				System.out.print(card[i][j][0]);
				System.out.print(" ");
			}
		}
		for(int i=0;i<card.length;i++){
			System.out.println(" ");
			for(int j=0;j<card[1].length;j++){
				System.out.print(card[i][j][1]);
				System.out.print(" ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		BingoCard test = new BingoCard();
		
	}

}
