
public class ticTacToe {
	private int [][] boardArray;
	public static final int BOARD_HEIGHT_WIDTH=3;
	public ticTacToe(){
		boardArray = new int [3][3];
		for(int i=0;i<BOARD_HEIGHT_WIDTH;i++){
			for(int j=0;j<BOARD_HEIGHT_WIDTH;i++){
				boardArray[i][j]= 0;
			}
		}
	}
	public boolean isSquareFull(int row, int column){
			return boardArray[row][column]!=0;
	}
	public boolean move(int type, int row, int column ){
		if(boardArray[row][column]==0){
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
		for(){
			for(){}
			
		}
		
		for(int i=0;i<){
			
		}
		
	}
	public static void main(String[] args) {
		
	}

}
