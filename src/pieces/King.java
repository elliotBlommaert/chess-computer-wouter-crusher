package pieces;

import general.BoardState;
import general.Move;
import general.Position;

import java.util.List;

public class King extends Piece {

    public King(boolean colorWhite, int id) {
        super(colorWhite, id);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteKing = "\u2654";
        String blackKing = "\u265A";

        return isColorWhite() ? whiteKing : blackKing;
    }

    @Override
    public List<Move> getPossibleMoves(BoardState board, Position position) {
        assert board.getPieceAt(position).equals(this);

        return null;
    }
}
