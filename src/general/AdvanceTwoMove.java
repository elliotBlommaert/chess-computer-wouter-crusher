package general;

import com.sun.tools.javac.util.Pair;
import pieces.Piece;

import java.util.Collections;
import java.util.List;

public class AdvanceTwoMove extends Move{

    private Piece pieceToMove;
    private Position oldPosition;
    private Position newPosition;

    public AdvanceTwoMove(Piece pieceToMove, Position oldPosition, Position newPosition) {
        assert oldPosition.getColumn() == newPosition.getColumn();
        this.pieceToMove = pieceToMove;
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
    }

    @Override
    public List<Pair<Piece, Pair<Position, Position>>> getPiecesToMove() {
        return Collections.singletonList(new Pair<>(pieceToMove, new Pair<>(oldPosition, newPosition)));
    }

    @Override
    public Pair<Piece, Position> getPieceToCreate() {
        return null;
    }

    @Override
    public List<Pair<Piece, Position>> getPiecesToRemove() {
        return null;
    }

    @Override
    public int getEnabledEnPassantColumn() {
        return oldPosition.getColumn();
    }
}
