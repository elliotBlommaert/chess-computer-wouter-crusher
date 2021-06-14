package pieces;

import general.BoardState;
import general.Move;
import general.Position;

import java.util.List;

public class Pawn extends Piece {

    public Pawn(boolean colorWhite, Position position) {
        super(colorWhite, position);
    }

    public Pawn(boolean colorWhite, int row, int column) {
        super(colorWhite, row, column);
    }

    @Override
    public String getDrawingCharacter() {
        String whitePawn = "\u2659";
        String blackPawn = "\u265F";


        return isColorWhite() ? whitePawn : blackPawn;
    }

    @Override
    public List<Move> getPossibleMoves(BoardState board) {
        return null;
    }
}
