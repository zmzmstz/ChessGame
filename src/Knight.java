import java.util.ArrayList;
public class Knight extends Piece {


    private int color;
    private Square location;

    private String symbol;

    boolean initialLocation = true;
    public Knight(int color, Square location) {
        super(color, location);
        this.color = color;
        this.location = location;
    }
    public String getSymbol() {
        if (color == 0) {
            this.symbol = " N ";
        } else {
            this.symbol = " n ";
        }
        return symbol;
    }

    public static boolean canMove(Square destination, Piece piece){
        System.out.println("knight movena hoş gelmişşiniz");
        // ArrayList<Square> possibleLocations = new ArrayList<>();
        int rowD = destination.getRow();
        int colD = destination.getColumn();
        Square location = piece.getLocation();
        int rowL = location.getRow();
        int colL = location.getColumn();
        if (Math.abs(rowL - rowD) == 2 && Math.abs(colL - colD) == 1 || Math.abs(rowL - rowD) == 1 && Math.abs(colL - colD) == 2) {
            return true;
        }else {
            return false;
        }

    }

    @Override
    public String getPieceType() {
        return "Knight";
    }

    @Override
    public String toString() {
        return getSymbol();
    }

}

