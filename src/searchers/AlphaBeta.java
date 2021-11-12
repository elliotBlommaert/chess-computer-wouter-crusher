package searchers;

import board.Board;
import board.BoardStatus;
import general.Pair;
import general.Scorer;
import moves.Move;

public class AlphaBeta {

    static public Pair<Double, Move> findOptimalMove(Board board, int depth) {
        return findOptimalMove(board, depth, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    static public Pair<Double, Move> findOptimalMove(Board board, int depth, double alpha, double beta) {

        if (depth == 0) {
            return new Pair<>(Scorer.scoreBoard(board), null);
        }

        Move optimalMove = null;
        double optimalScore;
        if (board.whiteToMove()) {
            optimalScore = Double.NEGATIVE_INFINITY;

            for (Move possibleMove : board.getAllPossibleMoves()) {
                board.executeMove(possibleMove);
                BoardStatus boardStatus = board.getStatus();

                double score;
                if (boardStatus == BoardStatus.MATE) {
                    board.revertLastMove();
                    return new Pair<>(Double.POSITIVE_INFINITY, possibleMove);
                } else if (boardStatus == BoardStatus.STALEMATE) {
                    score = 0;
                } else {
                    score = findOptimalMove(board, depth - 1, alpha, beta).getFirst();
                }
                board.revertLastMove();

                if (score > alpha) {
                    alpha = score;
                }

                if (alpha > beta) {
                    break;
                }

                if (score >= optimalScore) {
                    optimalScore = score;
                    optimalMove = possibleMove;
                }
            }
        } else {
            optimalScore = Double.POSITIVE_INFINITY;

            for (Move possibleMove : board.getAllPossibleMoves()) {
                board.executeMove(possibleMove);
                BoardStatus boardStatus = board.getStatus();

                double score;
                if (boardStatus == BoardStatus.MATE) {
                    board.revertLastMove();
                    return new Pair<>(Double.NEGATIVE_INFINITY, possibleMove);
                } else if (boardStatus == BoardStatus.STALEMATE) {
                    score = 0;
                } else {
                    score = findOptimalMove(board, depth - 1, alpha, beta).getFirst();
                }
                board.revertLastMove();

                if (score < beta) {
                    beta = score;
                }

                if (alpha > beta) {
                    break;
                }

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
