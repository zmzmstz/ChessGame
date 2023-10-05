public class Queen extends Piece{
    private int color;
    private Square location;

    private String symbol;

    boolean initialLocation = true;
    public Queen(int color, Square location) {
        super(color, location);
        this.color = color;
        this.location = location;

        /*Queen queen = new Queen(0,ChessBoard.squares[1][1]);
        ChessBoard.pieces.add(queen);*/
    }

    @Override
    public String getPieceType() {
        return "Queen";
    }
    public static boolean canMove(Square destination,Piece piece){

        System.out.println("quennin movena hoş gelmişşiniz");

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
        } else if (Math.abs(rowD - rowL) == 0) {
            System.out.println("m" + (maxCol) + "m" + (maxRow) + "m" + minCol + "m" + minRow);
            int col;
            for (col = minCol + 1; col < maxCol; col++) {
                System.out.println("col" + col);
                System.out.println("girdi2");
                if (ChessBoard.squares[rowD][col].getPiece() != null) {
                    System.out.println("hjdfl");
                    isOtherPiece = true;
                }
            }
        } else if (Math.abs(colD - colL) == 0) {
            int row;
            for (row = minRow + 1; row < maxRow; row++) {
                System.out.println("row" + row);
                System.out.println("girdi2");
                if (ChessBoard.squares[row][colD].getPiece() != null) {
                    System.out.println("hjdfl");
                    isOtherPiece = true;
                }
            }
        }

        if ((Math.abs(rowD - rowL) == Math.abs(colD - colL) || (Math.abs(rowD - rowL) == 0 || Math.abs(colD - colL) == 0)) && isOtherPiece == false){
            System.out.println("ee niye gitmiyo");
            return true;
        } else {
            System.out.println("hareket edemez");
            return false;
        }

    }
    public String getSymbol() {
            if (color == 0) {
                this.symbol = " Q ";
            } else {
                this.symbol = " q ";
            }
            return symbol;
        }


    @Override
    public String toString() {
        return getSymbol();
    }

}
