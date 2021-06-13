package pieces;

import general.Move;
import general.Position;

import java.util.List;

public class Queen extends Piece {

    public Queen(boolean colorWhite, Position position) {
        super(colorWhite, position);
    }

    public Queen(boolean colorWhite, int row, int column) {
        super(colorWhite, row, column);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteQueen = "\u2655";
        String blackQueen = "\u265B";

        return isColorWhite() ? whiteQueen : blackQueen;

    }

    @Override
    List<Move> getPossibleMoves() {
        return null;
    }
}
