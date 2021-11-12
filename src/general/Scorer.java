package general;

import board.Board;
import board.BoardStatus;
import pieces.Piece;

public class Scorer {
    static public double scoreBoard(Board board) {
        assert board.getStatus() == BoardStatus.CONTINUE;

        double sum = 0;
        for (Piece whitePiece : board.getWhitePiecesOnBoard()) {
            sum += whitePiece.getValue();
        }
        for (Piece blackPiece : board.getBlackPiecesOnBoard()) {
            sum -= blackPiece.getValue();
        }

        // Middle squares
//        for (int i = 3; i < 5; i++) {
//            for (int j = 3; j < 5; j++) {
//                Piece pieceAt = board.getPieceAt(i, j);
//                if (pieceAt != null) {
//                    if (pieceAt.isColorWhite()) {
//                        sum += 1.5;
//                    } else {
//                        sum -= 1.5;
//                    }
//                }
//            }
//        }

        return sum;
    }
}
