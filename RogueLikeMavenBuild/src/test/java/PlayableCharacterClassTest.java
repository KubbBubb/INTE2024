import rougelike.GameMap;
import rougelike.PlayableCharacter;
import rougelike.Position;
import rougelike.Terrain;
import rougelike.races.Dwarf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.races.Human;
import static org.junit.jupiter.api.Assertions.*;

public class PlayableCharacterClassTest {
    private PlayableCharacter player;

    @BeforeEach
    public void setUp() {
        Dwarf dwarf = new Dwarf();
        player = new PlayableCharacter("TestPlayer", dwarf);
        player.setPosition(0, 0);
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
        assertEquals(150, player.getHealth(), "Initial health should be 150 for a Dwarf");
    }

    @Test
    public void testInitialLevel() {
        assertEquals(1, player.getLevel(), "Initial level should be 1");
    }
     @Test
    public void testPlayerMovesUpWithinBounds() {
        GameMap map = new GameMap(5, 5);
        PlayableCharacter player = new PlayableCharacter("Player", new Human());
        player.setPosition(2,2);
        boolean moveCharacter = player.move(map, "up");
        assertTrue(moveCharacter, "Player should be able to move up within bounds");
        assertEquals(new Position(2, 1), player.getPosition(), "Position should be updated to (2,1)");
    }

    @Test
    public void testPlayerMovesRightWithinBounds() {
        GameMap map = new GameMap(5, 5);
        PlayableCharacter player = new PlayableCharacter("Player", new Human());
        player.setPosition(2,2);
        boolean moveCharacter  = player.move(map, "right");
        assertTrue(moveCharacter, "Player should be able to move right within map bounds");
        assertEquals(new Position(3, 2), player.getPosition(), "Position should be updated to (3,2)");
    }
    @Test
    public void testPlayerMovesLeftWithinBounds() {
        GameMap map = new GameMap(5, 5);
        PlayableCharacter player = new PlayableCharacter("Player", new Human());
        player.setPosition(2,2);
        boolean moveCharacter  = player.move(map, "left");
        assertTrue(moveCharacter, "Player should be able to move right within map bounds");
        assertEquals(new Position(1, 2), player.getPosition(), "Position should be updated to (3,2)");
    }
    @Test
    public void testPlayerMovesDownWithinBounds() {
        GameMap map = new GameMap(5, 5);
        PlayableCharacter player = new PlayableCharacter("Player", new Human());
        player.setPosition(2,2);
        boolean moveCharacter  = player.move(map, "down");
        assertTrue(moveCharacter, "Player should be able to move right within map bounds");
        assertEquals(new Position(2, 3), player.getPosition(), "Position should be updated to (3,2)");
    }

    @Test
    public void testPlayerCannotMoveOutOfBounds() {
        GameMap map = new GameMap(5, 5);
        PlayableCharacter player = new PlayableCharacter("Player", new Human());
        player.setPosition(2,2);
        boolean moveCharacter  = player.move(map, "left");
        assertTrue(moveCharacter, "Player should not be able to move out of map bounds");

    }
    @Test
    public void testPlayerCannotMoveOnToInaccessibleTerrain() {
        GameMap map = new GameMap(5, 5);
        map.setTerrain(2, 1, new Terrain("Water", 0, true, "swim"));
        PlayableCharacter player = new PlayableCharacter("Player", new Dwarf());
        player.setPosition(2,2);
        boolean moveCharacter  = player.move(map, "up");
        assertFalse(moveCharacter, "Player should be blocked from moving onto inaccessible terrain");
        assertEquals(new Position(2, 2), player.getPosition(), "Player should remain in the original position after blocked move");

    }

}
