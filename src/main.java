import general.BoardState;
import general.Position;
import pieces.*;

import static org.assertj.core.api.Assertions.assertThat;

public class main {


    public static void main(String[] args) {
        BoardState boardState = new BoardState();
        Piece rook = new Rook(true, 0);
        Position position = new Position(1, 2);
        boardState.addPiece(rook, new Position(0, 0));
        System.out.println(rook.getPossibleMoves(boardState, position));
        System.out.println(boardState);

    }


}
