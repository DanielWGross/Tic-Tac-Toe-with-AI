package tictactoe;

import java.util.Scanner;

public class Game {
    protected static char[] cells;
    protected static TicTacToePlayer PlayerOne;
    protected static TicTacToePlayer PlayerTwo;
    protected static int moveCount;

    Game() {
    }

    Game(String cells) {
        String string = cells.replaceAll("_", " ");
        Game.cells = string.toCharArray();
        moveCount = 0;
    }

    private void getGameState() {
        // Top Frame
        System.out.println("---------");
        for (int i = 0; i < cells.length; i++) {
            //  Left Rail
            if (i == 0 || i == 3 || i == 6) {
                System.out.print("| ");
            }
            // Current Cell
            System.out.print(cells[i] + " ");
            // Right Rail
            if (i == 2 || i == 5 || i == 8) {
                System.out.println("| ");
            }
        }
        // Bottom Frame
        System.out.println("---------");
    }

    private boolean checkWinner() {
        if (cells[0] == 'X' && cells[1] == 'X' && cells[2] == 'X' || // Row 1 Across Win
                cells[3] == 'X' && cells[4] == 'X' && cells[5] == 'X' || // Row 2 Across Win
                cells[6] == 'X' && cells[7] == 'X' && cells[8] == 'X' || // Row 3 Across Win
                cells[0] == 'X' && cells[3] == 'X' && cells[6] == 'X' || // Column 1 Down Win
                cells[1] == 'X' && cells[4] == 'X' && cells[7] == 'X' || // Column 2 Down Win
                cells[2] == 'X' && cells[5] == 'X' && cells[8] == 'X' || // Column 3 Down Win
                cells[0] == 'X' && cells[4] == 'X' && cells[8] == 'X' || // Diagonal L to R Win
                cells[2] == 'X' && cells[4] == 'X' && cells[6] == 'X'    // Diagonal R to L Win
        ) {
            System.out.println("X wins");
            return true;
        } else if (cells[0] == 'O' && cells[1] == 'O' && cells[2] == 'O' || // Row 1 Across Win
                cells[3] == 'O' && cells[4] == 'O' && cells[5] == 'O' || // Row 2 Across Win
                cells[6] == 'O' && cells[7] == 'O' && cells[8] == 'O' || // Row 3 Across Win
                cells[0] == 'O' && cells[3] == 'O' && cells[6] == 'O' || // Column 1 Down Win
                cells[1] == 'O' && cells[4] == 'O' && cells[7] == 'O' || // Column 2 Down Win
                cells[2] == 'O' && cells[5] == 'O' && cells[8] == 'O' || // Column 3 Down Win
                cells[0] == 'O' && cells[4] == 'O' && cells[8] == 'O' || // Diagonal L to R Win
                cells[2] == 'O' && cells[4] == 'O' && cells[6] == 'O'    // Diagonal R to L Win
        ) {
            System.out.println("O wins");
            return true;
        }
        return false;
    }

    private void configureGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input command:");
            String[] input = scanner.nextLine().split(" ");
            String command;
            String playerXOption;
            String playerOOption;

            try {
                command = input[0];
            } catch (RuntimeException e) {
                System.out.println("Bad parameters!");
                continue;
            }

            if (command.equals("exit")) {
                System.exit(0);
            }

            try {
                playerXOption = input[1];
                playerOOption = input[2];
            } catch (RuntimeException e) {
                System.out.println("Bad parameters!");
                continue;
            }

            if (playerXOption.equals("user")) {
                PlayerOne = new HumanPlayer('X', 'O');
            } else {
                if (playerXOption.equals("easy")) {
                    PlayerOne = new EasyComputerPlayer('X', 'O');
                } else if (playerXOption.equals("medium")) {
                    PlayerOne = new MediumComputerPlayer('X', 'O');
                } else {
                    PlayerOne = new HardComputerPlayer('X', 'O');
                }
            }

            if (playerOOption.equals("user")) {
                PlayerTwo = new HumanPlayer('O', 'X');
            } else {
                if (playerOOption.equals("easy")) {
                    PlayerTwo = new EasyComputerPlayer('O', 'X');
                } else if (playerOOption.equals("medium")) {
                    PlayerTwo = new MediumComputerPlayer('O', 'X');
                } else {
                    PlayerTwo = new HardComputerPlayer('O', 'X');
                }
            }
            break;
        }
    }


    public void playGame() {
        configureGame();
        getGameState();
        while (true) {
            if (moveCount == 9) {
                System.out.println("Draw");
                break;
            }
            if (moveCount % 2 == 0) {
                PlayerOne.makeMove();
            } else {
                PlayerTwo.makeMove();
            }
            getGameState();
            if (checkWinner()) {
                break;
            }
            moveCount++;
        }
    }
}