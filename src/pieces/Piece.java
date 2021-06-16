package pieces;

import general.BoardState;
import moves.Move;
import general.Position;

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
}
