import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class BingoGame {
	private BingoCard[] cards;
	public static final int MAX = 75;
	public static final int MIN = 1;
	private int numbersCalled;
	
	private ArrayList<Integer> callerArray=new ArrayList<Integer>();
	BingoGame(BingoCard[]card){
		cards = card;
		numbersCalled =0;
	}
	void play(){
		
	}
	void checkCards(){
		int callNumber =callNumber();
		for(int i=0;i<cards.length;i++){
			BingoCard card = cards[i];
			card.CheckCard(callNumber);
		}
	}
	int callNumber(){
		Random rand = new Random();
		int call = 0;
		boolean called=false;
		if(callerArray.size()!=0){
			while(called==false){
				called=true;
				call = rand.nextInt((MAX-MIN)+1)+MIN;
				for(int i=0;i<callerArray.size();i++){
					if(call==(int) callerArray.get(i)){
						called=false;
					}
				}
			}
		}
		else{
			call = rand.nextInt((MAX-MIN)+1)+MIN;
		}
		callerArray.add(call);
		numbersCalled+=1;
		return call;
	}
	boolean allCalled(){
		if(callerArray.size()==75){
			return true;
		}
		else{
			return false;
		}
		
	}
	 void string(){
		 for(int i=0;i<cards.length;i++){
			 BingoCard card = cards[i];
			 card.string();
		 }
	}
	 boolean winner(){
		 boolean winner=false;
		 for(int i=0;i<cards.length;i++){
			 BingoCard card = cards[i];
			 if(card.winner()==true){
				 winner=true;							// could make this one line
			 }
		 }
		 return winner;
	 }
	 int numbersCalled(){
		 return numbersCalled;
	 }
	 
	public static void main(String[] args) {
		

	}

}
