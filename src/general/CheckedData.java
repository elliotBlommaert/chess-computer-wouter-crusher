package general;

import java.util.List;

public class CheckedData {

    private List<Position> checkResolvingPositions;

    public CheckedData(List<Position> checkResolvingPositions) {
        this.checkResolvingPositions = checkResolvingPositions;
    }

    public boolean isDoubleCheck() {
        return checkResolvingPositions == null || checkResolvingPositions.isEmpty();
    }
}
