import java.util.Scanner;
public class HumanPlayer extends Player{
    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }
    public void makeMove(Board board) {
        Scanner input = new Scanner(System.in);
        System.out.print( name + ", please input a value: ");
        int col = input.nextInt();
        while(board.validmakeMove((col))==false){
            System.out.println("Invalid input, please try again");
            System.out.print( name + ", please input a value: ");
            col = input.nextInt();
        }
        board.makeMove((col), symbol);
        }
}