package general;

import com.sun.tools.javac.util.Pair;
import pieces.Piece;

import java.util.Collections;
import java.util.List;

public class DefaultMove extends Move {

    private Piece pieceToMove;
    private Position oldPosition;
    private Position newPosition;

    public DefaultMove(Piece pieceToMove, Position oldPosition, Position newPosition) {
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
    public String toString() {
        return pieceToMove.getDrawingCharacter() + " " + oldPosition.toString() + "->" + newPosition.toString();
    }
}
