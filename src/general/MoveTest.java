package general;

import org.junit.Test;
import pieces.Rook;

import static org.assertj.core.api.Assertions.*;


public class MoveTest {


    @Test
    public void testMoveToEmptySquare() {
        BoardState boardState = new BoardState();
        Rook rock = new Rook(true, new Position(0, 0));
        boardState.addPiece(rock);

        Position newPosition = new Position(0, 1);
        Move move = new DefaultMove(rock, newPosition);

        assertThatCode(() -> move.execute(boardState)).doesNotThrowAnyException();
        assertThat(rock.getPosition()).isEqualTo(newPosition);
        assertThat(boardState.isValid()).isTrue();
    }

    @Test
    public void testCapture() {
        BoardState boardState = new BoardState();
        Rook whiteRock = new Rook(true, new Position(0, 0));
        Rook blackRock = new Rook(false, new Position(0, 1));
        boardState.addPiece(whiteRock);
        boardState.addPiece(blackRock);

        Position newPosition = new Position(0, 1);
        Move move = new DefaultMove(whiteRock, newPosition);

        assertThatCode(() -> move.execute(boardState)).doesNotThrowAnyException();
        assertThat(whiteRock.getPosition()).isEqualTo(newPosition);
        assertThat(boardState.isValid()).isTrue();
    }

    @Test
    public void testIllegalMove() {
        BoardState boardState = new BoardState();
        Rook whiteRock = new Rook(true, new Position(0, 0));
        Rook blackRock = new Rook(true, new Position(0, 1));
        boardState.addPiece(whiteRock);
        boardState.addPiece(blackRock);

        Position newPosition = new Position(0, 1);
        Move move = new DefaultMove(whiteRock, newPosition);

        assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> move.execute(boardState));
    }

}