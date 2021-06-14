import general.BoardState;
import general.DefaultMove;
import general.Position;
import pieces.Pawn;
import pieces.Piece;

public class main {


    public static void main(String[] args) {
        BoardState board = BoardState.getDefaultStartBoard();
        System.out.println(board);

        Piece pawn = board.getPieceAt(new Position(0, 1));
        DefaultMove move = new DefaultMove(pawn, new Position(0, 7));
        move.execute(board);
        System.out.println(board);
        board.revertLastMove();
        System.out.println(board);

    }


}
