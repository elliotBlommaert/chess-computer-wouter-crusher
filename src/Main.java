import board.BoardBuilder;
import board.Board;

public class Main {


    public static void main(String[] args) {
        Board board = new BoardBuilder()
                .addPieces("K,w,A1 - Q,b,B2 - B,b,C3 - K,b,D4")
                .blackToMove()
                .build();
        System.out.println(board);
        System.out.println(board.getAllPossibleMoves());


//        for (int i = 0; i < 100; i++) {
//            System.out.println("------------------------------------");
//            Move optimalMove = Tree.findOptimalMove(board, 3);
//            System.out.println(optimalMove);
//            board.executeMove(optimalMove);
//            System.out.println(board);
//        }
    }


}
