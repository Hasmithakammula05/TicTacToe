import java.util.Scanner;

public class Game {
    private Board board;
    private Player playerX, playerO;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    public void startGame() {
        boolean playing = true;
        while (playing) {
            board.initializeBoard();
            play();
            System.out.print("Play again? (y/n): ");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            playing = choice.equalsIgnoreCase("y");
        }
    }

    private void play() {
        int moves = 0;
        while (true) {
            board.displayBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn.");
            int[] move = currentPlayer.getMove();

            if (!isValidMove(move)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board.markCell(move[0], move[1], currentPlayer.getSymbol());
            moves++;

            if (checkWin()) {
                board.displayBoard();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                break;
            }

            if (moves == 9) {
                board.displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }

    private boolean isValidMove(int[] move) {
        int row = move[0], col = move[1];
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col);
    }

    private boolean checkWin() {
        char[][] b = board.getBoard();
        char s = currentPlayer.getSymbol();

        // Rows, Columns and Diagonals
        for (int i = 0; i < 3; i++)
            if ((b[i][0] == s && b[i][1] == s && b[i][2] == s) || (b[0][i] == s && b[1][i] == s && b[2][i] == s))
                return true;

        return (b[0][0] == s && b[1][1] == s && b[2][2] == s) || (b[0][2] == s && b[1][1] == s && b[2][0] == s);
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public static void main(String[] args) {
        new Game().startGame();
    }
}
