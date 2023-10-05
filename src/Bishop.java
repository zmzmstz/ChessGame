public class Bishop extends Piece {


    private int color;
    private Square location;

    private String symbol;

    boolean initialLocation = true;

    public Bishop(int color, Square location) {
        super(color, location);
        this.color = color;
        this.location = location;
    }

    public String getSymbol() {
        if (color == 0) {
            this.symbol = " B ";
        } else {
            this.symbol = " b ";
        }
        return symbol;
    }

    public static boolean canMove(Square destination, Piece piece) {
        System.out.println("bishop movena hoş gelmişşiniz");

        boolean isOtherPiece = false;

        int rowD = destination.getRow();
        int colD = destination.getColumn();

        Square location = piece.getLocation();
        int rowL = location.getRow();
        int colL = location.getColumn();

        int minRow = Math.min(rowD, rowL);
        int minCol = Math.min(colD, colL);

        int maxRow = Math.max(rowD, rowL);
        int maxCol = Math.max(colD, colL);


        if (Math.abs(rowD - rowL) == Math.abs(colD - colL)) {
            System.out.println("m" + (maxCol) + "m" + (maxRow) + "m" + minCol + "m" + minRow);
            int row, col;
            for (row = minRow + 1, col = minCol + 1; row < maxRow; row++, col++) {
                System.out.println("row" + row + "col" + col);
                System.out.println("girdi2");
                if (ChessBoard.squares[row][col].getPiece() != null) {
                    System.out.println("hjdfl");
                    isOtherPiece = true;
                }
            }
        }
        if (Math.abs(rowD - rowL) == Math.abs(colD - colL) && isOtherPiece == false) {
            System.out.println("ee niye gitmiyo");
            return true;
        } else {
            System.out.println("hareket edemez");
            return false;
        }
    }

    @Override
    public String getPieceType() {
        return "Bishop";
    }

    @Override
    public String toString() {
        return getSymbol();
    }

}
