package general;

public class Move {

    private Position oldPosition;
    private Position newPosition;

    public Move(Position oldPosition, Position newPosition) {
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
    }
}
