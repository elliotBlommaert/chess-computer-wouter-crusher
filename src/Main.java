import general.BoardState;
import general.Position;
import moves.AdvanceTwoMove;
import moves.DefaultMove;
import moves.Move;
import pieces.*;

import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        BoardState board = BoardState.getDefaultStartBoard();
        System.out.println(board);
        for (int i = 0; i < 2000; i++) {
            System.out.println("------------------------------------");
            List<Move> allPossibleMoves = board.getAllPossibleMoves();
            Move move = allPossibleMoves.get(new Random(2l).nextInt(allPossibleMoves.size()));
            System.out.println(move);
            board.executeMove(move);
            System.out.println(board);
        }
    }


}
