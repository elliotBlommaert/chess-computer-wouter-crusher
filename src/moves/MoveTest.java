package moves;

import general.BoardState;
import general.Position;
import org.junit.Test;
import pieces.Rook;

import static org.assertj.core.api.Assertions.*;


public class MoveTest {


    @Test
    public void testMoveToEmptySquare() {
        BoardState boardState = new BoardState();
        Position oldPosition = new Position(0, 0);
        Rook rock = new Rook(true, 0);
        boardState.addPiece(rock, oldPosition);

        Position newPosition = new Position(0, 1);
        Move move = new DefaultMove(rock, oldPosition, newPosition);

        assertThatCode(() -> boardState.executeMove(move)).doesNotThrowAnyException();
        assertThat(boardState.getPieceAt(oldPosition)).isNull();
        assertThat(boardState.getPieceAt(newPosition)).isEqualTo(rock);
        assertThat(boardState.isValid()).isTrue();
    }

    @Test
    public void testCapture() {
        BoardState boardState = new BoardState();
        Position positionWhiteRock = new Position(0, 0);
        Rook whiteRock = new Rook(true, 0);
        Position positionBlackRock = new Position(0, 1);
        Rook blackRock = new Rook(false, 1);
        boardState.addPiece(whiteRock, positionWhiteRock);
        boardState.addPiece(blackRock, positionBlackRock);

        Move move = new DefaultMove(whiteRock, positionWhiteRock, positionBlackRock);

        assertThatCode(() -> boardState.executeMove(move)).doesNotThrowAnyException();
        assertThat(boardState.getPieceAt(positionWhiteRock)).isNull();
        assertThat(boardState.getPieceAt(positionBlackRock)).isEqualTo(whiteRock);
        assertThat(boardState.isValid()).isTrue();
    }

    @Test
    public void testIllegalMove() {
        BoardState boardState = new BoardState();
        Position oldPositionWhiteRock = new Position(0, 0);
        Rook whiteRock = new Rook(true, 0);
        Position oldPositionBlackRock = new Position(0, 1);
        Rook blackRock = new Rook(true, 1);
        boardState.addPiece(whiteRock, oldPositionWhiteRock);
        boardState.addPiece(blackRock, oldPositionBlackRock);

        Move move = new DefaultMove(whiteRock, oldPositionWhiteRock, oldPositionBlackRock);

        assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> boardState.executeMove(move));
    }

}