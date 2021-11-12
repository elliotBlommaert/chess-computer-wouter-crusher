import board.BoardBuilder;
import board.Board;
import board.BoardStatus;
import moves.Move;
import tree.Tree;

public class Main {


    public static void main(String[] args) {
        Board board = new BoardBuilder()
                .addPieces("K,w,A1 - Q,b,B2 - B,b,C3 - K,b,D4")
                .blackToMove()
                .build();
        System.out.println(board);
        System.out.println(board.getAllPossibleMoves());

        board = Board.getDefaultStartBoard();
        for (int i = 0; i < 1000000 && board.getStatus() == BoardStatus.CONTINUE; i++) {
            System.out.println("------------------------------------");
            if (i == 48) {
                int n = 0;
            }
            Move optimalMove = Tree.findOptimalMove(board, 4).getSecond();
            System.out.println(optimalMove);
            board.executeMove(optimalMove);
            System.out.println(board);
        }
    }


}
