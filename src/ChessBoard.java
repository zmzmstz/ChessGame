/*import java.util.ArrayList;
import java.util.List;*/

public class ChessBoard {
    boolean isGameEnded = false;

    public static Square[][] squares;
    private static boolean whiteTurn;
    public static final int WHITE = 0;
    public static final int BLACK = 1;

    /*public static ArrayList<Piece> pieces = new ArrayList<>();*/

    public ChessBoard() {
        squares = new Square[8][8];
        whiteTurn = true;

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                Square square = new Square(row, column);
                squares[row][column] = square;
            }
        }
        /*Queen queen = new Queen(0,ChessBoard.squares[1][1]);
        ChessBoard.pieces.add(queen);
        System.out.println(pieces.size());*/
    }

    public void initialize() {

        // pawns of (white and black)
        for (int column = 0; column < 8; column++) {
            squares[1][column].setPiece(new Pawn(1, ChessBoard.squares[1][column]));
            squares[6][column].setPiece(new Pawn(0, ChessBoard.squares[6][column]));
        }

        // black's other pieces
        squares[0][0].setPiece(new Rook(1, squares[0][0]));
        squares[0][1].setPiece(new Knight(1, squares[0][1]));
        squares[0][2].setPiece(new Bishop(1, squares[0][2]));
        squares[0][3].setPiece(new Queen(1, squares[0][3]));
        squares[0][4].setPiece(new King(1, squares[0][4]));
        squares[0][5].setPiece(new Bishop(1, squares[0][5]));
        squares[0][6].setPiece(new Knight(1, squares[0][6]));
        squares[0][7].setPiece(new Rook(1, squares[0][7]));

        // white's other pieces
        squares[7][0].setPiece(new Rook(0, squares[7][0]));
        squares[7][1].setPiece(new Knight(0, squares[7][1]));
        squares[7][2].setPiece(new Bishop(0, squares[7][2]));
        squares[7][3].setPiece(new Queen(0, squares[7][3]));
        squares[7][4].setPiece(new King(0, squares[7][4]));
        squares[7][5].setPiece(new Bishop(0, squares[7][5]));
        squares[7][6].setPiece(new Knight(0, squares[7][6]));
        squares[7][7].setPiece(new Rook(0, squares[7][7]));

        /*for (Piece piece : pieces) {
            for(int column = 0; column < 8; column++){
                squares[1][column].setPiece(piece);
                squares[6][column].setPiece(piece);
            }
        }*/
    }

    /*public static void removePiece(int row, int col) {
        squares[row][col].setPiece(null);
    }*/

    public void changePlayer() {
        whiteTurn = !whiteTurn;
    }

    public static boolean isWhitePlaying() {
        return whiteTurn; // Hamle sırası beyaz oyuncuda mı?
    }

    public boolean isGameEnded() {
        boolean isWhitePiece = false;
        boolean isBlackPiece = false;
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                Piece piece = squares[row][column].getPiece();
                if (piece != null) {

                    if (piece.getColor() == 0) {
                        isWhitePiece = true;
                    } /*else{
                        isWhitePiece = false;
                    }*/

                    if (piece.getColor() == 1) {
                        isBlackPiece = true;
                    }/*else {
                        isBlackPiece = false;
                    }*/

                }
            }
        }

        if (isWhitePiece == isBlackPiece) {
            return false;
        } else {
            return true;
        }
    }
    /*public Square[][] getSquares() {
        return squares; // Kareleri temsil eden 2D dizinin dışarıdan erişimini sağlayan getter metodu
    }

    public Square getSquare(int row, int col) {
        return squares[row][col]; // Belirtilen satır ve sütundaki kareyi döndüren getSquare metodu
    }*/

    public static Piece getPieceAt(String location) {
        int row = 8 - Integer.parseInt(location.substring(1)); // Satır hesaplama (1 tabanlı indeks)
        int col = location.charAt(0) - 'a'; // Sütun hesaplama (a=0, b=1, c=2, ...)

        return squares[row][col].getPiece();
    }


    public String toString() {
        System.out.println("     A   B   C   D   E   F   G   H    ");
        System.out.println("   ---------------------------------");
        for (int i = 0; i < squares.length; i++) {
            System.out.print(" " + (8 - i) + " |");
            for (int j = 0; j < squares[i].length; j++) {
                /*if (squares[i][j] != null) {*/
                if (squares[i][j].isEmpty()) {
                    System.out.print("   ");
                } else {
                    System.out.print(squares[i][j].getPiece());
                }
                /*} else {
                    System.out.print("   ");
                }*/
                /*if (squares[i][j] != null) {
                    System.out.print(squares[i][j].getPiece());
                } else {
                    System.out.print(" ");
                }*/
                System.out.print("|");
            }
            System.out.print(" " + (8 - i));
            System.out.println("\n   ---------------------------------");
        }
        System.out.println("     A   B   C   D   E   F   G   H    ");
        return " ";
    }
}
