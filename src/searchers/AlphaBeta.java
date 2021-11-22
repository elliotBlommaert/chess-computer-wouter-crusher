package searchers;

import board.Board;
import board.BoardStatus;
import general.Pair;
import general.Position;
import general.Scorer;
import moves.Move;
import pieces.Piece;

import java.util.Comparator;
import java.util.List;

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

            List<Move> allPossibleMoves = board.getAllPossibleMoves();

            for (Move possibleMove : allPossibleMoves) {
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

                if (score >= optimalScore) {
                    optimalScore = score;
                    optimalMove = possibleMove;
                }

                if (alpha > beta) {
                    break;
                }
            }
        } else {
            optimalScore = Double.POSITIVE_INFINITY;

            List<Move> allPossibleMoves = board.getAllPossibleMoves();

            for (Move possibleMove : allPossibleMoves) {
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

                if (score <= optimalScore) {
                    optimalScore = score;
                    optimalMove = possibleMove;
                }

                if (alpha > beta) {
                    break;
                }
            }
        }

        assert optimalMove != null;
        return new Pair<>(optimalScore, optimalMove);
    }

}
