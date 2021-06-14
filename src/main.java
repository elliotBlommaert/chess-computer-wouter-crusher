import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;
import pieces.Bishop;
import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class main {


    public static void main(String[] args) {
        BoardState boardState = new BoardState();
        Position oldPosition = new Position(2, 2);
        Bishop bishop = new Bishop(true, oldPosition);
        boardState.addPiece(bishop);
//        boardState.addPiece(new Bishop(true, new Position(1,1)));
        bishop.getPossibleMoves(boardState);
        int i = 0;


    }


}
