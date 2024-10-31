
import rougelike.Map;
import rougelike.Player;
import rougelike.Position;
import rougelike.Terrain;
import rougelike.races.Dwarf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerClassTest {
    private Player player;
    private Map map;

    @BeforeEach
    public void setUp() {
        Dwarf dwarf = new Dwarf();
        player = new Player("TestPlayer", dwarf,new Position(0,0));
        map=new Map(10,10);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                map.setTerrain(x, y, new Terrain("Grass", 1, false, "walk"));
            }
        }


    }

    @Test
    public void testInitialExperience() {
        assertEquals(0, player.getExperience(), "Base experience should be 0");
    }


    @Test
    public void testAddExperienceUnderLevelUpThreshold() {
        player.addExperience(50);
        assertEquals(50, player.getExperience(), "Experience should be 50 after adding 50");
        assertEquals(1, player.getLevel(), "Level should remain 1 when experience is below 100");
    }

    @Test
    public void testAddExperienceLevelUp() {
        player.addExperience(120);
        assertEquals(20, player.getExperience(), "Experience should be 20 after leveling up with 120 experience");
        assertEquals(2, player.getLevel(), "Level should be 2 after gaining 100 experience");
    }

    @Test
    public void testAddExperienceMultipleLevelUps() {
        player.addExperience(250);
        assertEquals(50, player.getExperience(), "Experience should be 50 after leveling up with 250 experience");
        assertEquals(3, player.getLevel(), "Level should be 3 after gaining 250 experience");
    }

    @Test
    public void testGetName() {
        assertEquals("TestPlayer", player.getName(), "Name should be 'TestPlayer'");
    }

    @Test
    public void testInitialHealth() {
        assertEquals(100, player.getHealth(), "Initial health should be 100");
    }

    @Test
    public void testInitialLevel() {
        assertEquals(1, player.getLevel(), "Initial level should be 1");
    }

    @Test
    public void testMaxLevel() {
        // Försöker ge experience som tar spelaren över max level 10
        player.addExperience(1000);
        assertEquals(10, player.getLevel(), "rougelike.Player level should not exceed max level of 10");
    }

    @Test
    public void testMoveWithinBounds() {
        assertTrue(player.move(map, "right"), "Player should move right within bounds");
        assertEquals(new Position(1, 0), player.getPosition(), "Player position should update correctly");
        assertTrue(player.move(map, "down"), "Player should  move down within bounds");
        assertEquals(new Position(1, 1), player.getPosition(), "Player position should update correctly");
    }

    @Test
    public void testMoveOutOfBounds() {
        player.setPosition(new Position(0, 0));
        assertFalse(player.move(map, "left"), "Player should not move out of bounds");
        assertEquals(new Position(0, 0), player.getPosition(), "Player position should remain the same when out of bounds");
    }

    @Test
    public void testMoveOnBlockingTerrain() {
        map.setTerrain(1, 0, new Terrain("Wall", 1, true, "walk"));
        assertFalse(player.move(map, "right"), "Player should not move onto blocking terrain");
        assertEquals(new Position(0, 0), player.getPosition(), "Player position should remain the same on blocked move");
    }
}

