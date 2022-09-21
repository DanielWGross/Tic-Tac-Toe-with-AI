package tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Game implements TicTacToePlayer {
    private final char marker;
    private final char enemyMarker;

    public HumanPlayer(char marker, char enemyMarker) {
        this.marker = marker;
        this.enemyMarker = enemyMarker;
    }

    @Override
    public void makeMove() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int location = 0;
            int row = 0;
            int column = 0;
            System.out.print("Enter the coordinates:");

            String input = scanner.nextLine();
            input = input.replaceAll("\\s", "");

            try {
                row = Integer.parseInt(String.valueOf(input.charAt(0)));
            } catch (NumberFormatException nfe) {
                System.out.println("You should enter numbers!");
                continue;
            }

            try {
                column = Integer.parseInt(String.valueOf(input.charAt(1)));
            } catch (NumberFormatException nfe) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (row < 1 || row > 3 || column < 1 || column > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (row == 1) {
                location += 0;
            } else if (row == 2) {
                location += 3;
            } else if (row == 3) {
                location += 6;
            }

            if (column == 1) {
                location += 0;
            } else if (column == 2) {
                location += 1;
            } else if (column == 3) {
                location += 2;
            }

            if (' ' != cells[location]) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                cells[location] = marker;
                break;
            }
        }

    }
}
