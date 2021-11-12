package general;

import board.BoardState;
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

        // Middle squares
        for (int i = 3; i < 5; i++) {
            for (int j = 3; j < 5; j++) {
                Piece pieceAt = board.getPieceAt(i, j);
                if (pieceAt != null) {
                    if (pieceAt.isColorWhite()) {
                        sum += 1.5;
                    } else {
                        sum -= 1.5;
                    }
                }
            }
        }

        return sum;
    }
}
