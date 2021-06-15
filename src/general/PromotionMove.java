package general;

import com.sun.tools.javac.util.Pair;
import pieces.Piece;

import java.util.List;

public class PromotionMove extends Move {



    @Override
    public List<Pair<Piece, Pair<Position, Position>>> getPiecesToMove() {
        return null;
    }

    @Override
    public Pair<Piece, Position> getPieceToCreate() {
        return null;
    }

    @Override
    public Pair<Piece, Position> getPieceToRemove() {
        return null;
    }
}
