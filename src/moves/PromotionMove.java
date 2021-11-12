package moves;

import general.Pair;
import general.Position;
import pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PromotionMove extends Move {

    private Piece newPiece;
    private Piece pawn;
    private Piece oldPieceAtPosition;
    private Position newPiecePosition;
    private Position oldPawnPosition;

    public PromotionMove(Piece newPiece, Piece pawn, Piece oldPieceAtPosition, Position oldPawnPosition, Position newPiecePosition) {
        this.newPiece = newPiece;
        this.pawn = pawn;
        this.oldPieceAtPosition = oldPieceAtPosition;
        this.oldPawnPosition = oldPawnPosition;
        this.newPiecePosition = newPiecePosition;
    }

    @Override
    public String toString() {
        return pawn.getDrawingCharacter() + " " + oldPawnPosition.toString() + " -> " + newPiece.getDrawingCharacter() + " " + newPiecePosition.toString();
    }

    @Override
    public List<Pair<Piece, Pair<Position, Position>>> getPiecesToMove() {
        return Collections.emptyList();
    }

    @Override
    public Pair<Piece, Position> getPieceToCreate() {
        return new Pair<>(newPiece, newPiecePosition);
    }

    @Override
    public List<Pair<Piece, Position>> getPiecesToRemove() {
        List<Pair<Piece, Position>> piecesToRemove = new ArrayList<>();
        piecesToRemove.add(new Pair<>(pawn, oldPawnPosition));
        if (oldPieceAtPosition != null) {
            piecesToRemove.add(new Pair<>(oldPieceAtPosition, newPiecePosition));
        }
        return piecesToRemove;
    }
}
