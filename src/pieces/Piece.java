package pieces;

import general.BoardState;
import general.CheckedData;
import moves.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Piece {

    protected boolean colorWhite;
    protected int id;

    public Piece(boolean colorWhite, int id) {
        this.colorWhite = colorWhite;
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return piece.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isColorWhite() {
        return colorWhite;
    }

    abstract public String getDrawingCharacter();

    public abstract List<Move> getPossibleMoves(BoardState board, Position position);

    public List<Move> getValidMovesIfChecked(BoardState board, Position position, CheckedData checkedData) {
        // Dummy code
        return getPossibleMoves(board, position);
    }

    public List<Move> getValidMoves(BoardState board, Position position) {
        boolean whiteToMove = board.whiteToMove();
        List<Move> possibleMoves = new ArrayList<>();
        CheckedData checked = board.isChecked(whiteToMove);
        if (checked != null) {
            possibleMoves.addAll(getValidMovesIfChecked(board, position, checked));
        } else {
            possibleMoves.addAll(getPossibleMoves(board, position));
        }

        List<Move> validMoves = new ArrayList<>();
        for (Move possibleMove : possibleMoves) {
            board.executeMove(possibleMove);
            if (board.isChecked(whiteToMove) ==  null) {
                validMoves.add(possibleMove);
            }
            board.revertLastMove();
        }
        return validMoves;
    }
}
