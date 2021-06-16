import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;
import pieces.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class main {


    public static void main(String[] args) {

        System.out.println("\u265B");
        System.out.println("\u2655");
        BoardState boardState = new BoardState();
        Pawn pawn = new Pawn(true, 100);
        Piece queen = new Queen(false, 101);
        boardState.addPiece(pawn, new Position(1, 6));
        boardState.addPiece(queen,new Position(0,7));

        List<Move> possibleMoves = pawn.getPossibleMoves(boardState, new Position(1, 6));

        for (Move possibleMove : possibleMoves) {
            System.out.println(possibleMove);
            boardState.executeMove(possibleMove);
            System.out.println(boardState);
            boardState.revertLastMove();
            System.out.println(boardState);
            System.out.println("---------------------------------------");
        }


    }


}
