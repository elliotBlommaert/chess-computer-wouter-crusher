package general;

import com.sun.tools.javac.util.Pair;
import moves.Move;
import pieces.*;
import utils.Printer;

import java.util.*;

public class BoardState {

    private boolean whiteToMove;
    private int availableId;
    private List<List<Piece>> pieces;
    private Set<Piece> whitePiecesOnBoard;
    private Set<Piece> blackPiecesOnBoard;
    private List<ReverseMove> moveHistory;
    private int whiteCanEnPassantToColumn;
    private int blackCanEnPassantToColumn;
    private boolean whiteCanQueenSideCastle;
    private boolean whiteCanKingSideCastle;
    private boolean blackCanQueenSideCastle;
    private boolean blackCanKingSideCastle;


    public BoardState() {
        whiteToMove = true;
        whitePiecesOnBoard = new HashSet<>();
        blackPiecesOnBoard = new HashSet<>();
        moveHistory = new ArrayList<>();
        whiteCanEnPassantToColumn = -1;
        blackCanEnPassantToColumn = -1;
        whiteCanQueenSideCastle = false;
        whiteCanKingSideCastle = false;
        blackCanQueenSideCastle = false;
        blackCanKingSideCastle = false;

        pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ArrayList<Piece> currentRow = new ArrayList<>();
            pieces.add(currentRow);
            for (int j = 0; j < 8; j++) {
                currentRow.add(null);
            }
        }
    }

    public static BoardState getDefaultStartBoard() {
        BoardState boardState = new BoardState();
        boardState.whiteCanQueenSideCastle = true;
        boardState.whiteCanKingSideCastle = true;
        boardState.blackCanQueenSideCastle = true;
        boardState.blackCanKingSideCastle = true;

        // bottom white row;
        int bottomRow = 0;
        boardState.addPiece(new Rook(true, boardState.getIdForNewPieceAndUpdate()), new Position(0, bottomRow));
        boardState.addPiece(new Knight(true, boardState.getIdForNewPieceAndUpdate()), new Position(1, bottomRow));
        boardState.addPiece(new Bishop(true, boardState.getIdForNewPieceAndUpdate()), new Position(2, bottomRow));
        boardState.addPiece(new Queen(true, boardState.getIdForNewPieceAndUpdate()), new Position(3, bottomRow));
        boardState.addPiece(new King(true, boardState.getIdForNewPieceAndUpdate()), new Position(4, bottomRow));
        boardState.addPiece(new Bishop(true, boardState.getIdForNewPieceAndUpdate()), new Position(5, bottomRow));
        boardState.addPiece(new Knight(true, boardState.getIdForNewPieceAndUpdate()), new Position(6, bottomRow));
        boardState.addPiece(new Rook(true, boardState.getIdForNewPieceAndUpdate()), new Position(7, bottomRow));

        // second white row
        int secondRow = 1;
        boardState.addPiece(new Pawn(true, boardState.getIdForNewPieceAndUpdate()), new Position(0, secondRow));
        boardState.addPiece(new Pawn(true, boardState.getIdForNewPieceAndUpdate()), new Position(1, secondRow));
        boardState.addPiece(new Pawn(true, boardState.getIdForNewPieceAndUpdate()), new Position(2, secondRow));
        boardState.addPiece(new Pawn(true, boardState.getIdForNewPieceAndUpdate()), new Position(3, secondRow));
        boardState.addPiece(new Pawn(true, boardState.getIdForNewPieceAndUpdate()), new Position(4, secondRow));
        boardState.addPiece(new Pawn(true, boardState.getIdForNewPieceAndUpdate()), new Position(5, secondRow));
        boardState.addPiece(new Pawn(true, boardState.getIdForNewPieceAndUpdate()), new Position(6, secondRow));
        boardState.addPiece(new Pawn(true, boardState.getIdForNewPieceAndUpdate()), new Position(7, secondRow));

        int secondLastRow = 6;
        boardState.addPiece(new Pawn(false, boardState.getIdForNewPieceAndUpdate()), new Position(0, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.getIdForNewPieceAndUpdate()), new Position(1, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.getIdForNewPieceAndUpdate()), new Position(2, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.getIdForNewPieceAndUpdate()), new Position(3, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.getIdForNewPieceAndUpdate()), new Position(4, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.getIdForNewPieceAndUpdate()), new Position(5, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.getIdForNewPieceAndUpdate()), new Position(6, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.getIdForNewPieceAndUpdate()), new Position(7, secondLastRow));

        int topRow = 7;
        boardState.addPiece(new Rook(false, boardState.getIdForNewPieceAndUpdate()), new Position(0, topRow));
        boardState.addPiece(new Knight(false, boardState.getIdForNewPieceAndUpdate()), new Position(1, topRow));
        boardState.addPiece(new Bishop(false, boardState.getIdForNewPieceAndUpdate()), new Position(2, topRow));
        boardState.addPiece(new Queen(false, boardState.getIdForNewPieceAndUpdate()), new Position(3, topRow));
        boardState.addPiece(new King(false, boardState.getIdForNewPieceAndUpdate()), new Position(4, topRow));
        boardState.addPiece(new Bishop(false, boardState.getIdForNewPieceAndUpdate()), new Position(5, topRow));
        boardState.addPiece(new Knight(false, boardState.getIdForNewPieceAndUpdate()), new Position(6, topRow));
        boardState.addPiece(new Rook(false, boardState.getIdForNewPieceAndUpdate()), new Position(7, topRow));

        return boardState;
    }

    public boolean whiteCanQueenSideCastle() {
        return whiteCanQueenSideCastle;
    }

    public boolean whiteCanKingSideCastle() {
        return whiteCanKingSideCastle;
    }

    public boolean blackCanQueenSideCastle() {
        return blackCanQueenSideCastle;
    }

    public boolean blackCanKingSideCastle() {
        return blackCanKingSideCastle;
    }

    public Piece getPieceAt(Position pos) {
        return pieces.get(pos.getColumn()).get(pos.getRow());
    }

    public Piece getPieceAt(int column, int row) {
        return pieces.get(column).get(row);
    }

//    public List<Move> getAllPossibleMoves() {
//        if (isChecked(whiteToMove)) {
//            return getPossibleMovesForCheck()
//        } else {
//
//        }
//        return null;
//    }

    public CheckedData isChecked(boolean isWhite) {
        Position kingPosition = findKingPosition(isWhite);
        List<Position> checkPositions = new ArrayList<>();

        List<Pair<Integer, Integer>> horizontalAndVerticalDirections = Arrays.asList(
                new Pair<>(0, 1),
                new Pair<>(0, -1),
                new Pair<>(-1, 0),
                new Pair<>(1, 0)
        );

        int kingColumn = kingPosition.getColumn();
        int kingRow = kingPosition.getRow();

        for (Pair<Integer, Integer> direction : horizontalAndVerticalDirections) {
            int newColumn = kingColumn;
            int newRow = kingRow;

            List<Position> currentMaybeResolvingCheckPositions = new ArrayList<>();
            int directionColumnIncrement = direction.fst;
            int directionRowIncrement = direction.snd;

            newColumn += directionColumnIncrement;
            newRow += directionRowIncrement;
            while (newColumn < 8 && newColumn >= 0 && newRow < 8 && newRow >= 0) {
                Piece pieceAt = getPieceAt(newColumn, newRow);
                currentMaybeResolvingCheckPositions.add(new Position(newColumn, newRow));
                if (pieceAt != null) {
                    if (pieceAt.isColorWhite() != isWhite && (pieceAt instanceof Queen || pieceAt instanceof Rook)) {
                        if (!checkPositions.isEmpty()) {
                            return new CheckedData(Collections.emptyList());
                        }
                        checkPositions.addAll(currentMaybeResolvingCheckPositions);
                    }
                    break;
                }
                newColumn += directionColumnIncrement;
                newRow += directionRowIncrement;
            }
        }

        List<Pair<Integer, Integer>> diagonalDirections = Arrays.asList(
                new Pair<>(1, 1),
                new Pair<>(-1, 1),
                new Pair<>(1, -1),
                new Pair<>(-1, -1)
        );
        for (Pair<Integer, Integer> direction : diagonalDirections) {
            int newColumn = kingColumn;
            int newRow = kingRow;
            List<Position> currentMaybeResolvingCheckPositions = new ArrayList<>();
            int directionColumnIncrement = direction.fst;
            int directionRowIncrement = direction.snd;

            newColumn += directionColumnIncrement;
            newRow += directionRowIncrement;
            while (newColumn < 8 && newColumn >= 0 && newRow < 8 && newRow >= 0) {
                Piece pieceAt = getPieceAt(newColumn, newRow);
                currentMaybeResolvingCheckPositions.add(new Position(newColumn, newRow));
                if (pieceAt != null) {
                    if (pieceAt.isColorWhite() != isWhite && (pieceAt instanceof Queen || pieceAt instanceof Bishop)) {
                        if (!checkPositions.isEmpty()) {
                            return new CheckedData(Collections.emptyList());
                        }
                        checkPositions.addAll(currentMaybeResolvingCheckPositions);
                    }
                    break;
                }
                newColumn += directionColumnIncrement;
                newRow += directionRowIncrement;
            }
        }

        List<Pair<Integer, Integer>> knightDirections = Arrays.asList(
                new Pair<>(2, 1),
                new Pair<>(1, 2),

                new Pair<>(-2, 1),
                new Pair<>(-1, 2),

                new Pair<>(2, -1),
                new Pair<>(1, -2),

                new Pair<>(-2, -1),
                new Pair<>(-1, -2)
        );

        for (Pair<Integer, Integer> knightDirection : knightDirections) {
            int newColumn = knightDirection.fst + kingColumn;
            int newRow = knightDirection.snd + kingRow;
            if (newColumn < 8 && newColumn >= 0 && newRow < 8 && newRow >= 0) {
                Piece pieceAt = getPieceAt(newColumn, newRow);
                if (pieceAt != null && pieceAt.isColorWhite() != isWhite && pieceAt instanceof Knight) {
                    if (!checkPositions.isEmpty()) {
                        return new CheckedData(Collections.emptyList());
                    }

                    checkPositions.add(new Position(newColumn, newRow));
                }
            }
        }

        int checkPawnDirection = isWhite ? 1 : -1;

        int leftPawnColumn = kingColumn - 1;
        int leftPawnRow = kingRow + checkPawnDirection;
        if (leftPawnColumn >= 0 && leftPawnRow < 8 && leftPawnRow >= 0) {
            Piece pieceAt = getPieceAt(leftPawnColumn, leftPawnRow);

            if (pieceAt != null && pieceAt.isColorWhite() != isWhite && pieceAt instanceof Pawn) {
                if (!checkPositions.isEmpty()) {
                    return new CheckedData(Collections.emptyList());
                }

                checkPositions.add(new Position(leftPawnColumn, leftPawnRow));
            }
        }

        int rightPawnColumn = kingColumn + 1;
        int rightPawnRow = kingRow + checkPawnDirection;
        if (rightPawnColumn < 8 && rightPawnRow < 8 && rightPawnRow >= 0) {
            Piece pieceAt = getPieceAt(rightPawnColumn, rightPawnRow);

            if (pieceAt != null && pieceAt.isColorWhite() != isWhite && pieceAt instanceof Pawn) {
                if (!checkPositions.isEmpty()) {
                    return new CheckedData(Collections.emptyList());
                }

                checkPositions.add(new Position(rightPawnColumn, rightPawnRow));
            }
        }

        if (checkPositions.isEmpty()) {
            return null;
        }

        return new CheckedData(checkPositions);
    }

    private Position findKingPosition(boolean isWhite) {

        Position kingPosition = null;
        for (int columnNumber = 0; columnNumber < pieces.size(); columnNumber++) {
            List<Piece> row = pieces.get(columnNumber);
            for (int rowNumber = 0; rowNumber < row.size(); rowNumber++) {
                Piece piece = row.get(rowNumber);
                if (piece != null && piece.isColorWhite() == isWhite && piece instanceof King) {
                    assert kingPosition == null;
                    kingPosition = new Position(columnNumber, rowNumber);
                }
            }
        }

        assert kingPosition != null;
        return kingPosition;
    }

    public void addPiece(Piece piece, Position position) {
        assert piece != null;

        assert getPieceAt(position) == null;
        assert isValid();

        if (piece.isColorWhite()) {
            assert !whitePiecesOnBoard.contains(piece);
            whitePiecesOnBoard.add(piece);
        } else {
            assert !blackPiecesOnBoard.contains(piece);
            blackPiecesOnBoard.add(piece);
        }
        pieces.get(position.getColumn()).set(position.getRow(), piece);
        assert isValid();
    }

    private void displacePiece(Piece pieceToDisplace, Position fromPosition, Position toPosition) {
        assert pieceToDisplace != null;

        putPieceOnPosition(null, fromPosition);
        putPieceOnPosition(pieceToDisplace, toPosition);
        assert isValid();
    }

    private void removePiece(Piece pieceToRemove, Position position) {

        putPieceOnPosition(null, position);
        if (pieceToRemove.isColorWhite()) {
            assert whitePiecesOnBoard.contains(pieceToRemove);
            whitePiecesOnBoard.remove(pieceToRemove);
        } else {
            assert blackPiecesOnBoard.contains(pieceToRemove);
            blackPiecesOnBoard.remove(pieceToRemove);
        }
        assert isValid();
    }

    public void executeMove(Move move) {

        List<Pair<Piece, Pair<Position, Position>>> displacedPiecesOldPositions = new ArrayList<>();
        List<Pair<Piece, Position>> removedPieces = new ArrayList<>();
        List<Pair<Piece, Pair<Position, Position>>> piecesToMove = move.getPiecesToMove();
        for (Pair<Piece, Pair<Position, Position>> piecePositionPair : piecesToMove) {
            Piece pieceToMove = piecePositionPair.fst;
            Position oldPosition = piecePositionPair.snd.fst;
            Position newPosition = piecePositionPair.snd.snd;
            Piece currentPieceAtNewPosition = getPieceAt(newPosition);

            assert getPieceAt(oldPosition).equals(pieceToMove);

            displacedPiecesOldPositions.add(new Pair<>(pieceToMove, new Pair<>(oldPosition, newPosition)));

            if (currentPieceAtNewPosition != null) {
                assert currentPieceAtNewPosition.isColorWhite() != pieceToMove.isColorWhite();
                removedPieces.add(new Pair<>(currentPieceAtNewPosition, newPosition));
                removePiece(currentPieceAtNewPosition, newPosition);
            }
            displacePiece(pieceToMove, oldPosition, newPosition);
        }

        List<Pair<Piece, Position>> piecesToRemoveAtPosition = move.getPiecesToRemove();
        if (piecesToRemoveAtPosition != null && !piecesToRemoveAtPosition.isEmpty()) {
            assert removedPieces.isEmpty();
            for (Pair<Piece, Position> piecePositionToRemove : piecesToRemoveAtPosition) {
                Piece pieceToRemove = piecePositionToRemove.fst;
                Position positionToRemovePieceFrom = piecePositionToRemove.snd;
                removePiece(pieceToRemove, positionToRemovePieceFrom);
                removedPieces.add(new Pair<>(pieceToRemove, positionToRemovePieceFrom));
            }

        }

        Pair<Piece, Position> pieceToCreateAtPosition = move.getPieceToCreate();
        Pair<Piece, Position> createdPiece = null;
        if (pieceToCreateAtPosition != null) {
            Piece newPiece = pieceToCreateAtPosition.fst;
            Position newPosition = pieceToCreateAtPosition.snd;
            addPiece(newPiece, newPosition);
            createdPiece = new Pair<>(newPiece, newPosition);
        }

        int previousEnPassantColumn = whiteToMove ? blackCanEnPassantToColumn : whiteCanEnPassantToColumn;
        ReverseMove newReverseMove = new ReverseMove(displacedPiecesOldPositions, createdPiece, removedPieces, previousEnPassantColumn);
        moveHistory.add(newReverseMove);

        if (whiteToMove) {
            blackCanEnPassantToColumn = move.getEnabledEnPassantColumn();
            if (whiteCanKingSideCastle && (getPieceAt(7, 0) == null || getPieceAt(4, 0) == null)) {
                whiteCanKingSideCastle = false;
            }
            if (whiteCanQueenSideCastle && (getPieceAt(0, 0) == null || getPieceAt(4, 0) == null)) {
                whiteCanQueenSideCastle = false;
            }
        } else {
            whiteCanEnPassantToColumn = move.getEnabledEnPassantColumn();
            if (blackCanKingSideCastle && (getPieceAt(7, 7) == null || getPieceAt(4, 7) == null)) {
                blackCanKingSideCastle = false;
            }
            if (blackCanQueenSideCastle && (getPieceAt(0, 7) == null || getPieceAt(4, 7) == null)) {
                blackCanQueenSideCastle = false;
            }
        }
        whiteToMove = !whiteToMove;
    }

    public void revertLastMove() {
        whiteToMove = !whiteToMove;

        ReverseMove lastMove = moveHistory.get(moveHistory.size() - 1);
        for (Pair<Piece, Pair<Position, Position>> pieceOldPositionNewPositionPair : lastMove.displacedPiecesWithOldPosition) {
            Piece piece = pieceOldPositionNewPositionPair.fst;
            Position oldPositionPiece = pieceOldPositionNewPositionPair.snd.fst;
            Position newPositionPiece = pieceOldPositionNewPositionPair.snd.snd;
            putPieceOnPosition(piece, oldPositionPiece);
            putPieceOnPosition(null, newPositionPiece);
        }

        if (lastMove.createdPiece != null) {
            Piece createdPieceToRemove = lastMove.createdPiece.fst;
            Position positionToRemoveFrom = lastMove.createdPiece.snd;
            removePiece(createdPieceToRemove, positionToRemoveFrom);
        }

        if (lastMove.removedPieces != null && !lastMove.removedPieces.isEmpty()) {

            for (Pair<Piece, Position> removedPiece : lastMove.removedPieces) {
                Piece removePieceToCreate = removedPiece.fst;
                Position positionToCreateOn = removedPiece.snd;
                addPiece(removePieceToCreate, positionToCreateOn);
            }
        }

        if (whiteToMove) {
            blackCanEnPassantToColumn = lastMove.previousEnPassantColumn;
            if (lastMove.disallowedQueenSideCastle) {
                whiteCanQueenSideCastle = true;
            } else if (lastMove.disallowedKingSideCastle) {
                whiteCanKingSideCastle = true;
            }
        }
        if (!whiteToMove) {
            whiteCanEnPassantToColumn = lastMove.previousEnPassantColumn;
            if (lastMove.disallowedQueenSideCastle) {
                blackCanQueenSideCastle = true;
            } else if (lastMove.disallowedKingSideCastle) {
                blackCanKingSideCastle = true;
            }
        }
        moveHistory.remove(moveHistory.size() - 1);
    }

    private void putPieceOnPosition(Piece piece, Position position) {
        pieces.get(position.getColumn()).set(position.getRow(), piece);
    }


    public boolean isValid() {
//        Set<Piece> whitePieces = new HashSet<>();
//        Set<Piece> blackPieces = new HashSet<>();
//        for (int i = 0; i < pieces.size(); i++) {
//            List<Piece> pieceList = pieces.get(i);
//            for (int j = 0; j < pieceList.size(); j++) {
//                Piece piece = pieceList.get(j);
//                if (piece != null) {
//                    if (piece.isColorWhite()) {
//                        whitePieces.add(piece);
//                    } else {
//                        blackPieces.add(piece);
//                    }
//                    Position pos = piece.getPosition();
//                    if (pos.getColumn() != i || pos.getRow() != j) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        if (!whitePieces.equals(whitePiecesOnBoard)) {
//            return false;
//        }
//
//        if (!blackPieces.equals(blackPiecesOnBoard)) {
//            return false;
//        }
        return true;
    }

    public int getIdForNewPieceAndUpdate() {
        int idForNewPiece = availableId;
        availableId++;
        return idForNewPiece;
    }

    // exists only for print
    public Map<Pair<Integer, Integer>, Piece> getPositionsToPieces() {
        Map<Pair<Integer, Integer>, Piece> positionsToPieces = new HashMap<>();
        for (int i = 0; i < pieces.size(); i++) {
            List<Piece> pieceList = pieces.get(i);
            for (int j = 0; j < pieceList.size(); j++) {
                Piece piece = pieceList.get(j);
                if (piece != null) {
                    positionsToPieces.put(new Pair<>(i, j), piece);
                }
            }
        }
        return positionsToPieces;
    }

    @Override
    public String toString() {
        assert isValid();
        return Printer.printBoard(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardState that = (BoardState) o;
        return whiteToMove == that.whiteToMove && availableId == that.availableId && whiteCanEnPassantToColumn == that.whiteCanEnPassantToColumn && blackCanEnPassantToColumn == that.blackCanEnPassantToColumn && whiteCanQueenSideCastle == that.whiteCanQueenSideCastle && whiteCanKingSideCastle == that.whiteCanKingSideCastle && blackCanQueenSideCastle == that.blackCanQueenSideCastle && blackCanKingSideCastle == that.blackCanKingSideCastle && Objects.equals(pieces, that.pieces) && Objects.equals(whitePiecesOnBoard, that.whitePiecesOnBoard) && Objects.equals(blackPiecesOnBoard, that.blackPiecesOnBoard) && Objects.equals(moveHistory, that.moveHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whiteToMove, availableId, pieces, whitePiecesOnBoard, blackPiecesOnBoard, moveHistory, whiteCanEnPassantToColumn, blackCanEnPassantToColumn, whiteCanQueenSideCastle, whiteCanKingSideCastle, blackCanQueenSideCastle, blackCanKingSideCastle);
    }

    public boolean canEnPassantToColumn(boolean colorWhite, int column) {
        if (colorWhite) {
            return whiteCanEnPassantToColumn == column;
        } else {
            return blackCanEnPassantToColumn == column;
        }
    }


    private static class ReverseMove {
        private final List<Pair<Piece, Pair<Position, Position>>> displacedPiecesWithOldPosition;
        private final Pair<Piece, Position> createdPiece;
        private final List<Pair<Piece, Position>> removedPieces;
        private final boolean disallowedQueenSideCastle;
        private final boolean disallowedKingSideCastle;
        private final int previousEnPassantColumn;

        public ReverseMove(List<Pair<Piece, Pair<Position, Position>>> displacedPiecesWithOldPosition, Pair<Piece, Position> createdPiece, List<Pair<Piece, Position>> removedPieces, int previousEnPassantColumn) {
            this.displacedPiecesWithOldPosition = displacedPiecesWithOldPosition;
            this.createdPiece = createdPiece;
            this.removedPieces = removedPieces;
            this.previousEnPassantColumn = previousEnPassantColumn;
            disallowedQueenSideCastle = false;
            disallowedKingSideCastle = false;
        }
    }
}

