package searchers;

import board.Board;
import general.Scorer;
import moves.Move;


public class SimpleMoveScorer {
    private final Board board;

    public SimpleMoveScorer(Board board) {
        this.board = board;
    }

    public double score(Move move) {
        double scoreBefore = Scorer.scoreBoard(board);
        board.executeMove(move);
        double scoreAfter = Scorer.scoreBoard(board);
        board.revertLastMove();
        return board.whiteToMove() ? scoreAfter - scoreBefore : scoreBefore - scoreAfter;
    }
}
