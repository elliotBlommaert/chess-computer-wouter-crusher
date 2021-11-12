package test;

import board.BoardBuilder;
import board.Board;
import general.Position;
import moves.DefaultMove;
import moves.Move;
import org.junit.Test;
import tree.Tree;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOptimalMove {
    @Test
    public void testMateInOne() {
        Board board = new BoardBuilder()
                .addPieces("K,b,B1 - Q,b,G4 - KN,b,F5 - K,w,H8")
                .blackToMove()
                .build();
        Move optimalMove = Tree.findOptimalMove(board, 3).getSecond();
        assertThat(optimalMove.toString())
                .isEqualTo(
                        new DefaultMove(
                                board.getPieceAt(6, 3),
                                new Position(6, 3),
                                new Position(6, 6)).toString()
                );
    }

    @Test
    public void testCaptureInOne() {
        Board board = new BoardBuilder()
                .addPieces("K,w,A1 - R,w,E2 - Q,b,E6 - K,b,H8")
                .build();
        Move optimalMove = Tree.findOptimalMove(board, 3).getSecond();
        assertThat(optimalMove.toString())
                .isEqualTo(
                        new DefaultMove(
                                board.getPieceAt(4, 1),
                                new Position(4, 1),
                                new Position(4, 5)).toString()
                );
    }

    @Test
    public void testCaptureInOneWithChoice() {
        Board board = new BoardBuilder()
                .addPieces("K,w,A1 - R,w,E2 - Q,b,E6 - K,b,H8 - KN,b,G2")
                .build();
        Move optimalMove = Tree.findOptimalMove(board, 4).getSecond();
        assertThat(optimalMove.toString())
                .isEqualTo(
                        new DefaultMove(
                                board.getPieceAt(4, 1),
                                new Position(4, 1),
                                new Position(4, 5)).toString()
                );
    }

    @Test
    public void testPin() {
        Board board = new BoardBuilder()
                .addPieces("K,w,A2 - B,w,E3 - R,b,F6 - K,b,H8")
                .build();
        Move optimalMove = Tree.findOptimalMove(board, 4).getSecond();
        assertThat(optimalMove.toString())
                .isEqualTo(
                        new DefaultMove(
                                board.getPieceAt(4, 2),
                                new Position(4, 2),
                                new Position(3, 3)).toString()
                );
    }

    @Test
    public void testSkewer() {
        Board board = new BoardBuilder()
                .addPieces("K,w,A2 - B,w,E3 - R,b,H8 - K,b,F6")
                .build();
        Move optimalMove = Tree.findOptimalMove(board, 4).getSecond();
        assertThat(optimalMove.toString())
                .isEqualTo(
                        new DefaultMove(
                                board.getPieceAt(4, 2),
                                new Position(4, 2),
                                new Position(3, 3)).toString()
                );
    }

    @Test
    public void puzzle1() {
        Board board = new BoardBuilder()
                .addPieces("R,b,A8 - B,b,C8 - K,b,E8 - R,b,H8")
                .addPieces("P,b,A7 - P,b,B7 - P,b,F7 - P,b,G7 - P,b,H7 - KN,b,D7")
                .addPieces("P,b,C6 - P,b,E6 - B,b,D6 - P,b,D5 - Q,b,E5")
                .addPieces("KN,w,A4 - P,w,A3 - P,w,B3 - B,w,D3")
                .addPieces("P,w,C2 - B,w,D2 - KN,w,E2 - P,w,G2 - P,w,H2")
                .addPieces("R,w,A1 - Q,w,D1 - R,w,F1 - K,w,G1")
                .build();
        Move optimalMove = Tree.findOptimalMove(board, 4).getSecond();
        assertThat(optimalMove.toString())
                .isEqualTo(
                        new DefaultMove(
                                board.getPieceAt(3, 1),
                                new Position(3, 1),
                                new Position("F4")).toString()
                );
    }

    @Test
    public void puzzle2() {
        Board board = new BoardBuilder()
                .addPieces("K,b,D8 - R,b,G8 - P,b,A7 - KN,b,E7 - P,b,H7 - P,b,E5 - Q,b,G5")
                .addPieces("KN,w,D6 - B,w,E6 - Q,w,F6 - P,w,E4 - P,w,A3 - P,w,B2 - K,w,D2 - P,w,F2")
                .build();
        Move optimalMove = Tree.findOptimalMove(board, 5).getSecond();
        assertThat(optimalMove.toString())
                .isEqualTo(
                        new DefaultMove(
                                board.getPieceAt(5, 5),
                                new Position("F6"),
                                new Position("G5")).toString()
                );
    }
}
