import general.BoardState;
import general.Position;
import general.Scorer;
import moves.AdvanceTwoMove;
import moves.DefaultMove;
import moves.Move;
import pieces.*;
import tree.Tree;

import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        BoardState board = BoardState.getDefaultStartBoard();
        System.out.println(board);
        System.out.println(Scorer.scoreBoard(board));

        BoardState empty = new BoardState();
        empty.addPiece(new King(false, 0), new Position(0, 0));
        empty.addPiece(new King(true, 0), new Position(5, 5));
        empty.addPiece(new Queen(true, 1), new Position(1, 1));
        Bishop bishop = new Bishop(true, 2);
        empty.addPiece(bishop, new Position(2, 2));
        System.out.println(Tree.findOptimalMove(empty, 2));
        System.out.println(Scorer.scoreBoard(empty));

        for (int i = 0; i < 2000; i++) {
//            System.out.println("------------------------------------");
//            List<Move> allPossibleMoves = board.getAllPossibleMoves();
//            Move move = allPossibleMoves.get(new Random(2l).nextInt(allPossibleMoves.size()));
//            System.out.println(move);
//            board.executeMove(move);
//            System.out.println(board);
        }
    }


}
