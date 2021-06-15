import general.*;
import pieces.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class main {


    public static void main(String[] args) {
        BoardState boardState = BoardState.getDefaultStartBoard();
        Piece whitePawn = boardState.getPieceAt(1,6);
        Piece blackPawn = new Pawn(true, 100);
        boardState.addPiece(blackPawn, new Position(2, 4));
        boardState.executeMove(
                new DefaultMove(
                        boardState.getPieceAt(new Position(6, 1)),
                        new Position(6, 1),
                        new Position(6, 2)
                )
        );

        Move move = new AdvanceTwoMove(whitePawn, new Position(1, 6), new Position(1, 4));
        boardState.executeMove(move);

        List<Move> possibleMoves = blackPawn.getPossibleMoves(boardState, new Position(2, 4));
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
