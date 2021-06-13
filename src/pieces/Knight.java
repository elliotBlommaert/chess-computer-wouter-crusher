package pieces;

import general.Move;
import general.Position;

import java.util.List;

public class Knight extends Piece {
    public Knight(boolean colorWhite, Position position) {
        super(colorWhite, position);
    }

    public Knight(boolean colorWhite, int row, int column) {
        super(colorWhite, row, column);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteKnight = "\u2658";
        String blackKnight = "\u265E";

        return isColorWhite() ? whiteKnight : blackKnight;
    }

    @Override
    List<Move> getPossibleMoves() {
        return null;
    }
}
