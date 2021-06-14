package general;

import pieces.Piece;

public class DefaultMove extends Move {

    private Piece pieceToMove;
    private Position newPosition;

    private Position oldPosition;
    private Piece capturedPiece;

    public DefaultMove(Piece pieceToMove, Position newPosition) {
        this.pieceToMove = pieceToMove;
        this.newPosition = newPosition;
    }

    @Override
    public void execute(BoardState boardState) {
        assert !isExecuted;
        isExecuted = true;


        assert boardState.isValid();

        oldPosition = pieceToMove.getPosition();
        Piece pieceAtOldPositionOnBoard = boardState.getPieceAt(oldPosition);
        assert pieceAtOldPositionOnBoard.equals(pieceToMove);

        capturedPiece = boardState.getPieceAt(newPosition);

        boolean moveToEmptySquare = capturedPiece == null;
        boolean isCapture = capturedPiece != null && capturedPiece.isColorWhite() != pieceToMove.isColorWhite();
        assert moveToEmptySquare || isCapture;

        if (isCapture) {
            boardState.removePiece(capturedPiece);
        }
        boardState.displacePiece(pieceToMove, newPosition);
        boardState.addMove(this);
    }

    @Override
    public void revert(BoardState boardState) {
        assert isExecuted;

        assert pieceToMove.getPosition().equals(newPosition);
        assert boardState.getPieceAt(oldPosition) == null;

        boardState.displacePiece(pieceToMove,oldPosition);

        if (capturedPiece != null) {
            boardState.addPiece(capturedPiece);
        }

    }

    @Override
    public String toString() {
        Position startPosition = pieceToMove.getPosition();
        return pieceToMove.getDrawingCharacter() + " " + startPosition.toString() + "->" + newPosition.toString();
    }
}
