import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;
import pieces.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class main {


    public static void main(String[] args) {
        BoardState boardState = new BoardState();
        Position oldPosition = new Position(4, 4);
        Piece bishop = new Knight(true, oldPosition);
        boardState.addPiece(bishop);
//        boardState.addPiece(new Bishop(true, new Position(1,1)));
        System.out.println(bishop.getPossibleMoves(boardState));
        int i = 0;


    }


}
