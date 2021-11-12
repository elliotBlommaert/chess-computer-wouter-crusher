package pieces;

import board.Board;
import moves.DefaultMove;
import moves.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    @Override
    public double getValue() {
        return 3;
    }

    public Bishop(boolean colorWhite, int id) {
        super(colorWhite, id);
    }


    @Override
    public String getDrawingCharacter() {
        String whiteBishop = "\u2657";
        String blackBishop = "\u265D";

        return isColorWhite() ? whiteBishop : blackBishop;

    }

    @Override
    public List<Move> getPossibleMoves(Board board, Position position) {
        assert board.getPieceAt(position).equals(this);

        List<Move> possibleMoves = new ArrayList<>();
        int currentColumn = position.getColumn();
        int currentRow = position.getRow();


        int upRightColumn = currentColumn + 1;
        int upRightRow = currentRow + 1;

        boolean foundPieceInLineUpRight = false;
        while (upRightColumn < 8 && upRightRow < 8 && !foundPieceInLineUpRight) {
            Piece pieceAtPosition = board.getPieceAt(upRightColumn, upRightRow);
            foundPieceInLineUpRight = pieceAtPosition != null;

            if (pieceAtPosition == null || pieceAtPosition.colorWhite != this.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, position, new Position(upRightColumn, upRightRow));
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
                DefaultMove newMove = new DefaultMove(this, position, new Position(downRightColumn, downRightRow));
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
                DefaultMove newMove = new DefaultMove(this, position, new Position(downLeftColumn, downLeftRow));
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
                DefaultMove newMove = new DefaultMove(this, position, new Position(upLeftColumn, upLeftRow));
                possibleMoves.add(newMove);
            }

            upLeftColumn--;
            upLeftRow++;
        }

        return possibleMoves;
    }
}
