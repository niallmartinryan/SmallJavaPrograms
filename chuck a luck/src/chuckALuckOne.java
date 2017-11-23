import java.util.Scanner;
import java.lang.NullPointerException;
import java.lang.NullPointerException;
import javax.swing.JOptionPane;
import java.util.Random;
public class chuckALuckOne {
	public static final int NUMBER_SIDES_DICE = 6;
	public static final int NUMBER_OF_DICE = 3;
	public static void main(String[] args) {
		boolean playing = true;
		boolean won = true;
		boolean triple =false;
		int multiplier = 1;
		String moneyInput = JOptionPane.showInputDialog(null,"how much money would you like to place on the table");
		Scanner moneyScanner = new Scanner(moneyInput);
		int moneyOnTable = moneyScanner.nextInt();
		try {
			Wallet wallet = new Wallet();
			wallet.put(moneyOnTable);
			if(moneyOnTable==0){
				playing=false;
				JOptionPane.showMessageDialog(null,"no money on the table ");
			}
			while(playing==true){
				String[] options = {"Triple" ,"Big","Field","Small"};
				String[] options2 = {"yes","no"};
				int makeBet = JOptionPane.showConfirmDialog(null,"would you like to make a bet?");
				if (makeBet==0){
					double currentWallet =wallet.check();
					int input=JOptionPane.showOptionDialog(null,"Please select the bet you wish to make ","you have "+currentWallet+" on the table",JOptionPane.OK_OPTION
							,0,null,options,options[2]);
					String inputBet = JOptionPane.showInputDialog(null,"how much would you like to bet","Current Balance= "+currentWallet);
					Scanner betScanner=new Scanner(inputBet);
					int bet = betScanner.nextInt();
					//String betName = scanner.next();
					//int bet =scanner.nextInt();
					Dice dice = new Dice(NUMBER_SIDES_DICE);
					Dice dice1 = new Dice (NUMBER_SIDES_DICE);
					Dice dice2 = new Dice (NUMBER_SIDES_DICE);
					Dice arrayDice[] = {dice,dice1,dice2};
					int results[] =new int [3];
					for(int count = 0; count<=arrayDice.length-1;count++){
						results[count]= (arrayDice[count]).roll();			
					}
					int total =0;
					for(int count=0;count<=results.length-1;count++){
						total += results[count];
					}
					if(input==0){
						if (results[0]==results[1] &&results[1]==results[2]&&results[2]==results[0]){
							won=true;
							triple=true;
						}
						else{
							won=false;
							triple=false;
						}
					}
					else if(total>=11 && input==1){
						won =true;
					}
					else if((total>12||total<8) && input==2){
						won =true;
					}
					else if(total<=10 && input ==3){
						won=true;
					}
					else{
						won=false;
					}
					if(won==true&&triple==true){
						multiplier = 30;
					}
					if(won==true){
						wallet.put((bet*multiplier));
						JOptionPane.showMessageDialog(null,"YOU ARE A WINNER!! you won.. " +wallet.check());
					}
					else{
						wallet.get(bet);
						JOptionPane.showMessageDialog(null, "HAHAHAHAH... you Lost "+ "current balance = " +wallet.check());
						double money= wallet.check();
						if(money<=0){
							playing=false;
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Thanks for playin ");
					playing=false;
				}
			}
	
			}
			catch(java.lang.NullPointerException exception){	
			}
			catch(java.util.InputMismatchException exception){
				JOptionPane.showMessageDialog(null,"please enter valid input");
			}
			
	}
}