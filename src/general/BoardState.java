package general;

import com.sun.tools.javac.util.Pair;
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


    public BoardState() {
        whiteToMove = true;
        whitePiecesOnBoard = new HashSet<>();
        blackPiecesOnBoard = new HashSet<>();
        moveHistory = new ArrayList<>();
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

        // bottom white row;
        int bottomRow = 0;
        boardState.addPiece(new Rook(true, boardState.availableId), new Position(0, bottomRow));
        boardState.addPiece(new Knight(true, boardState.availableId), new Position(1, bottomRow));
        boardState.addPiece(new Bishop(true, boardState.availableId), new Position(2, bottomRow));
        boardState.addPiece(new Queen(true, boardState.availableId), new Position(3, bottomRow));
        boardState.addPiece(new King(true, boardState.availableId), new Position(4, bottomRow));
        boardState.addPiece(new Bishop(true, boardState.availableId), new Position(5, bottomRow));
        boardState.addPiece(new Knight(true, boardState.availableId), new Position(6, bottomRow));
        boardState.addPiece(new Rook(true, boardState.availableId), new Position(7, bottomRow));

        // second white row
        int secondRow = 1;
        boardState.addPiece(new Pawn(true, boardState.availableId), new Position(0, secondRow));
        boardState.addPiece(new Pawn(true, boardState.availableId), new Position(1, secondRow));
        boardState.addPiece(new Pawn(true, boardState.availableId), new Position(2, secondRow));
        boardState.addPiece(new Pawn(true, boardState.availableId), new Position(3, secondRow));
        boardState.addPiece(new Pawn(true, boardState.availableId), new Position(4, secondRow));
        boardState.addPiece(new Pawn(true, boardState.availableId), new Position(5, secondRow));
        boardState.addPiece(new Pawn(true, boardState.availableId), new Position(6, secondRow));
        boardState.addPiece(new Pawn(true, boardState.availableId), new Position(7, secondRow));

        int secondLastRow = 6;
        boardState.addPiece(new Pawn(false, boardState.availableId), new Position(0, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.availableId), new Position(1, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.availableId), new Position(2, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.availableId), new Position(3, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.availableId), new Position(4, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.availableId), new Position(5, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.availableId), new Position(6, secondLastRow));
        boardState.addPiece(new Pawn(false, boardState.availableId), new Position(7, secondLastRow));


        int topRow = 7;
        boardState.addPiece(new Rook(false, boardState.availableId), new Position(0, topRow));
        boardState.addPiece(new Knight(false, boardState.availableId), new Position(1, topRow));
        boardState.addPiece(new Bishop(false, boardState.availableId), new Position(2, topRow));
        boardState.addPiece(new Queen(false, boardState.availableId), new Position(3, topRow));
        boardState.addPiece(new King(false, boardState.availableId), new Position(4, topRow));
        boardState.addPiece(new Bishop(false, boardState.availableId), new Position(5, topRow));
        boardState.addPiece(new Knight(false, boardState.availableId), new Position(6, topRow));
        boardState.addPiece(new Rook(false, boardState.availableId), new Position(7, topRow));

        return boardState;
    }

    public Piece getPieceAt(Position pos) {
        return pieces.get(pos.getColumn()).get(pos.getRow());
    }

    public Piece getPieceAt(int column, int row) {
        return pieces.get(column).get(row);
    }

    public void addPiece(Piece piece, Position position) {
        assert piece != null;

        assert getPieceAt(position) == null;
        assert isValid();

        availableId++;
        if (piece.isColorWhite()) {
            whitePiecesOnBoard.add(piece);
        } else {
            blackPiecesOnBoard.add(piece);
        }
        pieces.get(position.getColumn()).set(position.getRow(), piece);
        assert isValid();
    }

    private void displacePiece(Piece pieceToDisplace, Position fromPosition, Position toPosition) {
        assert pieceToDisplace != null;

        putPieceOnPosition(fromPosition, null);
        putPieceOnPosition(toPosition, pieceToDisplace);
        assert isValid();
    }

    private void removePiece(Piece pieceToRemove, Position position) {

        putPieceOnPosition(position, null);
        if (pieceToRemove.isColorWhite()) {
            whitePiecesOnBoard.remove(pieceToRemove);
        } else {
            blackPiecesOnBoard.remove(pieceToRemove);
        }
        assert isValid();
    }

    public void executeMove(Move move) {

        List<Pair<Piece, Position>> oldPiecePositions = new ArrayList<>();

        List<Pair<Piece, Pair<Position, Position>>> piecesToMove = move.getPiecesToMove();
        for (Pair<Piece, Pair<Position, Position>> piecePositionPair : piecesToMove) {
            Piece pieceToMove = piecePositionPair.fst;
            Position oldPosition = piecePositionPair.snd.fst;
            Position newPosition = piecePositionPair.snd.snd;
            Piece currentPieceAtNewPosition = getPieceAt(newPosition);

            assert getPieceAt(oldPosition).equals(pieceToMove);

            oldPiecePositions.add(new Pair<>(pieceToMove, oldPosition));
            oldPiecePositions.add(new Pair<>(currentPieceAtNewPosition, newPosition));

            if (currentPieceAtNewPosition != null) {
                assert currentPieceAtNewPosition.isColorWhite() != pieceToMove.isColorWhite();
                removePiece(currentPieceAtNewPosition, newPosition);
            }
            displacePiece(pieceToMove, oldPosition, newPosition);
        }

        Pair<Piece, Position> pieceToCreateAtPosition = move.getPieceToCreate();
        if (pieceToCreateAtPosition != null) {
            Piece newPiece = pieceToCreateAtPosition.fst;
            Position newPosition = pieceToCreateAtPosition.snd;
            if (newPiece.isColorWhite()) {
                whitePiecesOnBoard.add(newPiece);
            } else {
                blackPiecesOnBoard.add(newPiece);
            }

            putPieceOnPosition(newPosition, newPiece);
        }

        Pair<Piece, Position> pieceToRemoveAtPosition = move.getPieceToCreate();
        if (pieceToRemoveAtPosition != null) {
            Piece newPiece = pieceToRemoveAtPosition.fst;
            Position newPosition = pieceToRemoveAtPosition.snd;
            if (newPiece.isColorWhite()) {
                assert whitePiecesOnBoard.contains(newPiece);
                whitePiecesOnBoard.remove(newPiece);
            } else {
                assert blackPiecesOnBoard.contains(newPiece);
                blackPiecesOnBoard.add(newPiece);
            }

            putPieceOnPosition(newPosition, newPiece);
        }

        ReverseMove newReverseMove = new ReverseMove(oldPiecePositions, null);
        moveHistory.add(newReverseMove);
    }

    public void revertLastMove() {
        ReverseMove lastMove = moveHistory.get(moveHistory.size() - 1);
        for (Pair<Piece, Position> piecePositionPair : lastMove.previousPiecePositionsDisplacements) {
            putPieceOnPosition(piecePositionPair.snd, piecePositionPair.fst);
        }
        moveHistory.remove(moveHistory.size() - 1);
    }

    private void putPieceOnPosition(Position position, Piece piece) {
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
        return whiteToMove == that.whiteToMove && Objects.equals(pieces, that.pieces) && Objects.equals(whitePiecesOnBoard, that.whitePiecesOnBoard) && Objects.equals(blackPiecesOnBoard, that.blackPiecesOnBoard) && Objects.equals(moveHistory, that.moveHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whiteToMove, pieces, whitePiecesOnBoard, blackPiecesOnBoard, moveHistory);
    }

    private static class ReverseMove {
        private final List<Pair<Piece, Position>> previousPiecePositionsDisplacements;
        private final Pair<Piece, Position> createdPiece;

        public ReverseMove(List<Pair<Piece, Position>> previousPiecePositionsDisplacements, Pair<Piece, Position> createdPiece) {
            this.previousPiecePositionsDisplacements = previousPiecePositionsDisplacements;
            this.createdPiece = createdPiece;
        }
    }
}

