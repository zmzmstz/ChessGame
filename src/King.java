public class King extends Piece {


    private int color;
    private Square location;

    private String symbol;

    boolean initialLocation = true;

    public King(int color, Square location) {
        super(color, location);
        this.color = color;
        this.location = location;
    }

    public String getSymbol() {
        if (color == 0) {
            this.symbol = " K ";
        } else {
            this.symbol = " k ";
        }
        return symbol;
    }

    /*public static boolean castling(Square destination, Piece piece){
        int rowD = destination.getRow();
        int colD = destination.getColumn();

        Square location = piece.getLocation();
        int rowL = location.getRow();
        int colL = location.getColumn();
        if (piece.isDidInitialize() == false){
            if (colD == 6 && ChessBoard.squares[rowL][5].getPiece() == null && ChessBoard.squares[rowL][7].getPiece().getPieceType() == "Rook"){
                Piece rook = ChessBoard.squares[rowL][7].getPiece();
                rook.setLocation(ChessBoard.squares[rowL][5]);

                return true;
            }

        }


    }*/

    public static boolean canMove(Square destination, Piece piece) {
        System.out.println("king movena hoş gelmişşiniz");
        int rowD = destination.getRow();
        int colD = destination.getColumn();
        Square location = piece.getLocation();
        int rowL = location.getRow();
        int colL = location.getColumn();
        boolean isOtherKing = false;
        // check other king
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((Math.abs(row - rowD) == 0 || Math.abs(row - rowD) == 1) && (Math.abs(col - colD) == 0 || Math.abs(col - colD) == 1)) {
                    Piece possibleOtherKing = ChessBoard.squares[row][col].getPiece();
                    if (possibleOtherKing != null && (possibleOtherKing.getPieceType() == "King" && possibleOtherKing.getColor() != piece.getColor())) {
                        isOtherKing = true;
                    }
                }
            }
        }

        /*for (int row = rowD - 1; row < rowD + 2; row++) {
            for (int col = colD - 1; col < colD + 2; col++) {
                Piece possibleOtherKing = ChessBoard.squares[row][col].getPiece();
                if (possibleOtherKing != null && (possibleOtherKing.getPieceType() == "King" && possibleOtherKing.getColor() != piece.getColor())) {
                    isOtherKing = true;
                }
            }
        }*/
        if (((Math.abs(rowL - rowD) == 0 || Math.abs(rowL - rowD) == 1) && (Math.abs(colL - colD) == 0 || Math.abs(colL - colD) == 1)) && isOtherKing == false) {
            return true;
        }/* else if (rowL == rowD && Math.abs(colL- colD) == 2) {
            King.castling(destination, piece);
        } */else {
            return false;
        }

    }

    @Override
    public String getPieceType() {
        return "King";
    }

    @Override
    public String toString() {
        return getSymbol();
    }

}

