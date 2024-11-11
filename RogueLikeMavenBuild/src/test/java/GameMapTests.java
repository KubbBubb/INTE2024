import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.GameMap;
import rougelike.Terrain;

import static org.junit.jupiter.api.Assertions.*;

class GameMapTests {

    private GameMap map;
    private final int width = 5;
    private final int height = 5;

    @BeforeEach
    void setUp() {
        map = new GameMap(width, height);
    }

    @Test
    void testMapConstructor() {
        assertEquals(width, map.getWidth());
        assertEquals(height, map.getHeight());
    }

    @Test
    void testDefaultTerrainInitialization() {
        for (int x = 0; x < width; x++) {
            {
                Terrain terrain = map.getTerrain(x, 0);
                assertNotNull(terrain);
                assertEquals("Grass", terrain.getTerrainType());
                assertEquals(1, terrain.getHeight());
            }
            {
                Terrain terrain = map.getTerrain(x, 1);
                assertNotNull(terrain);
                assertEquals("Grass", terrain.getTerrainType());
                assertEquals(1, terrain.getHeight());
            }
            {
                Terrain terrain = map.getTerrain(x, 2);
                assertNotNull(terrain);
                assertEquals("Grass", terrain.getTerrainType());
                assertEquals(1, terrain.getHeight());
            }
            {
                Terrain terrain = map.getTerrain(x, 3);
                assertNotNull(terrain);
                assertEquals("Grass", terrain.getTerrainType());
                assertEquals(1, terrain.getHeight());
            }
            {
                Terrain terrain = map.getTerrain(x, 4);
                assertNotNull(terrain);
                assertEquals("Grass", terrain.getTerrainType());
                assertEquals(1, terrain.getHeight());
            }
        }
    }

    @Test
    void testSetTerrainWithinBounds() {
        Terrain mountain = new Terrain("Mountain", 5, false, "fly");
        map.setTerrain(2, 2, mountain);
        Terrain terrain = map.getTerrain(2, 2);

        assertNotNull(terrain);
        assertEquals("Mountain", terrain.getTerrainType());
        assertEquals(5, terrain.getHeight());
    }

    @Test
    void testGetTerrainWithinBounds() {
        Terrain terrain = map.getTerrain(0, 0);
        assertEquals("Grass", terrain.getTerrainType());
    }

    @Test
    void testSetTerrainOutOfBounds() {
        Terrain mountain = new Terrain("Mountain", 5, false, "fly");
        map.setTerrain(-1, -1, mountain);
        assertNull(map.getTerrain(-1, -1));
    }

    @Test
    void testGetTerrainOutOfBounds() {
        assertNull(map.getTerrain(-1, 0));
        assertNull(map.getTerrain(0, -1));
        assertNull(map.getTerrain(width, 0));
        assertNull(map.getTerrain(0, height));
    }

    @Test
    void testCalculateVisibility() {
        int playerX = 2;
        int playerY = 2;
        int visionRange = 1;
        map.calculateVisibility(playerX, playerY, visionRange);

        for (int x = playerX - visionRange; x <= playerX + visionRange; x++) {
            for (int y = playerY - visionRange; y <= playerY + visionRange; y++) {
                if (map.isWithinBounds(x, y)) {
                    Terrain terrain = map.getTerrain(x, y);
                    assertTrue(terrain.isVisible());
                    assertTrue(terrain.isExplored());
                }
            }
        }
    }

    @Test
    void testCalculateVisibilityThroughObjects() {
        int playerX = 2;
        int playerY = 2;
        int visionRange = 1;

        map.calculateVisibility(playerX, playerY, visionRange);

        for (int x = playerX - visionRange; x <= playerX + visionRange; x++) {
            for (int y = playerY - visionRange; y <= playerY + visionRange; y++) {
                if (map.isWithinBounds(x, y)) {
                    Terrain terrain = map.getTerrain(x, y);
                    if (x == 3 && y == 2 && terrain.getTerrainType().equals("Mountain")) {
                        assertTrue(terrain.isVisible());
                    } else {
                        assertTrue(terrain.isVisible());
                    }
                }
            }
        }
    }

    @Test
    void testCalculateVisibilityOutsideRange() {
        int playerX = 2;
        int playerY = 2;
        int visionRange = 1;
        map.calculateVisibility(playerX, playerY, visionRange);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (Math.abs(x - playerX) > visionRange || Math.abs(y - playerY) > visionRange) {
                    Terrain terrain = map.getTerrain(x, y);
                    assertFalse(terrain.isVisible());
                    assertFalse(terrain.isExplored());
                }
            }
        }
    }

    @Test
    void testIsWithinBounds() {
        assertTrue(map.isWithinBounds(0, 0));
        assertTrue(map.isWithinBounds(width - 1, height - 1));
        assertFalse(map.isWithinBounds(-1, 0));
        assertFalse(map.isWithinBounds(0, -1));
        assertFalse(map.isWithinBounds(width, 0));
        assertFalse(map.isWithinBounds(0, height));
    }
}
