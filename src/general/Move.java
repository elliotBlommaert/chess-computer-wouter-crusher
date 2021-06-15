package general;

import com.sun.tools.javac.util.Pair;
import pieces.Piece;

import java.util.List;

abstract public class Move {

    abstract public List<Pair<Piece, Pair<Position,Position>>> getPiecesToMove();
}
