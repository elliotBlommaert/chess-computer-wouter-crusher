package pieces;

import board.BoardState;
import moves.DefaultMove;
import moves.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    @Override
    public double getValue() {
        return 3;
    }

    public Knight(boolean colorWhite, int id) {
        super(colorWhite, id);
    }


    @Override
    public String getDrawingCharacter() {
        String whiteKnight = "\u2658";
        String blackKnight = "\u265E";

        return isColorWhite() ? whiteKnight : blackKnight;
    }

    @Override
    public List<Move> getPossibleMoves(BoardState board, Position position) {

        assert board.getPieceAt(position).equals(this);

        List<Move> possibleMoves = new ArrayList<>();

        int column = position.getColumn();
        int row = position.getRow();

        int upLeftColumn = column - 1;
        int upLeftRow = row + 2;
        if (upLeftRow < 8 && upLeftColumn >= 0) {
            Piece pieceAtTarget = board.getPieceAt(upLeftColumn, upLeftRow);
            if (pieceAtTarget == null || this.colorWhite != pieceAtTarget.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, position, new Position(upLeftColumn, upLeftRow));
                possibleMoves.add(newMove);
            }
        }

        int leftUpColumn = column - 2;
        int leftUpRow = row + 1;
        if (leftUpRow < 8 && leftUpColumn >= 0) {
            Piece pieceAtTarget = board.getPieceAt(leftUpColumn, leftUpRow);
            if (pieceAtTarget == null || this.colorWhite != pieceAtTarget.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, position, new Position(leftUpColumn, leftUpRow));
                possibleMoves.add(newMove);
            }
        }

        int upRightColumn = column + 1;
        int upRightRow = row + 2;
        if (upRightRow < 8 && upRightColumn < 8) {
            Piece pieceAtTarget = board.getPieceAt(upRightColumn, upRightRow);
            if (pieceAtTarget == null || this.colorWhite != pieceAtTarget.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, position, new Position(upRightColumn, upRightRow));
                possibleMoves.add(newMove);
            }
        }

        int rightUpColumn = column + 2;
        int rightUpRow = row + 1;
        if (rightUpRow < 8 && rightUpColumn < 8) {
            Piece pieceAtTarget = board.getPieceAt(rightUpColumn, rightUpRow);
            if (pieceAtTarget == null || this.colorWhite != pieceAtTarget.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, position, new Position(rightUpColumn, rightUpRow));
                possibleMoves.add(newMove);
            }
        }

        int downLeftColumn = column - 1;
        int downLeftRow = row - 2;
        if (downLeftRow >= 0 && downLeftColumn >= 0) {
            Piece pieceAtTarget = board.getPieceAt(downLeftColumn, downLeftRow);
            if (pieceAtTarget == null || this.colorWhite != pieceAtTarget.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, position, new Position(downLeftColumn, downLeftRow));
                possibleMoves.add(newMove);
            }
        }

        int leftDownColumn = column - 2;
        int leftDownRow = row - 1;
        if (leftDownRow >= 0 && leftDownColumn >= 0) {
            Piece pieceAtTarget = board.getPieceAt(leftDownColumn, leftDownRow);
            if (pieceAtTarget == null || this.colorWhite != pieceAtTarget.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, position, new Position(leftDownColumn, leftDownRow));
                possibleMoves.add(newMove);
            }
        }

        int downRightColumn = column + 1;
        int downRightRow = row - 2;
        if (downRightRow >= 0 && downRightColumn < 8) {
            Piece pieceAtTarget = board.getPieceAt(downRightColumn, downRightRow);
            if (pieceAtTarget == null || this.colorWhite != pieceAtTarget.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, position, new Position(downRightColumn, downRightRow));
                possibleMoves.add(newMove);
            }
        }

        int rightDownColumn = column + 2;
        int rightDownRow = row - 1;
        if (rightDownRow >= 0 && rightDownColumn < 8) {
            Piece pieceAtTarget = board.getPieceAt(rightDownColumn, rightDownRow);
            if (pieceAtTarget == null || this.colorWhite != pieceAtTarget.colorWhite) {
                DefaultMove newMove = new DefaultMove(this, position, new Position(rightDownColumn, rightDownRow));
                possibleMoves.add(newMove);
            }
        }

        return possibleMoves;
    }
}
