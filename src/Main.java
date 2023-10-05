import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ChessBoard board = new ChessBoard();
        board.initialize();
        System.out.println(board);
        while (!board.isGameEnded()) {
            System.out.println("It is " + (board.isWhitePlaying() ? "White" : "Black") + "'s turn");
            System.out.print("Enter the location of the piece:");
            String from = reader.next();
            Piece piece = board.getPieceAt(from); // BURADA GİRİLEN DEĞERİ KONTROL ET
            while (piece == null || piece.getColor() != (board.isWhitePlaying() ? ChessBoard.WHITE : ChessBoard.BLACK)) {
                System.out.println("Please enter a valid location :)");
                from = reader.next();
                piece = board.getPieceAt(from);
            }

            System.out.println(piece);
            String to = null;
            do {
                System.out.print("Enter the new location of the piece:");
                to = reader.next();
            } while (!piece.canMove(to, piece));
            if (piece.canMove(to, piece)) {
                piece.move(from, to, piece);

                board.changePlayer();
            }
            System.out.println(board);


        }
        System.out.println("Game ended. " + (board.isWhitePlaying() ? "Black" : "White") + " is winnerr!");
        /*while (!board.isGameEnded()) {
            System.out.println("It is " + (board.isWhitePlaying() ? "White" : "Black") + "'s turn");
            Piece piece = null;
            do {
                System.out.print("Enter the location of the piece:");
                String from = reader.next();
                piece = board.getPieceAt(from);
            } while (piece == null || piece.getColor() != (board.isWhitePlaying() ? ChessBoard.WHITE :
                    ChessBoard.BLACK));
            String to = null;
            do {
                System.out.print("Enter the new location of the piece:");
                to = reader.next();
            } while (!piece.canMove(to));
            piece.move(to);
            System.out.println(board);
        }
        reader.close();*/
    }


}