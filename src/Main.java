import general.BoardState;
import general.Position;
import pieces.*;

public class Main {


    public static void main(String[] args) {

        BoardState boardState = new BoardState();

        boardState.addPiece(new Queen(false, 1), new Position(3, 4));
        boardState.addPiece(new King(true, 2), new Position(3, 0));
        Piece rook = new Rook(true, 3);
        boardState.addPiece(rook, new Position(3, 3));

        System.out.println(boardState);
        System.out.println(rook.getValidMoves(boardState, new Position(3, 3)));
    }


}
