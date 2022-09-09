import java.util.Scanner;
public class Game {
    static boolean hasWinner = false;
    static boolean playerX = true;

    public static void main(String[] args) {
        Board board = new Board();

        Scanner scanner = new Scanner(System.in);

        System.out.println("TicTacToe");
        System.out.println("X goes first");

        while (true) {

            if (Game.playerX)
                System.out.println("X's turn");
            else
                System.out.println("O's turn");

            System.out.print("Enter row: ");
            int row = scanner.nextInt();
            System.out.print("Enter column: ");
            int column = scanner.nextInt();

            if (row < 0 || row > 2 || column < 0 || column > 2) {
                System.out.println("Out of range! Try again!");
            } else {
                board.insert(row, column);
                if (Game.hasWinner & Game.playerX) {
                    System.out.println("X wins!");
                    return;
                } else if (Game.hasWinner & (!Game.playerX)) {
                    System.out.println("O wins!");
                    return;
                } else if (board.isFullFill()) {
                    System.out.println("Tie!");
                    return;
                } else {
                    Game.playerX = !Game.playerX;
                }

            }

        }

    }
}
