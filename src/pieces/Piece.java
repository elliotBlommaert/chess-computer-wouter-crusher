package pieces;

import general.BoardState;
import general.Move;
import general.Position;

import java.util.List;
import java.util.Objects;

public abstract class Piece {

    private boolean colorWhite;
    private Position position;

    public Piece(boolean colorWhite, Position position) {
        this.colorWhite = colorWhite;
        this.position = position;
    }

    public Piece(boolean colorWhite, int row, int column) {
        this.colorWhite = colorWhite;
        this.position = new Position(column, row);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return colorWhite == piece.colorWhite && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorWhite, position);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isColorWhite() {
        return colorWhite;
    }

    abstract public String getDrawingCharacter();

    abstract List<Move> getPossibleMoves(BoardState board);
}
