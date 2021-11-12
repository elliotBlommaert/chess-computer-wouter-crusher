package test;

import board.BoardBuilder;
import board.BoardState;
import general.Position;
import moves.DefaultMove;
import moves.Move;
import org.junit.Test;
import tree.Tree;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOptimalMove {
    @Test
    public void testMateInOne() {
        BoardState board = new BoardBuilder()
                .addPieces("K,b,B1 - Q,b,G4 - KN,b,F5 - K,w,H8")
                .blackToMove()
                .build();
        Move optimalMove = Tree.findOptimalMove(board, 3);
        assertThat(optimalMove.toString())
                .isEqualTo(
                        new DefaultMove(
                                board.getPieceAt(6, 3),
                                new Position(6, 3),
                                new Position(6, 6)).toString()
                );
    }
}
