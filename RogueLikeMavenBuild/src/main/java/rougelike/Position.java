package rougelike;
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Position move(String direction) {
        switch (direction.toLowerCase()) {
            case "up":
                return new Position(x, y - 1);
            case "down":
                return new Position(x, y + 1);
            case "left":
                return new Position(x - 1, y);
            case "right":
                return new Position(x + 1, y);
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}

