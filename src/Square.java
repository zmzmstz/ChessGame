public class Square {

    private int row;
    private int column;

    private Piece piece;

    public Square(int row, int column) {
        this.row = row;
        this.column = column;

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public static boolean isAtLastRow(Piece piece, int row){
        if (piece.getColor() == 0 && row == 0 || piece.getColor() == 1 && row == 7){
            return true;
        } else {
            return false;
        }
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    /*@Override
    public String toString() {
        if (isEmpty()) {
            return " ";
        } else {
            return piece.toString();
        }
    }*/

    /*@Override
    public String toString() {
        return piece.toString();
    }*/
}


/*if (x == 1) {  // burayı pieceye al
            this.Piece = "p";
        } else if (x == 6) {
            this.Piece = "P";
        } else if (x == 0 && y == 0 || x == 0 && y == 7) {
            this.Piece = "r";
        } else if (x == 7 && y == 0 || x == 7 && y == 7) {
            this.Piece = "R";
        } else if (x == 0 && y == 1 || x == 0 && y == 6) {
            this.Piece = "n";
        } else if (x == 7 && y == 1 || x == 7 && y == 6) {
            this.Piece = "N";
        } else if (x == 0 && y == 2 || x == 0 && y == 5) {
            this.Piece = "b";
        } else if (x == 7 && y == 2 || x == 7 && y == 5) {
            this.Piece = "B";
        } else if (x == 0 && y == 3) {
            this.Piece = "q";
        } else if (x == 7 && y == 3) {
            this.Piece = "Q";
        } else if (x == 0 && y == 4) {
            this.Piece = "k";
        } else if (x == 7 && y == 4) {
            this.Piece = "K";
        } else {
            this.Piece = piece;
        }*/