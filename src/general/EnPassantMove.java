package general;

import com.sun.tools.javac.util.Pair;
import pieces.Pawn;
import pieces.Piece;

import java.util.Collections;
import java.util.List;

public class EnPassantMove extends Move{
    private Pawn pawnToMove;
    private Position oldPosition;
    private Position newPosition;

    public EnPassantMove(Pawn pawnToMove, Position oldPosition, Position newPosition) {
        this.pawnToMove = pawnToMove;
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
    }

    @Override
    public List<Pair<Piece, Pair<Position, Position>>> getPiecesToMove() {
        return Collections.singletonList(new Pair<>(pawnToMove, new Pair<>(oldPosition, newPosition)));
    }
}
