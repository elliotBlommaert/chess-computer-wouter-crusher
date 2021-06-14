package pieces;

import general.BoardState;
import general.Move;
import general.Position;

import java.util.List;

public class Bishop extends Piece {

    public Bishop(boolean colorWhite, Position position) {
        super(colorWhite, position);
    }

    public Bishop(boolean colorWhite, int row, int column) {
        super(colorWhite, row, column);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteBishop = "\u2657";
        String blackBishop = "\u265D";

        return isColorWhite() ? whiteBishop : blackBishop;

    }

    @Override
    public List<Move> getPossibleMoves(BoardState board) {
        return null;
    }
}
