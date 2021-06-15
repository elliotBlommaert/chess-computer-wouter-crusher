package pieces;

import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(boolean colorWhite, Position position) {
        super(colorWhite, position);
    }

    public Queen(boolean colorWhite, int row, int column) {
        super(colorWhite, row, column);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteQueen = "\u2655";
        String blackQueen = "\u265B";

        return isColorWhite() ? whiteQueen : blackQueen;

    }

    @Override
    public List<Move> getPossibleMoves(BoardState board) {
        List<Move> moves = new ArrayList<>();
        int startRow = position.getRow();
        int startColumn = position.getColumn();
        // Right
        int i = startColumn + 1;
        boolean foundPiece = false;
        while (i < 8 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(startRow, i);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, new Position(startRow, i)));
            }
            i++;
        }
        // Left
        i = startColumn - 1;
        foundPiece = false;
        while (i >= 0 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(startRow, i);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, new Position(startRow, i)));
            }
            i--;
        }
        // Up
        i = startRow + 1;
        foundPiece = false;
        while (i < 8 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, startColumn);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, new Position(i, startColumn)));
            }
            i++;
        }
        // Down
        i = startRow - 1;
        foundPiece = false;
        while (i >= 0 && !foundPiece) {
            Piece pieceAt = board.getPieceAt(i, startColumn);
            foundPiece = pieceAt != null;
            if (!foundPiece || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, new Position(i, startColumn)));
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
                moves.add(new DefaultMove(this, new Position(i, j)));
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
                moves.add(new DefaultMove(this, new Position(i, j)));
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
                moves.add(new DefaultMove(this, new Position(i, j)));
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
                moves.add(new DefaultMove(this, new Position(i, j)));
            }
            i--;
            j++;
        }

        return moves;
    }
}
