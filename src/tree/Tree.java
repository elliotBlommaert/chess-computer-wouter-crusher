package tree;

import board.BoardState;
import general.Scorer;
import moves.Move;

public class Tree {

    static public Move findOptimalMove(BoardState boardState, int depth) {
        assert depth > 0;

        double optimalScore = boardState.whiteToMove() ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        Move optimalMove = null;

        for (Move possibleMove : boardState.getAllPossibleMoves()) {
            boardState.executeMove(possibleMove);
            double score = findOptimalScore(boardState, depth - 1);
            boardState.revertLastMove();

            if (boardState.whiteToMove()) {
                if (score > optimalScore) {
                    optimalScore = score;
                    optimalMove = possibleMove;
                }
            } else {
                if (score < optimalScore) {
                    optimalScore = score;
                    optimalMove = possibleMove;
                }
            }
        }
        return optimalMove;
    }

    static double findOptimalScore(BoardState boardState, int depth) {

        if (depth == 0) {
            return Scorer.scoreBoard(boardState);
        }

        double optimalScore = boardState.whiteToMove() ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;

        for (Move possibleMove : boardState.getAllPossibleMoves()) {
            boardState.executeMove(possibleMove);
            double score = findOptimalScore(boardState, depth - 1);
            boardState.revertLastMove();

            if (boardState.whiteToMove()) {
                if (score > optimalScore) {
                    optimalScore = score;
                }
            } else {
                if (score < optimalScore) {
                    optimalScore = score;
                }
            }
        }
        return optimalScore;
    }

    static Move findOptimalMoveDepth2(BoardState boardState) {
        assert boardState.whiteToMove();

        double optimalWhiteScore = Double.NEGATIVE_INFINITY;
        Move currentOptimalMove = null;

        for (Move possibleWhiteMove : boardState.getAllPossibleMoves()) {
            boardState.executeMove(possibleWhiteMove);

            double optimalBlackScore = Double.POSITIVE_INFINITY;
            for (Move possibleBlackMove : boardState.getAllPossibleMoves()) {
                boardState.executeMove(possibleBlackMove);
                double currentScore = Scorer.scoreBoard(boardState);
                if (currentScore < optimalBlackScore) {
                    optimalBlackScore = currentScore;
                }
                boardState.revertLastMove();
            }

            if (optimalBlackScore > optimalWhiteScore) {
                optimalWhiteScore = optimalBlackScore;
                currentOptimalMove = possibleWhiteMove;
            }
            boardState.revertLastMove();
        }

        return currentOptimalMove;
    }
}
