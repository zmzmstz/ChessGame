public class Pawn extends Piece {


    private int color;
    private Square location;

    private String symbol;

    /*boolean initialLocation = true;*/

    public Pawn(int color, Square location) {
        super(color, location);
        this.color = color;
        this.location = location;

        /*for(int column = 0; column < 8; column++){
            Pawn pawnBlack = new Pawn(0,ChessBoard.squares[1][column]);
            ChessBoard.pieces.add(pawnBlack);
            Pawn pawnWhite = new Pawn(1,ChessBoard.squares[6][column]);
            ChessBoard.pieces.add(pawnWhite);
        }*/
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public Square getLocation() {
        return location;
    }

    public String getSymbol() {
        if (color == 0) {
            this.symbol = " P ";
        } else {
            this.symbol = " p ";
        }
        return symbol;
    }


    public static boolean canMove(Square destination, Piece piece){
        System.out.println("pawn movena hoş gelmişşiniz");

        // isAtLastRow square den çağır pawn square de mi onu kontrol eder
        int rowD = destination.getRow();
        int colD = destination.getColumn();

        Square location = piece.getLocation();
        int rowL = location.getRow();
        int colL = location.getColumn();

        System.out.println("m" + (colL) + "m" + (colD) + "m" + rowL + "m" + rowD);

        if (piece.getColor() == 0){
            System.out.println("1");
            if (colD == colL && rowL - rowD == 1 && ChessBoard.squares[rowD][colD].getPiece() == null){
                System.out.println("2");
                if(Square.isAtLastRow(piece, rowD)){
                    System.out.println("3");
                    piece = new Queen(0, ChessBoard.squares[rowD][colD]);
                }
                return true;
            } else if (Math.abs(colD - colL) == 1 && rowL - rowD == 1 && ChessBoard.squares[rowD][colD].getPiece() != null) {
                System.out.println("4");
                return true;
            } else if (colD == colL && rowL - rowD == 2 && ChessBoard.squares[rowD][colD].getPiece() == null && piece.isDidInitialize() == false) {
                return true;
            } else{
                System.out.println("5");
                return false;
            }
        }else {
            System.out.println("6");
            if (colD == colL && rowD - rowL == 1 && ChessBoard.squares[rowD][colD].getPiece() == null){
                System.out.println("girdi mi buraya");
                if(Square.isAtLastRow(piece, rowD)){
                    System.out.println("7");
                    piece = new Queen(1, ChessBoard.squares[rowD][colD]);
                }
                return true;
            } else if (Math.abs(colD - colL) == 1 && rowD - rowL == 1 && ChessBoard.squares[rowD][colD].getPiece() != null) {
                System.out.println("8");
                return true;
            } else if (colD == colL && rowD - rowL == 2 && ChessBoard.squares[rowD][colD].getPiece() == null && piece.isDidInitialize() == false) {
                return true;
            }  else{
                System.out.println("9");
                return false;
            }
        }
    }
    @Override
    public String getPieceType() {
        return "Pawn";
    }

    @Override
    public String toString() {
        return getSymbol();
    }

}
