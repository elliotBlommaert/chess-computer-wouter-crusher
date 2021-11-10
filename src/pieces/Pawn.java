package pieces;

import general.*;
import moves.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    @Override
    public double getValue() {
        return 1;
    }

    public Pawn(boolean colorWhite, int id) {
        super(colorWhite, id);
    }


    @Override
    public String getDrawingCharacter() {
        String whitePawn = "\u2659";
        String blackPawn = "\u265F";


        return isColorWhite() ? whitePawn : blackPawn;
    }

    @Override
    public List<Move> getPossibleMoves(BoardState board, Position position) {
        assert board.getPieceAt(position).equals(this);

        List<Move> possibleMoves = new ArrayList<>();

        int direction = colorWhite ? 1 : -1;
        int finalRow = colorWhite ? 6 : 1;
        int startRow = position.getRow();
        int startColumn = position.getColumn();

        if (startRow == finalRow) {
            int idForNewPiece = board.getIdForNewPieceAndUpdate();

            if (board.getPieceAt(startColumn, startRow + direction) == null) {
                Position newPosition = new Position(startColumn, startRow + direction);

                Queen newQueen = new Queen(colorWhite, idForNewPiece);
                possibleMoves.add(new PromotionMove(newQueen, this, null, position, newPosition));

                Knight newKnight = new Knight(colorWhite, idForNewPiece);
                possibleMoves.add(new PromotionMove(newKnight, this, null, position, newPosition));

                Bishop newBishop = new Bishop(colorWhite, idForNewPiece);
                possibleMoves.add(new PromotionMove(newBishop, this, null, position, newPosition));

                Rook newRook = new Rook(colorWhite, idForNewPiece);
                possibleMoves.add(new PromotionMove(newRook, this, null, position, newPosition));
            }


            // Capture right
            if (startColumn + 1 < 8 && board.getPieceAt(startColumn + 1, startRow + direction) != null) {
                Piece pieceAt = board.getPieceAt(startColumn + 1, startRow + direction);
                if (colorWhite != pieceAt.colorWhite) {
                    Position newPosition = new Position(startColumn + 1, startRow + direction);
                    Queen newQueen = new Queen(colorWhite, idForNewPiece);
                    possibleMoves.add(new PromotionMove(newQueen, this, pieceAt, position, newPosition));

                    Knight newKnight = new Knight(colorWhite, idForNewPiece);
                    possibleMoves.add(new PromotionMove(newKnight, this, pieceAt, position, newPosition));

                    Bishop newBishop = new Bishop(colorWhite, idForNewPiece);
                    possibleMoves.add(new PromotionMove(newBishop, this, pieceAt, position, newPosition));

                    Rook newRook = new Rook(colorWhite, idForNewPiece);
                    possibleMoves.add(new PromotionMove(newRook, this, pieceAt, position, newPosition));
                }
            }
            // Capture left
            if (startColumn - 1 >= 0 && board.getPieceAt(startColumn - 1, startRow + direction) != null) {
                Piece pieceAt = board.getPieceAt(startColumn - 1, startRow + direction);
                if (colorWhite != pieceAt.colorWhite) {
                    Position newPosition = new Position(startColumn - 1, startRow + direction);
                    Queen newQueen = new Queen(colorWhite, idForNewPiece);
                    possibleMoves.add(new PromotionMove(newQueen, this, pieceAt, position, newPosition));

                    Knight newKnight = new Knight(colorWhite, idForNewPiece);
                    possibleMoves.add(new PromotionMove(newKnight, this, pieceAt, position, newPosition));

                    Bishop newBishop = new Bishop(colorWhite, idForNewPiece);
                    possibleMoves.add(new PromotionMove(newBishop, this, pieceAt, position, newPosition));

                    Rook newRook = new Rook(colorWhite, idForNewPiece);
                    possibleMoves.add(new PromotionMove(newRook, this, pieceAt, position, newPosition));
                }
            }

            return possibleMoves;
        }
        // Move forward
        if (board.getPieceAt(startColumn, startRow + direction) == null) {
            Position newPosition = new Position(startColumn, startRow + direction);

            possibleMoves.add(new DefaultMove(this, position, newPosition));

                // Two forward
                int initialRow = colorWhite ? 1 : 6;
                if (startRow == initialRow && board.getPieceAt(startColumn, startRow + 2 * direction) == null) {
                    Position newPosition2 = new Position(startColumn, startRow + 2 * direction);
                    possibleMoves.add(new AdvanceTwoMove(this, position, newPosition2));
                }
            }

        // Capture right
        if (startColumn + 1 < 8) {
            int canEnPassantRow = colorWhite ? 4 : 3;
            if (board.getPieceAt(startColumn + 1, startRow + direction) != null) {
                Piece pieceAt = board.getPieceAt(startColumn + 1, startRow + direction);
                if (colorWhite != pieceAt.colorWhite) {
                    Position newPosition = new Position(startColumn + 1, startRow + direction);
                    possibleMoves.add(new DefaultMove(this, position, newPosition));
                }
            } else if (startRow == canEnPassantRow &&board.canEnPassantToColumn(colorWhite, startColumn + 1)) {
                // En passant right
                Position newPosition = new Position(startColumn + 1, startRow + direction);
                Position capturedPosition = new Position(startColumn + 1, startRow);
                Piece capturedPiece = board.getPieceAt(capturedPosition);
                possibleMoves.add(new EnPassantMove(this, position, newPosition, capturedPiece, capturedPosition));
            }
        }
        // Capture left
        if (startColumn - 1 >= 0) {
            int canEnPassantRow = colorWhite ? 4 : 3;
            if (board.getPieceAt(startColumn - 1, startRow + direction) != null) {
                Piece pieceAt = board.getPieceAt(startColumn - 1, startRow + direction);
                if (colorWhite != pieceAt.colorWhite) {
                    Position newPosition = new Position(startColumn - 1, startRow + direction);
                    possibleMoves.add(new DefaultMove(this, position, newPosition));
                }
            } else if (startRow == canEnPassantRow && board.canEnPassantToColumn(colorWhite, startColumn - 1)) {
                // En passant left
                Position newPosition = new Position(startColumn - 1, startRow + direction);
                Position capturedPosition = new Position(startColumn - 1, startRow);
                Piece capturedPiece = board.getPieceAt(capturedPosition);
                possibleMoves.add(new EnPassantMove(this, position, newPosition, capturedPiece, capturedPosition));
            }
        }
        return possibleMoves;
    }

}
