package pieces;

import general.BoardState;
import moves.DefaultMove;
import moves.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    @Override
    public double getValue() {
        return 5;
    }

    public Rook(boolean colorWhite, int id) {
        super(colorWhite, id);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteRook = "\u2656";
        String blackRook = "\u265C";

        return isColorWhite() ? whiteRook : blackRook;

    }

    @Override
    public List<Move> getPossibleMoves(BoardState board, Position position) {
        assert board.getPieceAt(position).equals(this);

        List<Move> moves = new ArrayList<>();
        int startRow = position.getRow();
        int startColumn = position.getColumn();

        int i = startColumn + 1;
        boolean foundPiece = false;
        while (i < 8 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, startRow);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.isColorWhite() != isColorWhite()) {
                moves.add(new DefaultMove(this, position, new Position(i, startRow)));
            }
            i++;
        }

        i = startColumn - 1;
        foundPiece = false;
        while (i >= 0 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, startRow);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.isColorWhite() != isColorWhite()) {
                moves.add(new DefaultMove(this, position, new Position(i, startRow)));
            }
            i--;
        }

        i = startRow + 1;
        foundPiece = false;
        while (i < 8 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(startColumn, i);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.isColorWhite() != isColorWhite()) {
                moves.add(new DefaultMove(this, position, new Position(startColumn, i)));
            }
            i++;
        }

        i = startRow - 1;
        foundPiece = false;
        while (i >= 0 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(startColumn, i);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.isColorWhite() != isColorWhite()) {
                moves.add(new DefaultMove(this, position, new Position(startColumn, i)));
            }
            i--;
        }
        return moves;
    }
}
