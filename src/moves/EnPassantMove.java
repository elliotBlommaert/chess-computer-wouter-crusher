package moves;

import general.Pair;
import general.Position;
import pieces.Pawn;
import pieces.Piece;

import java.util.Collections;
import java.util.List;

public class EnPassantMove extends Move{
    private Pawn pawnToMove;
    private Position oldPosition;
    private Position newPosition;
    private Piece capturedPawn;
    private Position capturedPosition;

    public EnPassantMove(Pawn pawnToMove, Position oldPosition, Position newPosition, Piece capturedPawn, Position capturedPosition) {
        assert capturedPawn instanceof Pawn;
        this.pawnToMove = pawnToMove;
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
        this.capturedPawn = capturedPawn;
        this.capturedPosition = capturedPosition;
    }

    @Override
    public List<Pair<Piece, Pair<Position, Position>>> getPiecesToMove() {
        return Collections.singletonList(new Pair<>(pawnToMove, new Pair<>(oldPosition, newPosition)));
    }

    @Override
    public Pair<Piece, Position> getPieceToCreate() {
        return null;
    }

    @Override
    public List<Pair<Piece, Position>> getPiecesToRemove() {
        return Collections.singletonList(new Pair<>(capturedPawn, capturedPosition));
    }

    @Override
    public String toString() {
        return pawnToMove.getDrawingCharacter() + " " + oldPosition.toString() + "-> X " + newPosition.toString();
    }
}
