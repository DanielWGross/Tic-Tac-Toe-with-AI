package tictactoe;

import java.util.Random;

public class MediumComputerPlayer extends Game implements TicTacToePlayer {
    private final char marker;
    private final char enemyMarker;

    MediumComputerPlayer(char marker, char enemyMarker) {
        this.marker = marker;
        this.enemyMarker = enemyMarker;
    }


    private boolean checkIndexZero(char symbol) {
        if (cells[0] != ' ') {
            return false;
        }
        if (cells[1] == symbol && cells[2] == symbol) {
            cells[0] = marker;
            return true;
        }

        if (cells[3] == symbol && cells[6] == symbol) {
            cells[0] = marker;
            return true;
        }

        if (cells[4] == symbol && cells[8] == symbol) {
            cells[0] = marker;
            return true;
        }
        return false;
    }

    private boolean checkIndexOne(char symbol) {
        if (cells[1] != ' ') {
            return false;
        }

        if (cells[0] == symbol && cells[2] == symbol) {
            cells[1] = marker;
            return true;
        }

        if (cells[4] == symbol && cells[7] == symbol) {
            cells[1] = marker;
            return true;
        }
        return false;
    }

    private boolean checkIndexTwo(char symbol) {
        if (cells[2] != ' ') {
            return false;
        }

        if (cells[0] == symbol && cells[1] == symbol) {
            cells[2] = marker;
            return true;
        }
        if (cells[5] == symbol && cells[8] == symbol) {
            cells[2] = marker;
            return true;
        }
        if (cells[4] == symbol && cells[6] == symbol) {
            cells[2] = marker;
            return true;
        }
        return false;
    }

    private boolean checkIndexThree(char symbol) {
        if (cells[3] != ' ') {
            return false;
        }

        if (cells[4] == symbol && cells[5] == symbol) {
            cells[3] = marker;
            return true;
        }
        if (cells[0] == symbol && cells[6] == symbol) {
            cells[3] = marker;
            return true;
        }
        return false;
    }

    private boolean checkIndexFour(char symbol) {
        if (cells[4] != ' ') {
            return false;
        }

        if (cells[3] == symbol && cells[5] == symbol) {
            cells[4] = marker;
            return true;
        }
        if (cells[1] == symbol && cells[7] == symbol) {
            cells[4] = marker;
            return true;
        }
        if (cells[0] == symbol && cells[8] == symbol) {
            cells[4] = marker;
            return true;
        }
        if (cells[2] == symbol && cells[6] == symbol) {
            cells[4] = marker;
            return true;
        }
        return false;
    }

    private boolean checkIndexFive(char symbol) {
        if (cells[5] != ' ') {
            return false;
        }

        if (cells[3] == symbol && cells[4] == symbol) {
            cells[5] = marker;
            return true;
        }
        if (cells[2] == symbol && cells[8] == symbol) {
            cells[5] = marker;
            return true;
        }
        return false;
    }

    private boolean checkIndexSix(char symbol) {
        if (cells[6] != ' ') {
            return false;
        }

        if (cells[7] == symbol && cells[8] == symbol) {
            cells[6] = marker;
            return true;
        }
        if (cells[0] == symbol && cells[3] == symbol) {
            cells[6] = marker;
            return true;
        }
        if (cells[2] == symbol && cells[4] == symbol) {
            cells[6] = marker;
            return true;
        }
        return false;
    }

    private boolean checkIndexSeven(char symbol) {
        if (cells[7] != ' ') {
            return false;
        }

        if (cells[6] == symbol && cells[8] == symbol) {
            cells[7] = marker;
            return true;
        }
        if (cells[1] == symbol && cells[4] == symbol) {
            cells[7] = marker;
            return true;
        }
        return false;
    }

    private boolean checkIndexEight(char symbol) {
        if (cells[8] != ' ') {
            return false;
        }

        if (cells[6] == symbol && cells[7] == symbol) {
            cells[8] = marker;
            return true;
        }
        if (cells[2] == symbol && cells[5] == symbol) {
            cells[8] = marker;
            return true;
        }
        if (cells[0] == symbol && cells[4] == symbol) {
            cells[8] = marker;
            return true;
        }
        return false;
    }

    @Override
    public void makeMove() {
        Random random = new Random();

        System.out.println("Making move level \"medium\"");

        // Check Win Conditions
        if (checkIndexZero(marker)) return;
        if (checkIndexOne(marker)) return;
        if (checkIndexTwo(marker)) return;
        if (checkIndexThree(marker)) return;
        if (checkIndexFour(marker)) return;
        if (checkIndexFive(marker)) return;
        if (checkIndexSix(marker)) return;
        if (checkIndexSeven(marker)) return;
        if (checkIndexEight(marker)) return;

        // Check Block Opponent Win Conditions
        if (checkIndexZero(enemyMarker)) return;
        if (checkIndexOne(enemyMarker)) return;
        if (checkIndexTwo(enemyMarker)) return;
        if (checkIndexThree(enemyMarker)) return;
        if (checkIndexFour(enemyMarker)) return;
        if (checkIndexFive(enemyMarker)) return;
        if (checkIndexSix(enemyMarker)) return;
        if (checkIndexSeven(enemyMarker)) return;
        if (checkIndexEight(enemyMarker)) return;

        while (true) {
            int randomNum = random.nextInt(9);

            if (cells[randomNum] == ' ') {
                cells[randomNum] = marker;
                break;
            }
        }


    }
}
