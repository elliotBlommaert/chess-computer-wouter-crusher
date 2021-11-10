package general;

import pieces.Piece;

public class Scorer {
    static public double scoreBoard(BoardState board) {
        if (board.getAllPossibleMoves().isEmpty()) {
            return board.whiteToMove() ? -1000 : 1000;
        }

        double sum = 0;
        for (Piece whitePiece : board.getWhitePiecesOnBoard()) {
            sum += whitePiece.getValue();
        }
        for (Piece blackPiece : board.getBlackPiecesOnBoard()) {
            sum -= blackPiece.getValue();
        }
        return sum;
    }
}
