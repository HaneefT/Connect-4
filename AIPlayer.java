import java.util.Random;

public class AIPlayer extends Player {
    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public void makeMove(Board board) {
        int flag = 0;
        if (board.boardempty() == false) {
            char oppsymbol = board.oppsymbol(symbol);
            for (int i = 1; i < 8; i++) {
                if (board.validmakeMove((i)) == true) {
                    board.makeMove((i), symbol);
                    if (board.containsWin() == true) {
                        flag =1;
                        break;
                    } else {
                        board.removepiece((i));
                    }
                    board.makeMove((i), oppsymbol);
                    if (board.containsWin() == true) {
                        board.removepiece((i));
                        board.makeMove((i), symbol);
                        flag = 1;
                        break;
                    } else {
                        board.removepiece((i));
                    }
                }
            }
        }
        if(flag == 0){
            Random rand = new Random();
            int col = rand.nextInt(7);
            if (col == 0) {
                col = 1;
            }
            while (board.validmakeMove((col)) == false) {
                col = rand.nextInt(7);
                if (col == 0) {
                    col = 1;
                }
            }
            board.makeMove((col), symbol);
        }
    }
}
