package general;

import com.sun.tools.javac.util.Pair;
import pieces.*;
import utils.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardState {

    private boolean whiteToMove;
    private List<List<Piece>> pieces;

    public BoardState(boolean whiteToMove, List<List<Piece>> pieces) {
        this.whiteToMove = whiteToMove;
        this.pieces = pieces;
    }

    private BoardState() {
        whiteToMove = true;
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
        Rook whiteRook1 = new Rook(true, bottomRow, 0);
        Knight whiteKnight1 = new Knight(true, bottomRow, 1);
        Bishop whiteBishop1 = new Bishop(true, bottomRow, 2);
        Queen whiteQueen = new Queen(true, bottomRow, 3);
        King whiteKing = new King(true, bottomRow, 4);
        Bishop whiteBishop2 = new Bishop(true, bottomRow, 5);
        Knight whiteKnight2 = new Knight(true, bottomRow, 6);
        Rook whiteRook2 = new Rook(true, bottomRow, 7);

        boardState.addPiece(whiteRook1);
        boardState.addPiece(whiteRook2);
        boardState.addPiece(whiteBishop1);
        boardState.addPiece(whiteBishop2);
        boardState.addPiece(whiteKnight1);
        boardState.addPiece(whiteKnight2);
        boardState.addPiece(whiteQueen);
        boardState.addPiece(whiteKing);

        // second white row
        int secondRow = 1;
        Pawn whitePawn1 = new Pawn(true, secondRow, 0);
        Pawn whitePawn2 = new Pawn(true, secondRow, 1);
        Pawn whitePawn3 = new Pawn(true, secondRow, 2);
        Pawn whitePawn4 = new Pawn(true, secondRow, 3);
        Pawn whitePawn5 = new Pawn(true, secondRow, 4);
        Pawn whitePawn6 = new Pawn(true, secondRow, 5);
        Pawn whitePawn7 = new Pawn(true, secondRow, 6);
        Pawn whitePawn8 = new Pawn(true, secondRow, 7);
        boardState.addPiece(whitePawn1);
        boardState.addPiece(whitePawn2);
        boardState.addPiece(whitePawn3);
        boardState.addPiece(whitePawn4);
        boardState.addPiece(whitePawn5);
        boardState.addPiece(whitePawn6);
        boardState.addPiece(whitePawn7);
        boardState.addPiece(whitePawn8);

        int secondLastRow = 6;
        Pawn blackPawn1 = new Pawn(false, secondLastRow, 0);
        Pawn blackPawn2 = new Pawn(false, secondLastRow, 1);
        Pawn blackPawn3 = new Pawn(false, secondLastRow, 2);
        Pawn blackPawn4 = new Pawn(false, secondLastRow, 3);
        Pawn blackPawn5 = new Pawn(false, secondLastRow, 4);
        Pawn blackPawn6 = new Pawn(false, secondLastRow, 5);
        Pawn blackPawn7 = new Pawn(false, secondLastRow, 6);
        Pawn blackPawn8 = new Pawn(false, secondLastRow, 7);
        boardState.addPiece(blackPawn1);
        boardState.addPiece(blackPawn2);
        boardState.addPiece(blackPawn3);
        boardState.addPiece(blackPawn4);
        boardState.addPiece(blackPawn5);
        boardState.addPiece(blackPawn6);
        boardState.addPiece(blackPawn7);
        boardState.addPiece(blackPawn8);

        int topRow = 7;
        Rook blackRook1 = new Rook(false, topRow, 0);
        Knight blackKnight1 = new Knight(false, topRow, 1);
        Bishop blackBishop1 = new Bishop(false, topRow, 2);
        Queen blackQueen = new Queen(false, topRow, 3);
        King blackKing = new King(false, topRow, 4);
        Bishop blackBishop2 = new Bishop(false, topRow, 5);
        Knight blackKnight2 = new Knight(false, topRow, 6);
        Rook blackRook2 = new Rook(false, topRow, 7);
        boardState.addPiece(blackRook1);
        boardState.addPiece(blackRook2);
        boardState.addPiece(blackBishop1);
        boardState.addPiece(blackBishop2);
        boardState.addPiece(blackKnight1);
        boardState.addPiece(blackKnight2);
        boardState.addPiece(blackQueen);
        boardState.addPiece(blackKing);

        return boardState;
    }
    
    private Piece getPieceAt(Position pos) {
        return pieces.get(pos.getColumn()).get(pos.getRow());
    }

    private void addPiece(Piece p) {
        Position pos = p.getPosition();
        assert getPieceAt(pos) == null;
        pieces.get(pos.getColumn()).set(pos.getRow(), p);
    }

    private boolean validate() {
        for (int i = 0; i < pieces.size(); i++) {
            List<Piece> pieceList = pieces.get(i);
            for (int j = 0; j < pieceList.size(); j++) {
                Piece piece = pieceList.get(j);
                if (piece != null) {
                    Position pos = piece.getPosition();
                    if (pos.getColumn() != i || pos.getRow() != j) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

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
        assert validate();
        return Printer.printBoard(this);
    }


}

