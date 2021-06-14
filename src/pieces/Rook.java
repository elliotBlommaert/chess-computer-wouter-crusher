package pieces;

import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(boolean colorWhite, Position position) {
        super(colorWhite, position);
    }

    public Rook(boolean colorWhite, int row, int column) {
        super(colorWhite, row, column);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteRook = "\u2656";
        String blackRook = "\u265C";

        return isColorWhite() ? whiteRook : blackRook;

    }

    @Override
    public List<Move> getPossibleMoves(BoardState board) {
        List<Move> moves = new ArrayList<>();
        int startRow = position.getRow();
        int startColumn = position.getColumn();
        int i = startColumn + 1;
        boolean foundPiece = false;
        while (i < 8 && !foundPiece) {
            Position newPosition = new Position(startRow, i);
            Piece pieceAt = board.getPieceAt(newPosition);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.isColorWhite() != isColorWhite()) {
                moves.add(new DefaultMove(this, newPosition));
            }
            i++;
        }

        i = startColumn - 1;
        foundPiece = false;
        while (i >= 0 && !foundPiece) {
            Position newPosition = new Position(startRow, i);
            Piece pieceAt = board.getPieceAt(newPosition);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.isColorWhite() != isColorWhite()) {
                moves.add(new DefaultMove(this, newPosition));
            }
            i--;
        }

        i = startRow + 1;
        foundPiece = false;
        while (i < 8 && !foundPiece) {
            Position newPosition = new Position(i, startColumn);
            Piece pieceAt = board.getPieceAt(newPosition);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.isColorWhite() != isColorWhite()) {
                moves.add(new DefaultMove(this, newPosition));
            }
            i++;
        }

        i = startRow - 1;
        foundPiece = false;
        while (i >= 0 && !foundPiece) {
            Position newPosition = new Position(i, startColumn);
            Piece pieceAt = board.getPieceAt(newPosition);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.isColorWhite() != isColorWhite()) {
                moves.add(new DefaultMove(this, newPosition));
            }
            i--;
        }
        return moves;
    }
}
