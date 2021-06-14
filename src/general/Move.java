package general;

import pieces.Piece;

abstract public class Move {

    protected boolean isExecuted;

    abstract public void execute(BoardState boardState);

    abstract public void revert(BoardState boardState);

}
