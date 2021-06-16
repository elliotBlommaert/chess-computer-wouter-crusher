package pieces;

import general.BoardState;
import general.Position;
import moves.CastlingMove;
import moves.DefaultMove;
import moves.Move;

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
            Piece pieceAt = board.getPieceAt(rightColumn, startRow);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(rightColumn, startRow)));
            }
        }
        // Left
        int leftColumn = startColumn - 1;
        if (leftColumn >= 0) {
            Piece pieceAt = board.getPieceAt(leftColumn, startRow);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(leftColumn, startRow)));
            }
        }

        // Up
        int upRow = startRow + 1;
        if (upRow < 8) {
            Piece pieceAt = board.getPieceAt(startColumn, upRow);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(startColumn, upRow)));
            }
        }
        // Down
        int downRow = startRow - 1;
        if (downRow >= 0) {
            Piece pieceAt = board.getPieceAt(startColumn, downRow);
            if (pieceAt == null || pieceAt.colorWhite != this.colorWhite) {
                moves.add(new DefaultMove(this, position, new Position(startColumn, downRow)));
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

        // TODO: Check checks
        int row = colorWhite ? 0 : 7;
        boolean canQueenSideCastle = colorWhite ? board.whiteCanQueenSideCastle() : board.blackCanQueenSideCastle();
        boolean canKingSideCastle = colorWhite ? board.whiteCanKingSideCastle() : board.blackCanKingSideCastle();

        if (canQueenSideCastle) {
            if (board.getPieceAt(1, row) == null && board.getPieceAt(2, row) == null && board.getPieceAt(3, row) == null) {
                if (board.isThreatened(colorWhite, new Position(1, row)) == null
                        && board.isThreatened(colorWhite, new Position(2, row)) == null
                        && board.isThreatened(colorWhite, new Position(3, row)) == null
                        && board.isThreatened(colorWhite, new Position(4, row)) == null
                ) {
                    Piece rook = board.getPieceAt(0, row);
                    moves.add(new CastlingMove(this, rook, true));
                }
            }
        }
        if (canKingSideCastle) {
            if (board.getPieceAt(5, row) == null && board.getPieceAt(6, row) == null) {
                if (board.isThreatened(colorWhite, new Position(4, row)) == null
                        && board.isThreatened(colorWhite, new Position(5, row)) == null
                        && board.isThreatened(colorWhite, new Position(6, row)) == null
                ) {
                    Piece rook = board.getPieceAt(7, row);
                    moves.add(new CastlingMove(this, rook, false));
                }
            }
        }

        return moves;
    }
}
