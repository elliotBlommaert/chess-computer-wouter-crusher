package pieces;

import general.BoardState;
import general.DefaultMove;
import general.Move;
import general.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(boolean colorWhite, int id) {
        super(colorWhite, id);
    }


    @Override
    public String getDrawingCharacter() {
        String whitePawn = "\u2659";
        String blackPawn = "\u265F";


        return isColorWhite() ? whitePawn : blackPawn;
    }

    @Override
    public List<Move> getPossibleMoves(BoardState board, Position position) {
        assert board.getPieceAt(position).equals(this);

        List<Move> possibleMoves = new ArrayList<>();

        int direction = colorWhite ? 1 : -1;
        int startRow = position.getRow();
        int startColumn = position.getColumn();

        // Move forward
        if (board.getPieceAt(startColumn, startRow + direction) == null) {
            Position newPosition = new Position(startColumn, startRow + direction);
            int finalRow = colorWhite ? 6 : 1;
            if (startRow == finalRow) {
                // todo: make promotion moves
            } else {
                possibleMoves.add(new DefaultMove(this, position, newPosition));

                // Two forward
                int initialRow = colorWhite ? 1 : 6;
                if (startRow == initialRow && board.getPieceAt(startColumn, startRow + 2 * direction) == null) {
                    Position newPosition2 = new Position(startColumn, startRow + 2 * direction);
                    possibleMoves.add(new DefaultMove(this, position, newPosition2));
                }
            }
        }
        // Capture right
        if (board.getPieceAt(startColumn + 1, startRow + direction) != null) {
            Position newPosition = new Position(startColumn + 1, startRow + direction);
            possibleMoves.add(new DefaultMove(this, position, newPosition));
        }
        // Capture left
        if (board.getPieceAt(startColumn - 1, startRow + direction) != null) {
            Position newPosition = new Position(startColumn - 1, startRow + direction);
            possibleMoves.add(new DefaultMove(this, position, newPosition));
        }
        // TODO: En passant & promotion

        return possibleMoves;
    }
}
