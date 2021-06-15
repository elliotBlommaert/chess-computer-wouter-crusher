package pieces;

import general.BoardState;
import general.Move;
import general.Position;

import java.util.List;

public class Pawn extends Piece {

    public Pawn(boolean colorWhite, int id) {
        super(colorWhite, id);
    }


    @Override
    public String getDrawingCharacter() {
        String whitePawn = "\u2659";
        String blackPawn = "\u265F";


        return isColorWhite() ? whitePawn : blackPawn;
    }

    @Override
    public List<Move> getPossibleMoves(BoardState board, Position position) {
        assert board.getPieceAt(position).equals(this);

        return null;
    }
}
