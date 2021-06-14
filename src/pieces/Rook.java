package pieces;

import general.BoardState;
import general.Move;
import general.Position;

import java.util.List;

public class Rook extends Piece {

    public Rook(boolean colorWhite, Position position) {
        super(colorWhite, position);
    }

    public Rook(boolean colorWhite, int row, int column) {
        super(colorWhite, row, column);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteRook = "\u2656";
        String blackRook = "\u265C";

        return isColorWhite() ? whiteRook : blackRook;

    }

    @Override
    public List<Move> getPossibleMoves(BoardState board) {
        return null;
    }
}
