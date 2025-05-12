import java.util.Scanner;

public class Player {
    private char symbol;
    private Scanner scanner;

    public Player(char symbol) {
        this.symbol = symbol;
        scanner = new Scanner(System.in);
    }

    public char getSymbol() {
        return symbol;
    }

    public int[] getMove() {
        System.out.print("Enter your move (1-9): ");
        int move = scanner.nextInt();
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        return new int[]{row, col};
    }
}
