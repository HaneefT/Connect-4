
public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] board;
	/*
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 * You may add private and public methods if you wish. In fact, to achieve
	 * what the assignment is asking, you'll have to
	 * 
	 */
	public Board() {
		board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
		reset();
	}

public boolean boardempty(){
	for(int i=0; i<NUM_OF_ROW; i++){
		for(int j=0; j<NUM_OF_COLUMNS; j++){
			if(board[i][j]!=' '){
				return false;
			}
		}
	}
	return true;
}

// public int random(char symbol){
// 	Random rand = new Random();
// 	int col = rand.nextInt(7);
// 	if(col==0){
// 		col=1;
// 	}
// 	while(validmakeMove((col), symbol)==false){
// 		col = rand.nextInt(7);
// 		if(col==0){
// 			col=1;
// 		}
// 	}
// 	System.out.println(col);
// 	return col;
// }

	public void removepiece(int col){
		for(int i=0;i<NUM_OF_ROW;i++){
			if(board[i][col-1]!=' '){
				board[i][col-1]=' ';
				break;
			}
		}
	}

	public char oppsymbol(char symbol) {
		char oppsymbol = ' ';
		for(int i=0;i<NUM_OF_ROW;i++){
			for(int j=0;j<NUM_OF_COLUMNS;j++){
				if(board[i][j]!=symbol && board[i][j]!=' '){
					oppsymbol = board[i][j];
					break;
				}
			}
		}
		return oppsymbol;
	}



public boolean validmakeMove(int col){
		if (board[0][col-1] != ' '){
			return false;
		}
		return true;
	}

	public void makeMove(int col, char symbol) {
		for (int i = (NUM_OF_ROW-1); i >= 0; i--) {
			if (board[i][col-1 ] == ' ') {
				board[i][col-1 ] = symbol;
				break;}
			else{
				continue;
			}
			}
		}

	public void printBoard() {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			System.out.print("|");
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				System.out.print(board[i][j]+"|");
			}
			System.out.println();
		}
	}

	public boolean containsWin() {
		//Horizontal win
		for (int i = 0;i <NUM_OF_ROW; i++){
            for (int j = 0 ;j <(NUM_OF_COLUMNS-3); j++){
                if((board[i][j] == board[i][j+1]) && (board[i][j+1] == board[i][j+2]) && (board[i][j+2] == board[i][j+3]) && (board[i][j] != ' ')){
					return true;
				}
			}
		}
		//Vertical win
		for (int j=0;j<NUM_OF_COLUMNS;j++){
			for (int i=0;i<(NUM_OF_ROW-3);i++){
				if((board[i][j] == board[i+1][j]) && (board[i+1][j] == board[i+2][j]) && (board[i+2][j] == board[i+3][j]) && (board[i][j] != ' ')){
					return true;
				}
			}
		}
		//Diagonal win
		for (int j=0;j<NUM_OF_COLUMNS-3;j++){
			for (int i=3;i<NUM_OF_ROW;i++){
				if((board[i][j] == board[i-1][j+1]) && (board[i-1][j+1] == board[i-2][j+2]) && (board[i-2][j+2] == board[i-3][j+3]) && (board[i][j] != ' ')){
					return true;
				}
			}
		}
		//Diagonal win
		for (int j=0;j<NUM_OF_COLUMNS-3;j++){
			for (int i=0;i<NUM_OF_ROW-3;i++){
				if((board[i][j] == board[i+1][j+1]) && (board[i+1][j+1] == board[i+2][j+2]) && (board[i+2][j+2] == board[i+3][j+3]) && (board[i][j] != ' ')){
					return true;
				}
			}
		}
		return false;
	}

	public boolean isTie() {
		if (containsWin() == false) {
			for(int i =0; i< NUM_OF_COLUMNS; i++){
				if(board[0][i]!=' '){
					continue;
				}
				else{
					return false;
				}
			}
		}
		return true;
	}

	public void reset() {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				board[i][j] = ' ';
			}
		}
	}

}
