package moves;

import com.sun.tools.javac.util.Pair;
import general.Position;
import pieces.King;
import pieces.Piece;
import pieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class CastlingMove extends Move {
    private King king;
    private Piece rook;
    private boolean queenSide;

    public CastlingMove(King king, Piece rook, boolean queenSide) {
        assert king.isColorWhite() == rook.isColorWhite();
        assert rook instanceof Rook;
        this.king = king;
        this.rook = rook;
        this.queenSide = queenSide;
    }

    @Override
    public List<Pair<Piece, Pair<Position, Position>>> getPiecesToMove() {
        List<Pair<Piece, Pair<Position, Position>>> piecesToMove = new ArrayList<>();
        if (king.isColorWhite()) {
            if (queenSide) {
                piecesToMove.add(new Pair<>(rook, new Pair<>(new Position(0, 0), new Position(3, 0))));
                piecesToMove.add(new Pair<>(king, new Pair<>(new Position(4, 0), new Position(2, 0))));
            } else {
                piecesToMove.add(new Pair<>(rook, new Pair<>(new Position(7, 0), new Position(5, 0))));
                piecesToMove.add(new Pair<>(king, new Pair<>(new Position(4, 0), new Position(6, 0))));
            }
        } else {
            if (queenSide) {
                piecesToMove.add(new Pair<>(rook, new Pair<>(new Position(0, 7), new Position(3, 7))));
                piecesToMove.add(new Pair<>(king, new Pair<>(new Position(4, 7), new Position(2, 7))));
            } else {
                piecesToMove.add(new Pair<>(rook, new Pair<>(new Position(7, 7), new Position(5, 7))));
                piecesToMove.add(new Pair<>(king, new Pair<>(new Position(4, 7), new Position(6, 7))));
            }
        }
        return piecesToMove;
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
        String castlingString = queenSide ? " O-O-O" : " O-O";
        return king.getDrawingCharacter() + castlingString;
    }
}
