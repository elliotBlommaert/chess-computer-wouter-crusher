package general;

import java.util.Objects;

public class Position {

    private int row;
    private int column;

    public Position(int column, int row) {
        this.row = row;
        this.column = column;
    }

    public Position(String positionString) {
        if (positionString.length() != 2) {
            throw new UnsupportedOperationException();
        }

        char columnLetter = positionString.charAt(0);
        if (columnLetter == 'A') {
            this.column = 0;
        } else if (columnLetter == 'B') {
            this.column = 1;
        } else if (columnLetter == 'C') {
            this.column = 2;
        } else if (columnLetter == 'D') {
            this.column = 3;
        } else if (columnLetter == 'E') {
            this.column = 4;
        } else if (columnLetter == 'F') {
            this.column = 5;
        } else if (columnLetter == 'G') {
            this.column = 6;
        } else if (columnLetter == 'H') {
            this.column = 7;
        } else {
            throw new UnsupportedOperationException();
        }

        char rowLetter = positionString.charAt(1);
        int row = Character.getNumericValue(rowLetter);
        if (row > 0 && row < 9) {
            this.row = row - 1;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        String columns = "ABCDEFGH";
        return columns.charAt(column) + Integer.toString(row + 1);
    }
}
