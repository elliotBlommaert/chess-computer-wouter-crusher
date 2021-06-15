package pieces;

import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
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

        List<Move> possibleMoves = new ArrayList<>();

        int column = position.getColumn();
        int row = position.getRow();

        int upLeftColumn = column - 1;
        int upLeftRow = row + 2;
        Piece pieceAtTarget = board.getPieceAt(upLeftColumn, upLeftRow);
        if (row < 8 && upLeftColumn >= 0 && (pieceAtTarget == null || pieceAtTarget.colorWhite != pieceAtTarget.colorWhite)) {
            DefaultMove newMove = new DefaultMove(this, position, new Position(upLeftColumn, upLeftRow));
            possibleMoves.add(newMove);
        }

        int leftUpColumn = column - 2;
        int leftUpRow = row + 1;
        pieceAtTarget = board.getPieceAt(leftUpColumn, leftUpRow);
        if (row < 8 && leftUpColumn >= 0 && (pieceAtTarget == null || pieceAtTarget.colorWhite != pieceAtTarget.colorWhite)) {
            DefaultMove newMove = new DefaultMove(this, position, new Position(leftUpColumn, leftUpRow));
            possibleMoves.add(newMove);
        }

        int upRightColumn = column + 1;
        int upRightRow = row + 2;
        pieceAtTarget = board.getPieceAt(upRightColumn, upRightRow);
        if (row < 8 && upRightColumn < 8  && (pieceAtTarget == null || pieceAtTarget.colorWhite != pieceAtTarget.colorWhite)) {
            DefaultMove newMove = new DefaultMove(this, position, new Position(upRightColumn, upRightRow));
            possibleMoves.add(newMove);
        }

        int rightUpColumn = column + 2;
        int rightUpRow = row + 1;
        pieceAtTarget = board.getPieceAt(rightUpColumn, rightUpRow);
        if (row < 8 && rightUpColumn < 8  && (pieceAtTarget == null || pieceAtTarget.colorWhite != pieceAtTarget.colorWhite)) {
            DefaultMove newMove = new DefaultMove(this, position, new Position(rightUpColumn, rightUpRow));
            possibleMoves.add(newMove);
        }

        int downLeftColumn = column - 1;
        int downLeftRow = row - 2;
        pieceAtTarget = board.getPieceAt(downLeftColumn, downLeftRow);
        if (row >= 0 && downLeftColumn >= 0 && (pieceAtTarget == null || pieceAtTarget.colorWhite != pieceAtTarget.colorWhite)) {
            DefaultMove newMove = new DefaultMove(this, position, new Position(downLeftColumn, downLeftRow));
            possibleMoves.add(newMove);
        }

        int leftDownColumn = column - 2;
        int leftDownRow = row - 1;
        pieceAtTarget = board.getPieceAt(leftDownColumn, leftDownRow);
        if (row >= 0 && leftDownColumn >= 0 && (pieceAtTarget == null || pieceAtTarget.colorWhite != pieceAtTarget.colorWhite)) {
            DefaultMove newMove = new DefaultMove(this, position, new Position(leftDownColumn, leftDownRow));
            possibleMoves.add(newMove);
        }

        int downRightColumn = column + 1;
        int downRightRow = row - 2;
        pieceAtTarget = board.getPieceAt(downRightColumn, downRightRow);
        if (row >= 0 && downRightColumn >= 0 && (pieceAtTarget == null || pieceAtTarget.colorWhite != pieceAtTarget.colorWhite)) {
            DefaultMove newMove = new DefaultMove(this, position, new Position(downRightColumn, downRightRow));
            possibleMoves.add(newMove);
        }

        int rightDownColumn = column + 2;
        int rightDownRow = row - 1;
        pieceAtTarget = board.getPieceAt(rightDownColumn, rightDownRow);
        if (row >= 0 && rightDownColumn >= 0 && (pieceAtTarget == null || pieceAtTarget.colorWhite != pieceAtTarget.colorWhite)) {
            DefaultMove newMove = new DefaultMove(this, position, new Position(rightDownColumn, rightDownRow));
            possibleMoves.add(newMove);
        }

        return possibleMoves;
    }
}
