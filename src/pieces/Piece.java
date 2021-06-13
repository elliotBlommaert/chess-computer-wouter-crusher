package pieces;

import general.Move;
import general.Position;

import java.util.List;

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

    public Position getPosition() {
        return position;
    }

    public boolean isColorWhite() {
        return colorWhite;
    }

    abstract public String getDrawingCharacter();

    abstract List<Move> getPossibleMoves();
}
