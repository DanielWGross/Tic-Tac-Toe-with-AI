package tictactoe;

public class HardComputerPlayer extends Game implements TicTacToePlayer {
    private final char marker;
    private final char enemyMarker;

    public HardComputerPlayer(char marker, char enemyMarker) {
        this.marker = marker;
        this.enemyMarker = enemyMarker;
    }

    private int evaluateGrid() {
        if (cells[0] == marker && cells[1] == marker && cells[2] == marker || // Row 1 Across Win
                cells[3] == marker && cells[4] == marker && cells[5] == marker || // Row 2 Across Win
                cells[6] == marker && cells[7] == marker && cells[8] == marker || // Row 3 Across Win
                cells[0] == marker && cells[3] == marker && cells[6] == marker || // Column 1 Down Win
                cells[1] == marker && cells[4] == marker && cells[7] == marker || // Column 2 Down Win
                cells[2] == marker && cells[5] == marker && cells[8] == marker || // Column 3 Down Win
                cells[0] == marker && cells[4] == marker && cells[8] == marker || // Diagonal L to R Win
                cells[2] == marker && cells[4] == marker && cells[6] == marker    // Diagonal R to L Win
        ) {
            return 10;
        } else if (cells[0] == enemyMarker && cells[1] == enemyMarker && cells[2] == enemyMarker || // Row 1 Across Win
                cells[3] == enemyMarker && cells[4] == enemyMarker && cells[5] == enemyMarker || // Row 2 Across Win
                cells[6] == enemyMarker && cells[7] == enemyMarker && cells[8] == enemyMarker || // Row 3 Across Win
                cells[0] == enemyMarker && cells[3] == enemyMarker && cells[6] == enemyMarker || // Column 1 Down Win
                cells[1] == enemyMarker && cells[4] == enemyMarker && cells[7] == enemyMarker || // Column 2 Down Win
                cells[2] == enemyMarker && cells[5] == enemyMarker && cells[8] == enemyMarker || // Column 3 Down Win
                cells[0] == enemyMarker && cells[4] == enemyMarker && cells[8] == enemyMarker || // Diagonal L to R Win
                cells[2] == enemyMarker && cells[4] == enemyMarker && cells[6] == enemyMarker    // Diagonal R to L Win
        ) {
            return -10;
        }
        return 0;
    }

    private boolean isMovesRemaining() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == ' ') {
                return true;
            }
        }
        return false;
    }

    private int minimax(boolean isMax) {
        int score = evaluateGrid();

        if (score == 10 || score == -10) {
            return score;
        }

        if (!isMovesRemaining()) {
            return 0;
        }

        int moveScore = -1;

        if (isMax) {
            moveScore = Integer.MIN_VALUE;

            for (int i = 0; i < cells.length; i++) {
                if (cells[i] == ' ') {
                    cells[i] = marker;
                    moveScore = Math.max(moveScore, minimax(false));
                    cells[i] = ' ';
                }
            }
        }

        if (!isMax) {
            moveScore = Integer.MAX_VALUE;

            for (int i = 0; i < cells.length; i++) {
                if (cells[i] == ' ') {
                    cells[i] = enemyMarker;
                    moveScore = Math.min(moveScore, minimax(true));
                    cells[i] = ' ';
                }
            }
        }
        return moveScore;
    }

    private Move findBestMove() {
        int bestScore = Integer.MIN_VALUE;
        Move move = new Move();

        for (int i = 0; i < cells.length; i++) {

            if (cells[i] != ' ') {
                continue;
            }

            cells[i] = marker;
            int moveScore = minimax(false);
            cells[i] = ' ';

            if (moveScore > bestScore) {
                move.setLocation(i);
                bestScore = moveScore;
            }
        }
        return move;
    }

    @Override
    public void makeMove() {
        System.out.println("Making move level \"hard\"");
        Move move = findBestMove();
        cells[move.getLocation()] = marker;

    }
}
