package pieces;

import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(boolean colorWhite, Position position) {
        super(colorWhite, position);
    }

    public Bishop(boolean colorWhite, int row, int column) {
        super(colorWhite, row, column);
    }

    @Override
    public String getDrawingCharacter() {
        String whiteBishop = "\u2657";
        String blackBishop = "\u265D";

        return isColorWhite() ? whiteBishop : blackBishop;

    }

    @Override
    public List<Move> getPossibleMoves(BoardState board) {

        List<Move> possibleMoves = new ArrayList<>();
        int currentColumn = this.position.getColumn();
        int currentRow = this.position.getRow();


        int upRightColumn = currentColumn + 1;
        int upRightRow = currentRow + 1;

        boolean foundPieceInLineUpRight = false;
        while (upRightColumn < 8 && upRightRow < 8 && !foundPieceInLineUpRight) {
            Piece pieceAtPosition = board.getPieceAt(upRightColumn, upRightRow);
            foundPieceInLineUpRight = pieceAtPosition != null;

            if (pieceAtPosition == null || pieceAtPosition.colorWhite != this.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, new Position(upRightColumn, upRightRow));
                possibleMoves.add(newMove);
            }

            upRightColumn++;
            upRightRow++;

        }

        int downRightColumn = currentColumn + 1;
        int downRightRow = currentRow - 1;

        boolean foundPieceInLineDownRight = false;
        while (downRightColumn < 8 && downRightRow >= 0 && !foundPieceInLineDownRight) {
            Piece pieceAtPosition = board.getPieceAt(downRightColumn, downRightRow);
            foundPieceInLineDownRight = pieceAtPosition != null;

            if (pieceAtPosition == null || pieceAtPosition.colorWhite != this.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, new Position(downRightColumn, downRightRow));
                possibleMoves.add(newMove);
            }

            downRightColumn++;
            downRightRow--;

        }

        int downLeftColumn = currentColumn - 1;
        int downLeftRow = currentRow - 1;

        boolean foundPieceInLineDownLeft = false;
        while (downLeftColumn >= 0 && downLeftRow >= 0 && !foundPieceInLineDownLeft) {
            Piece pieceAtPosition = board.getPieceAt(downLeftColumn, downLeftRow);
            foundPieceInLineDownLeft = pieceAtPosition != null;

            if (pieceAtPosition == null || pieceAtPosition.colorWhite != this.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, new Position(downLeftColumn, downLeftRow));
                possibleMoves.add(newMove);
            }

            downLeftColumn--;
            downLeftRow--;
        }

        int upLeftColumn = currentColumn - 1;
        int upLeftRow = currentRow + 1;

        boolean foundPieceInLineUpLeft = false;
        while (upLeftColumn >= 0 && upLeftRow < 8 && !foundPieceInLineUpLeft) {
            Piece pieceAtPosition = board.getPieceAt(upLeftColumn, upLeftRow);
            foundPieceInLineUpLeft = pieceAtPosition != null;

            if (pieceAtPosition == null || pieceAtPosition.colorWhite != this.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, new Position(upLeftColumn, upLeftRow));
                possibleMoves.add(newMove);
            }

            upLeftColumn--;
            upLeftRow++;
        }

        return possibleMoves;
    }
}
