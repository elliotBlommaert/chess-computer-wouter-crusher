import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;
import pieces.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class main {


    public static void main(String[] args) {
        BoardState boardState = BoardState.getDefaultStartBoard();
        Piece pawn = boardState.getPieceAt(1,1);
        boardState.addPiece(new Pawn(false, 100), new Position(2, 2));
        boardState.addPiece(new Pawn(false, 101), new Position(0, 2));

        List<Move> possibleMoves = pawn.getPossibleMoves(boardState, new Position(1, 1));

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
