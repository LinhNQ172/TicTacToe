public class Board {
    private final Cell[][] board = new Cell[3][3];

    public Board() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = new Cell();
    }

    public void drawBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[");

                if (board[i][j].cellStatus.compareTo(CellStatus.X) == 0)
                    System.out.print("X");
                else if (board[i][j].cellStatus.compareTo(CellStatus.O) == 0)
                    System.out.print("0");
                else
                    System.out.print(" ");

                System.out.print("]");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public boolean isSomeoneWins(int row, int column, CellStatus status) {
        boolean winRows = true, winColumns = true, winCross1 = true, winCross2 = true;
        for (int i = 0; i < 3; i++) {
            if (board[row][i].cellStatus.compareTo(status) != 0) {
                winRows = false;
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][column].cellStatus.compareTo(status) != 0) {
                winColumns = false;
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][i].cellStatus.compareTo(status) != 0) {
                winCross1 = false;
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i].cellStatus.compareTo(status) != 0) {
                winCross2 = false;
                break;
            }
        }
        return winColumns | winRows | winCross1 | winCross2;
    }

    public boolean isFullFill() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].cellStatus.compareTo(CellStatus.EMPTY) == 0)
                    return false;
        return true;
    }

    public void insert(int row, int column) {

        if (board[row][column].cellStatus.compareTo(CellStatus.EMPTY) != 0) {
            System.out.println("Someone has already made a move at this position. Try again!");
            Game.playerX = !Game.playerX;
            return;
        }

        if (Game.playerX)
            board[row][column].insertX();
        else
            board[row][column].insertO();

        if (isSomeoneWins(row, column, board[row][column].cellStatus))
            Game.hasWinner = true;
        drawBoard();
    }

}
