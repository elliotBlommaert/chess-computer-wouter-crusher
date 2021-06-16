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
                new DefaultMove(boardState.getPieceAt(2, 1), new Position(2, 1), new Position(3, 2))
        );
        // black queen move
        boardState.executeMove(
                new DefaultMove(boardState.getPieceAt(3, 7), new Position(3, 7), new Position(5, 5))
        );
        // white pawn
        boardState.executeMove(
                new DefaultMove(boardState.getPieceAt(1, 1), new Position(1, 1), new Position(1, 2))
        );
        // black bishop
        boardState.executeMove(
                new DefaultMove(boardState.getPieceAt(2, 7), new Position(2, 7), new Position(0, 2))
        );
        // white pawn
        boardState.executeMove(
                new DefaultMove(boardState.getPieceAt(1, 2), new Position(1, 2), new Position(1, 3))
        );
        // black knight
        boardState.executeMove(
                new DefaultMove(boardState.getPieceAt(1, 7), new Position(1, 7), new Position(3, 3))
        );

        List<Move> possibleMoves = boardState.getPieceAt(4, 7).getPossibleMoves(boardState, new Position(4, 7));

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
