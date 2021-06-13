import general.BoardState;

public class main {


    public static void main(String[] args) {
        String whiteRook = "\u2656";
        String blackRook = "\u265C";

        System.out.println(whiteRook);
//        System.out.println(blackRook);

        BoardState startPosition = BoardState.getDefaultStartBoard();
        System.out.println(startPosition);

    }


}
