import general.*;
import moves.AdvanceTwoMove;
import moves.DefaultMove;
import moves.Move;
import pieces.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class main {


    public static void main(String[] args) {

        BoardState boardState = BoardState.getDefaultStartBoard();

        // white pawn
        boardState.executeMove(
                new DefaultMove(boardState.getPieceAt(2, 1), new Position(2, 1), new Position(2, 4))
        );
        // black pawn move
        boardState.executeMove(
                new AdvanceTwoMove(boardState.getPieceAt(3, 6), new Position(3, 6), new Position(3, 4))
        );

        boardState.revertLastMove();

        List<Move> possibleMoves = boardState.getPieceAt(2, 4).getPossibleMoves(boardState, new Position(2, 4));

        for (Move possibleMove : possibleMoves) {
            System.out.println(possibleMove);
            System.out.println(boardState);
            boardState.executeMove(possibleMove);
            System.out.println(boardState);
            boardState.revertLastMove();
            System.out.println(boardState);
            System.out.println("---------------------------------------");
        }
    }


}
