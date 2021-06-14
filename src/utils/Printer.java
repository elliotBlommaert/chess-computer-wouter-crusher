package utils;

import com.sun.tools.javac.util.Pair;
import general.BoardState;
import pieces.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {

    private static String verticalWithRightJunction = "\u2560";
    private static String verticalWithLeftJunction = "\u2563";
    private static String horizontalWithLowerJunction = "\u2566";
    private static String horizontalWithUpperJunction = "\u2569";

    private static String upperLeftCorner = "\u2554";
    private static String upperRightCorner = "\u2557";
    private static String lowerLeftCorner = "\u255A";
    private static String lowerRightCorner = "\u255D";

    private static String centralJunction = "\u256C";
    private static String horizontal = "\u2550";
    private static String tripleHorizontal = "\u2550\u2550\u2550";
    private static String vertical = "\u2551";


    static public String printBoard(BoardState boardState) {
        Map<Pair<Integer, Integer>, Piece> positionToPiece = new HashMap<>();

        for (Piece piece : boardState.getPieces()) {
            int column = piece.getPosition().getColumn();
            int row = piece.getPosition().getRow();

            Pair<Integer, Integer> position = new Pair<>(column, row);
            assert !positionToPiece.containsKey(position);

            positionToPiece.put(position, piece);
        }


        // now make the actual string
        StringBuilder bobTheBuilder = new StringBuilder();
        bobTheBuilder.append(createTopLine() + "\n");
        bobTheBuilder.append(createLineForRowNumber(7, positionToPiece) + "\n");
        for (int rowNumber = 6; rowNumber >= 0; rowNumber--) {
            bobTheBuilder.append(createMiddleLine() + "\n");
            bobTheBuilder.append(createLineForRowNumber(rowNumber, positionToPiece) + "\n");
        }
        bobTheBuilder.append(createBottomLine() + "\n");


        return bobTheBuilder.toString();
    }


    private static String createTopLine() {
        StringBuilder upperLineBuilder = new StringBuilder();
        upperLineBuilder.append(upperLeftCorner);
        upperLineBuilder.append(tripleHorizontal);
        for (int i = 0; i < 7; i++) {
            upperLineBuilder.append(horizontalWithLowerJunction + tripleHorizontal);
        }
        upperLineBuilder.append(upperRightCorner);
        return upperLineBuilder.toString();
    }


    private static String createMiddleLine() {
        StringBuilder middleLineBuilder = new StringBuilder();
        middleLineBuilder.append(verticalWithRightJunction);
        middleLineBuilder.append(tripleHorizontal);
        for (int i = 0; i < 7; i++) {
            middleLineBuilder.append(centralJunction + tripleHorizontal);
        }
        middleLineBuilder.append(verticalWithLeftJunction);
        return middleLineBuilder.toString();
    }

    private static String createBottomLine() {
        StringBuilder lowerLineBuilder = new StringBuilder();
        lowerLineBuilder.append(lowerLeftCorner);
        lowerLineBuilder.append(tripleHorizontal);
        for (int i = 0; i < 7; i++) {
            lowerLineBuilder.append(horizontalWithUpperJunction + tripleHorizontal);
        }
        lowerLineBuilder.append(lowerRightCorner);
        return lowerLineBuilder.toString();
    }

    private static String createLineForRowNumber(int rowNumber, Map<Pair<Integer, Integer>, Piece> positionToPiece) {
        assert rowNumber < 8;

        List<String> stringPerColumn = new ArrayList<>();

        for (int columnNumber = 0; columnNumber < 8; columnNumber++) {
            Pair<Integer, Integer> position = new Pair<>(columnNumber, rowNumber);
            if (positionToPiece.containsKey(position)) {
                stringPerColumn.add("\u2009\u200A" + positionToPiece.get(position).getDrawingCharacter() + "\u200A\u200A\u200A");
            } else {
                stringPerColumn.add("   ");
            }
        }

        return vertical + String.join(vertical, stringPerColumn) + vertical;
    }


}
