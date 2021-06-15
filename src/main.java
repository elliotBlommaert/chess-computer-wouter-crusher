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
        Piece knight = boardState.getPieceAt(1,0);


        List<Move> possibleMoves = knight.getPossibleMoves(boardState, new Position(1, 0));

        for (Move possibleMove : possibleMoves) {
            boardState.executeMove(possibleMove);
            System.out.println(boardState);
            boardState.revertLastMove();
            System.out.println(boardState);
            System.out.println("----------------------------");
        }


    }


}
