package general;

import pieces.*;
import utils.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardState {


    private boolean whiteToMove;
    private List<Piece> pieces;

    private BoardState(boolean whiteToMove, List<Piece> pieces) {
        this.whiteToMove = whiteToMove;
        this.pieces = pieces;
    }


    public static BoardState getDefaultStartBoard() {

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

        List<Piece> pieces = new ArrayList<>();
        pieces.add(whiteRook1);
        pieces.add(whiteRook2);
        pieces.add(whiteBishop1);
        pieces.add(whiteBishop2);
        pieces.add(whiteKnight1);
        pieces.add(whiteKnight2);
        pieces.add(whiteQueen);
        pieces.add(whiteKing);

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
        pieces.add(whitePawn1);
        pieces.add(whitePawn2);
        pieces.add(whitePawn3);
        pieces.add(whitePawn4);
        pieces.add(whitePawn5);
        pieces.add(whitePawn6);
        pieces.add(whitePawn7);
        pieces.add(whitePawn8);

        int secondLastRow = 6;
        Pawn blackPawn1 = new Pawn(false, secondLastRow, 0);
        Pawn blackPawn2 = new Pawn(false, secondLastRow, 1);
        Pawn blackPawn3 = new Pawn(false, secondLastRow, 2);
        Pawn blackPawn4 = new Pawn(false, secondLastRow, 3);
        Pawn blackPawn5 = new Pawn(false, secondLastRow, 4);
        Pawn blackPawn6 = new Pawn(false, secondLastRow, 5);
        Pawn blackPawn7 = new Pawn(false, secondLastRow, 6);
        Pawn blackPawn8 = new Pawn(false, secondLastRow, 7);
        pieces.add(blackPawn1);
        pieces.add(blackPawn2);
        pieces.add(blackPawn3);
        pieces.add(blackPawn4);
        pieces.add(blackPawn5);
        pieces.add(blackPawn6);
        pieces.add(blackPawn7);
        pieces.add(blackPawn8);

        int topRow = 7;
        Rook blackRook1 = new Rook(false, topRow, 0);
        Knight blackKnight1 = new Knight(false, topRow, 1);
        Bishop blackBishop1 = new Bishop(false, topRow, 2);
        Queen blackQueen = new Queen(false, topRow, 3);
        King blackKing = new King(false, topRow, 4);
        Bishop blackBishop2 = new Bishop(false, topRow, 5);
        Knight blackKnight2 = new Knight(false, topRow, 6);
        Rook blackRook2 = new Rook(false, topRow, 7);
        pieces.add(blackRook1);
        pieces.add(blackRook2);
        pieces.add(blackBishop1);
        pieces.add(blackBishop2);
        pieces.add(blackKnight1);
        pieces.add(blackKnight2);
        pieces.add(blackQueen);
        pieces.add(blackKing);

        return new BoardState(true, pieces);
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    @Override
    public String toString() {







        return Printer.printBoard(this);
    }


}

