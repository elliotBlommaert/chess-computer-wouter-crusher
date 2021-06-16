package pieces;

import general.BoardState;
import moves.DefaultMove;
import moves.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(boolean colorWhite, int id) {
        super(colorWhite, id);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteQueen = "\u2655";
        String blackQueen = "\u265B";

        return isColorWhite() ? whiteQueen : blackQueen;

    }

    @Override
    protected List<Move> getPossibleMoves(BoardState board, Position position) {
        assert board.getPieceAt(position).equals(this);

        List<Move> moves = new ArrayList<>();
        int startRow = position.getRow();
        int startColumn = position.getColumn();
        // Right
        int i = startColumn + 1;
        boolean foundPiece = false;
        while (i < 8 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, startRow);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(i, startRow)));
            }
            i++;
        }
        // Left
        i = startColumn - 1;
        foundPiece = false;
        while (i >= 0 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, startRow);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(i, startRow)));
            }
            i--;
        }
        // Up
        i = startRow + 1;
        foundPiece = false;
        while (i < 8 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(startColumn, i);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(startColumn, i)));
            }
            i++;
        }
        // Down
        i = startRow - 1;
        foundPiece = false;
        while (i >= 0 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(startColumn, i);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(startColumn, i)));
            }
            i--;
        }
        // Up-right
        i = startColumn + 1;
        int j = startRow + 1;
        foundPiece = false;
        while (i < 8 && j < 8 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, j);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(i, j)));
            }
            i++;
            j++;
        }
        // Down-right
        i = startColumn + 1;
        j = startRow - 1;
        foundPiece = false;
        while (i < 8 && j >= 0 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, j);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(i, j)));
            }
            i++;
            j--;
        }
        // Down-left
        i = startColumn - 1;
        j = startRow - 1;
        foundPiece = false;
        while (i >= 0 && j >= 0 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, j);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(i, j)));
            }
            i--;
            j--;
        }
        // Up-left
        i = startColumn - 1;
        j = startRow + 1;
        foundPiece = false;
        while (i >= 0 && j < 8 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, j);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(i, j)));
            }
            i--;
            j++;
        }

        return moves;
    }
}
