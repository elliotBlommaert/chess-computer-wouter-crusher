package pieces;

import general.BoardState;
import general.Move;
import general.Position;

import java.util.List;

public class King extends Piece {

    public King(boolean colorWhite, Position position) {
        super(colorWhite, position);
    }

    public King(boolean colorWhite, int row, int column) {
        super(colorWhite, row, column);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteKing = "\u2654";
        String blackKing = "\u265A";

        return isColorWhite() ? whiteKing : blackKing;
    }

    @Override
    List<Move> getPossibleMoves(BoardState board) {
        return null;
    }
}
