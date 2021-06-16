import general.BoardState;
import general.Position;
import moves.AdvanceTwoMove;
import moves.DefaultMove;
import pieces.*;

public class Main {


    public static void main(String[] args) {

        BoardState boardState = new BoardState();

        Piece whitePawn = new Pawn(true, 0);
        boardState.addPiece(whitePawn, new Position(1, 3));
        Piece blackPawn = new Pawn(false, 1);
        boardState.addPiece(blackPawn, new Position(2, 6));
        Piece king = new King(true, 2);
        boardState.addPiece(king, new Position(3, 3));

        boardState.executeMove(new DefaultMove(whitePawn, new Position(1, 3), new Position(1, 4)));
        boardState.executeMove(new AdvanceTwoMove(blackPawn, new Position(2, 6), new Position(2, 4)));

        System.out.println(boardState);
        System.out.println(whitePawn.getValidMoves(boardState, new Position(1, 4)));
    }


}
