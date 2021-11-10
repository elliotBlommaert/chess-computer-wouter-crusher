package moves;

import general.Pair;
import general.Position;
import pieces.Piece;

import java.util.List;

abstract public class Move {

    abstract public List<Pair<Piece, Pair<Position,Position>>> getPiecesToMove();

    abstract public Pair<Piece,Position> getPieceToCreate();

    abstract public List<Pair<Piece,Position>> getPiecesToRemove();

    public int getEnabledEnPassantColumn() {
        return -1;
    }
}
