package general;

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
        if (columnLetter == 'a') {
            this.column = 1;
        } else if (columnLetter == 'b') {
            this.column = 2;
        } else if (columnLetter == 'c') {
            this.column = 3;
        } else if (columnLetter == 'd') {
            this.column = 4;
        } else if (columnLetter == 'e') {
            this.column = 5;
        } else if (columnLetter == 'f') {
            this.column = 6;
        } else if (columnLetter == 'g') {
            this.column = 7;
        } else if (columnLetter == 'h') {
            this.column = 8;
        } else {
            throw new UnsupportedOperationException();
        }

        char rowLetter = positionString.charAt(1);
        int row = Character.getNumericValue(rowLetter);
        if (row > 0 && row < 9) {
            this.row = row;
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
}