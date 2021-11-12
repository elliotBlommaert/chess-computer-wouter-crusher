package board;

import general.Position;
import pieces.*;

public class BoardBuilder {
    private final BoardState board;
    private static final String pieceFieldDelimiter = ",";
    private static final String differentPieceDelimiter = " - ";
    private int pieceId = 0;

    public BoardBuilder() {
        board = new BoardState();
    }

    public BoardBuilder blackToMove() {
        board.setWhiteToMove(false);
        return this;
    }

    private boolean parseColor(String colorStr) {
        if (colorStr.equals("b")) {
            return false;
        } else if (colorStr.equals("w")) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Piece parsePiece(String pieceStr, boolean isWhite) {
        if ("P".equals(pieceStr)) {
            return new Pawn(isWhite, pieceId++);
        } else if ("R".equals(pieceStr)) {
            return new Rook(isWhite, pieceId++);
        } else if ("KN".equals(pieceStr)) {
            return new Knight(isWhite, pieceId++);
        } else if ("B".equals(pieceStr)) {
            return new Bishop(isWhite, pieceId++);
        } else if ("Q".equals(pieceStr)) {
            return new Queen(isWhite, pieceId++);
        } else if ("K".equals(pieceStr)) {
            return new King(isWhite, pieceId++);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Position parsePosition(String positionStr) {
        assert positionStr.length() == 2;
        char columnChar = positionStr.charAt(0);
        int column;
        if ('A' == columnChar) {
            column = 0;
        } else if ('B' == columnChar) {
            column = 1;
        } else if ('C' == columnChar) {
            column = 2;
        } else if ('D' == columnChar) {
            column = 3;
        } else if ('E' == columnChar) {
            column = 4;
        } else if ('F' == columnChar) {
            column = 5;
        } else if ('G' == columnChar) {
            column = 6;
        } else if ('H' == columnChar) {
            column = 7;
        } else {
            throw new IllegalArgumentException();
        }

        int row = Integer.parseInt(String.valueOf(positionStr.charAt(1)));
        assert 0 <= row && row < 8;

        return new Position(column, row - 1);
    }

    public BoardBuilder addPiece(String pieceWithPositionString) {
        String[] pieceInfo = pieceWithPositionString.split(pieceFieldDelimiter);
        assert pieceInfo.length == 3;
        boolean isWhite = parseColor(pieceInfo[1]);
        Piece newPiece = parsePiece(pieceInfo[0], isWhite);
        Position newPosition = parsePosition(pieceInfo[2]);
        board.addPiece(newPiece, newPosition);

        return this;
    }

    public BoardBuilder addPieces(String piecesWithPositionsString) {
        String[] pieceStrings = piecesWithPositionsString.split(differentPieceDelimiter);

        for (String pieceString : pieceStrings) {
            addPiece(pieceString);
        }

        return this;
    }

    public BoardState build() {
        return board;
    }
}
