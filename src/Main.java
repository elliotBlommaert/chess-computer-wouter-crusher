import general.*;
import moves.AdvanceTwoMove;
import moves.DefaultMove;
import moves.Move;
import pieces.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {


    public static void main(String[] args) {

        BoardState boardState = new BoardState();

        boardState.addPiece(new King(false, 1), new Position(3,4));
        boardState.addPiece(new Pawn(true, 2), new Position(2,3));

        boardState.isChecked(false);
        int i = 0;

    }


}
