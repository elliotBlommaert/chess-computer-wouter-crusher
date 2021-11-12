package tree;

import board.Board;
import board.BoardStatus;
import general.Pair;
import general.Scorer;
import moves.Move;

public class Tree {

    static public Pair<Double, Move> findOptimalMove(Board board, int depth) {

        if (depth == 0) {
            return new Pair<>(Scorer.scoreBoard(board), null);
        }

        double optimalScore = board.whiteToMove() ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        Move optimalMove = null;

        for (Move possibleMove : board.getAllPossibleMoves()) {
            board.executeMove(possibleMove);
            BoardStatus boardStatus = board.getStatus();

            double score;
            if (boardStatus == BoardStatus.MATE) {
                board.revertLastMove();
                return new Pair<>(board.whiteToMove() ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY, possibleMove);
            } else if (boardStatus == BoardStatus.STALEMATE) {
                score = 0;
            } else {
                score = findOptimalMove(board, depth - 1).getFirst();
            }
            board.revertLastMove();

            if (board.whiteToMove()) {
                if (score >= optimalScore) {
                    optimalScore = score;
                    optimalMove = possibleMove;
                }
            } else {
                if (score <= optimalScore) {
                    optimalScore = score;
                    optimalMove = possibleMove;
                }
            }
        }

        assert optimalMove != null;
        return new Pair<>(optimalScore, optimalMove);
    }

}
