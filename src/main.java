import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;
import pieces.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setExtractBareNamePropertyMethods;

public class main {


    public static void main(String[] args) {
        BoardState boardState = new BoardState();
        Piece piece = new King(true, 1);
        boardState.addPiece(piece, new Position(2, 2));
        boardState.addPiece(new Pawn(false,0), new Position(1, 1));


        List<Move> possibleMoves = piece.getPossibleMoves(boardState, new Position(2, 2));
        System.out.println(possibleMoves);
        System.out.println(boardState);

        for (Move possibleMove : possibleMoves) {
            boardState.executeMove(possibleMove);
            System.out.println(boardState);
            boardState.revertLastMove();
            System.out.println(boardState);
            System.out.println("----------------------------");
        }


    }


}
