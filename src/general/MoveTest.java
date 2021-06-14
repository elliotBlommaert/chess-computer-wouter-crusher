package general;

import org.junit.Test;
import pieces.Rook;

import static org.assertj.core.api.Assertions.*;


public class MoveTest {


    @Test
    public void testMoveToEmptySquare() {
        BoardState boardState = new BoardState();
        Position oldPosition = new Position(0, 0);
        Rook rock = new Rook(true, oldPosition);
        boardState.addPiece(rock);

        Position newPosition = new Position(0, 1);
        Move move = new DefaultMove(rock, newPosition);

        assertThatCode(() -> move.execute(boardState)).doesNotThrowAnyException();
        assertThat(rock.getPosition()).isEqualTo(newPosition);
        assertThat(boardState.isValid()).isTrue();

        assertThatCode(boardState::revertLastMove).doesNotThrowAnyException();
        assertThat(rock.getPosition()).isEqualTo(oldPosition);
        assertThat(boardState.isValid()).isTrue();
    }

    @Test
    public void testCapture() {
        BoardState boardState = new BoardState();
        Position oldPositionWhiteRock = new Position(0, 0);
        Rook whiteRock = new Rook(true, oldPositionWhiteRock);
        Position oldPositionBlackRock = new Position(0, 1);
        Rook blackRock = new Rook(false, oldPositionBlackRock);
        boardState.addPiece(whiteRock);
        boardState.addPiece(blackRock);

        Move move = new DefaultMove(whiteRock, oldPositionBlackRock);

        assertThatCode(() -> move.execute(boardState)).doesNotThrowAnyException();
        assertThat(whiteRock.getPosition()).isEqualTo(oldPositionBlackRock);
        assertThat(boardState.isValid()).isTrue();

        assertThatCode(boardState::revertLastMove).doesNotThrowAnyException();
        assertThat(whiteRock.getPosition()).isEqualTo(oldPositionWhiteRock);
        assertThat(blackRock.getPosition()).isEqualTo(oldPositionBlackRock);
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