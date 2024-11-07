import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.Position;

public class PositionTests {

    private Position startPosition;

    @BeforeEach
    public void setUp() {
        startPosition = new Position(0, 0);
    }

    @Test
    public void testInitialization() {
        Position pos = new Position(8, 10);
        assertEquals(8, pos.getX(), "X should be equal to 8");
        assertEquals(10, pos.getY(), "Y should be equal to 10");
    }

    @Test
    public void testMoveUp() {
        Position newPosition = startPosition.move("up");
        assertEquals(0, newPosition.getX(), "X should remain 0 when moving up");
        assertEquals(-1, newPosition.getY(), "Y should be decreased by 1 when moving up");
    }

    @Test
    public void testMoveDown() {
        Position newPosition = startPosition.move("down");
        assertEquals(0, newPosition.getX(), "X should remain 0 when moving down");
        assertEquals(1, newPosition.getY(), "Y should increase by 1 when moving down");
    }

    @Test
    public void testMoveLeft() {
        Position newPosition = startPosition.move("left");
        assertEquals(-1, newPosition.getX(), "X should decrease by 1 when moving left");
        assertEquals(0, newPosition.getY(), "Y should remain 0 when moving left");
    }

    @Test
    public void testMoveRight() {
        Position newPosition = startPosition.move("right");
        assertEquals(1, newPosition.getX(), "X should increase by 1 when moving right");
        assertEquals(0, newPosition.getY(), "Y should remain 0 when moving right");
    }

    @Test
    public void testEquals() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 2);
        Position p3 = new Position(2, 2);
        assertEquals(p1, p2, "Positions with same coordinates should be equal");
        assertNotEquals(p1, p3, "Positions with different coordinates should not be equal");
    }

    @Test
    public void testHashCode() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 2);
        Position p3 = new Position(2, 2);
        assertEquals(p1.hashCode(), p2.hashCode(), "Hash codes should be equal for positions with same coordinates");
        assertNotEquals(p1.hashCode(), p3.hashCode(), "Hash codes should differ for positions with different coordinates");
    }

}
