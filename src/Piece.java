import java.util.ArrayList;

public abstract class Piece {

    private int Color;
    private Square Location;
    private String getPieceType;

    private boolean didInitialize;
    public Piece(int color, Square location) {
        this.Color = color;
        this.Location = location;
        this.didInitialize = false;

    }

    public void setDidInitialize(boolean didInitialize) {
        this.didInitialize = didInitialize;
    }
    public boolean isDidInitialize(){
        return didInitialize;
    }

    public int getColor() {
        return Color;
    }

    public Square getLocation() {
        return Location;
    }

    public void setColor(int color) {
        Color = color;
    }

    public void setLocation(Square location) {
        Location = location;
    }

    public boolean callSpecialPiece(String pieceType, Square destination, Piece piece){
        if (pieceType == "Queen") {
            System.out.println("jdsgjklndf");
            return Queen.canMove(destination, piece);
        } else if(pieceType == "King"){
            return King.canMove(destination, piece);
        }else if(pieceType == "Knight"){
            return Knight.canMove(destination, piece);
        }else if(pieceType == "Bishop"){
            return Bishop.canMove(destination, piece);
        }else if(pieceType == "Rook"){
            return Rook.canMove(destination, piece);
        }else{
            return Pawn.canMove(destination, piece);
        }
    }

    public boolean canMove(String destination, Piece mainPiece) { // mainPiece is the piece which will move, piece is the piece if there is a piece in destination of mainPiece
        int row = 8 - Integer.parseInt(destination.substring(1)); // Satır hesaplama (1 tabanlı indeks)
        int col = destination.charAt(0) - 'a'; // Sütun hesaplama (a=0, b=1, c=2, ...)
        Piece piece = ChessBoard.squares[row][col].getPiece();
        /*Piece piece = ChessBoard.getPieceAt(destination);*/
        String pieceType = mainPiece.getPieceType();
        if (piece == null) {
            System.out.println("taş yok, gidilebilir");
            return callSpecialPiece(pieceType, ChessBoard.squares[row][col], mainPiece);
        } else if (piece.getColor() != (ChessBoard.isWhitePlaying() ? ChessBoard.WHITE : ChessBoard.BLACK)) {
            System.out.println("taş var ama rengi farklı, gidilebilir");
            return callSpecialPiece(pieceType, ChessBoard.squares[row][col], mainPiece);
        }else{
            System.out.println("giremezz, gidemez bu kareye");
            return false;
        }
    }

    public void move(String location, String destination, Piece piece){
        int rowL = 8 - Integer.parseInt(location.substring(1)); // Satır hesaplama (1 tabanlı indeks)
        int colL = location.charAt(0) - 'a'; // Sütun hesaplama (a=0, b=1, c=2, ...)

        int rowD = 8 - Integer.parseInt(destination.substring(1)); // Satır hesaplama (1 tabanlı indeks)
        int colD = destination.charAt(0) - 'a'; // Sütun hesaplama (a=0, b=1, c=2, ...)

        ChessBoard.squares[rowL][colL].setPiece(null);
        piece.setLocation(ChessBoard.squares[rowD][colD]);
        ChessBoard.squares[rowD][colD].setPiece(piece);
        piece.setDidInitialize(true);

    }
    public abstract String getPieceType();

    @Override
    public String toString() {
        return "   ";
    }

}
