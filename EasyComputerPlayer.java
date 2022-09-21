package tictactoe;

import java.util.Random;

public class EasyComputerPlayer extends Game implements TicTacToePlayer {
    private final char marker;
    private final char enemyMarker;

    EasyComputerPlayer(char marker, char enemyMarker) {
        this.marker = marker;
        this.enemyMarker = enemyMarker;
    }

    @Override
    public void makeMove() {
        Random random = new Random();

        System.out.println("Making move level \"easy\"");

        while (true) {
            int randomNum = random.nextInt(9);

            if (cells[randomNum] == ' ') {
                cells[randomNum] = marker;
                break;
            }
        }


    }
}
