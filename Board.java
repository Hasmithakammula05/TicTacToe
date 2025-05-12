public class Board {
    private char[][] board;
    private static final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = ' ';
    }

    public void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean markCell(int row, int col, char symbol) {
        if (isCellEmpty(row, col)) {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    public char[][] getBoard() {
        return board;
    }
}