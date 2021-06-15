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
        Position oldPosition = new Position(2, 2);
        Queen queen = new Queen(true, oldPosition);
        boardState.addPiece(queen);
        System.out.println(boardState);
//        boardState.addPiece(new Bishop(true, new Position(1,1)));
        System.out.println(queen.getPossibleMoves(boardState));
        int i = 0;


    }


}
