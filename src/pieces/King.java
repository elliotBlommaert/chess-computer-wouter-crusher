package pieces;

import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(boolean colorWhite, int id) {
        super(colorWhite, id);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteKing = "\u2654";
        String blackKing = "\u265A";

        return isColorWhite() ? whiteKing : blackKing;
    }

    @Override
    public List<Move> getPossibleMoves(BoardState board, Position position) {
        assert board.getPieceAt(position).equals(this);

        List<Move> moves = new ArrayList<>();
        int startRow = position.getRow();
        int startColumn = position.getColumn();
        // Right
        int rightColumn = startColumn + 1;
        if (rightColumn < 8) {
            Piece pieceAt = board.getPieceAt(startRow, rightColumn);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(startRow, rightColumn)));
            }
        }
        // Left
        int leftColumn = startColumn - 1;
        if (leftColumn >= 0) {
            Piece pieceAt = board.getPieceAt(startRow, leftColumn);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(startRow, leftColumn)));
            }
        }

        // Up
        int upRow = startRow + 1;
        if (upRow < 8) {
            Piece pieceAt = board.getPieceAt(upRow, startColumn);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(upRow, startColumn)));
            }
        }
        // Down
        int downRow = startRow - 1;
        if (downRow >= 0) {
            Piece pieceAt = board.getPieceAt(downRow, startColumn);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(downRow, startColumn)));
            }
        }
        // Up-right
        int upRightColumn = startColumn + 1;
        int upRightRow = startRow + 1;
        if (upRightRow < 8 && upRightColumn < 8) {
            Piece pieceAt = board.getPieceAt(upRightColumn, upRightRow);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(upRightColumn, upRightRow)));
            }
        }
        // Down-right
        int downRightColumn = startColumn + 1;
        int downRightRow = startRow - 1;
        if (downRightColumn < 8 && downRightRow >= 0) {
            Piece pieceAt = board.getPieceAt(downRightColumn, downRightRow);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(downRightColumn, downRightRow)));
            }
        }
        // Down-left
        int downLeftColumn = startColumn - 1;
        int downLeftRow = startRow - 1;
        if (downLeftColumn >= 0 && downLeftRow >= 0) {
            Piece pieceAt = board.getPieceAt(downLeftColumn, downLeftRow);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(downLeftColumn, downLeftRow)));
            }
        }
        // Up-left
        int upLeftColumn = startColumn - 1;
        int upLeftRow = startRow + 1;
        if (upLeftColumn >= 0 && upLeftRow < 8) {
            Piece pieceAt = board.getPieceAt(upLeftColumn, upLeftRow);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(upLeftColumn, upLeftRow)));
            }
        }

        return moves;
    }
}
