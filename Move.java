package tictactoe;

public class Move {
    private int location;

    public Move() {
    }

    public Move(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
