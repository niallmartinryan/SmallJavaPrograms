public class TicTacToeBoard {
	private int [][] boardArray;
	public static final int BOARD_HEIGHT_WIDTH=3;
	public TicTacToeBoard(){
		boardArray = new int [3][3];
		for(int i=0;i<BOARD_HEIGHT_WIDTH;i++){
			for(int j=0;j<BOARD_HEIGHT_WIDTH;j++){
				boardArray[i][j]= 0;
			}
		}
	}
	public boolean isSquareFull(int row, int column){
			return boardArray[row][column]!=0;
			
	}
	public boolean move(int type, int row, int column ){
		if(boardArray[row][column]!=0){
			return false;
		}
		else{
			boardArray [row][column]=type;
			return true;
		}
	}
	public boolean isBoardFull(){
		for(int i=0;i<boardArray.length;i++){
			for( int j=0;j<boardArray.length;j++){
			
				if(boardArray[i][j]==0){
					return false;
				}
			}
		}
		return true;
	}
	public boolean winner(){
		for(int i=0;i<BOARD_HEIGHT_WIDTH;i++){
			int j=0;
			if(boardArray[i][j]!=0&&boardArray[i][j]==boardArray[i][j+1]&&boardArray[i][j+1]==boardArray[i][j+2]){
				return true;
			}
		}
		for(int j=0;j<BOARD_HEIGHT_WIDTH;j++){ 
			int i=0;
			if(boardArray[i][j]!=0&&boardArray[i][j]==boardArray[i+1][j]&&boardArray[i+1][j]==boardArray[i+2][j]){
				return true;
			}
		}
		int i=0;
		if(boardArray[i][i]!=0&&boardArray[i][i]==boardArray[i+1][i+1]&& boardArray[i+1][i+1]== boardArray[i+2][i+2]){
			return true;		
			}
		if(boardArray[i][i+2]!=0&&boardArray[i][i+2]==boardArray[i+1][i+1]&& boardArray[i+1][i+1]==boardArray[i+2][i]){
			return true;
		}
		return false;
	}
	public String toString(){
		char [][]boardString = new char[3][3]; 
		for(int i=0;i< boardArray[0].length;i++){
			for(int j=0;j<boardArray[1].length;j++){
				if(boardArray[i][j]==1){
					boardString[i][j] = 'X';
				}
				else if(boardArray[i][j]==2){
					boardString[i][j]= 'O';
				}
				else{
					boardString[i][j]= ' ';
				}
			}
		}
		return "   0   1   2\n \u250C\u2500\u2500\u2500\u252C\u2500\u2500\u2500\u252C\u2500\u2500\u2500\u2510" +"\n0\u2502 "+ boardString[0][0] + " \u2502 "+ boardString[0][1] + " \u2502 " + boardString[0][2] +" \u2502\n"+
				" \u251C\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u2524"+ "\n1\u2502 "+ boardString[1][0] + " \u2502 "+ boardString[1][1] + " \u2502 " + boardString[1][2]+ " \u2502\n" +
				" \u251C\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u2524"+ "\n2\u2502 " + boardString[2][0] + " \u2502 "+ boardString[2][1]+ " \u2502 " + boardString[2][2]+ " \u2502\n" +
				" \u2514\u2500\u2500\u2500\u2534\u2500\u2500\u2500\u2534\u2500\u2500\u2500\u2518";
				
	}
	public void resetBoard(){
		for(int i=0;i<BOARD_HEIGHT_WIDTH;i++){
			for(int j=0; j<BOARD_HEIGHT_WIDTH;j++){
				boardArray[i][j]=0;
			}
		}
	}
	
	public static void main(String[] args) {
		
		
	}

}

