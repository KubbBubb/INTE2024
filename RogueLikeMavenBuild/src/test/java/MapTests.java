
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.Map;
import rougelike.Terrain;

import static org.junit.jupiter.api.Assertions.*;

class MapTests {

    private Map map;
    private final int width = 5;
    private final int height = 5;

    @BeforeEach
    void setUp() {
        map = new Map(width, height);
    }


    @Test
    void testMapConstructor() {
        assertEquals(width, map.getWidth(), "Width should be initialized correctly");
        assertEquals(height, map.getHeight(), "Height should be initialized correctly");
    }


    @Test
    void testDefaultTerrainInitialization() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Terrain terrain = map.getTerrain(x, y);
                assertNotNull(terrain, "Terrain should be initialized correctly at all positions");
                assertEquals("Grass", terrain.getTerrainType(), "Default terrain type should be Grass");
                assertEquals(1, terrain.getHeight(), "Default terrain height should be 1");
            }
        }
    }

    @Test
    void testSetTerrainWithinBounds() {
        Terrain mountain = new Terrain("Mountain", 5);
        map.setTerrain(2, 2, mountain);
        Terrain retrievedTerrain = map.getTerrain(2, 2);

        assertNotNull(retrievedTerrain, "Terrain at (2, 2) should not be null");
        assertEquals("Mountain", retrievedTerrain.getTerrainType(), "Terrain type should be Mountain at (2, 2)");
        assertEquals(5, retrievedTerrain.getHeight(), "Terrain height should be 5 at (2, 2)");
    }
    @Test
    void testGetTerrainWithinBounds() {
        Terrain terrain = map.getTerrain(0, 0);
        assertNotNull(terrain, "Terrain should be retrievable within bounds");
        assertEquals("Grass", terrain.getTerrainType(), "Default terrain should be Grass");
    }

    @Test
    void testSetTerrainOutOfBounds() {
        Terrain mountain = new Terrain("Mountain", 5);
        map.setTerrain(-1, -1, mountain);

        assertNull(map.getTerrain(-1, -1), "Out-of-bounds terrain should return null");
    }

    @Test
    void testGetTerrainOutOfBounds() {
        assertNull(map.getTerrain(-1, 0), "Negative x-coordinate should return null");
        assertNull(map.getTerrain(0, -1), "Negative y-coordinate should return null");
        assertNull(map.getTerrain(width, 0), "x-coordinate equal to width should return null");
        assertNull(map.getTerrain(0, height), "y-coordinate equal to height should return null");
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
                    assertTrue(terrain.isVisible(), "Terrain at (" + x + "," + y + ") should be visible");
                    assertTrue(terrain.isExplored(), "Terrain at (" + x + "," + y + ") should be explored");
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
                    assertFalse(terrain.isVisible(), "Terrain at (" + x + "," + y + ") should not be visible");
                    assertFalse(terrain.isExplored(), "Terrain at (" + x + "," + y + ") should not be explored");
                }
            }
        }
    }


    @Test
    void testIsWithinBounds() {
        assertTrue(map.isWithinBounds(0, 0), "(0, 0) should be within bounds");
        assertTrue(map.isWithinBounds(width - 1, height - 1), "(width-1, height-1) should be within bounds");

        assertFalse(map.isWithinBounds(-1, 0), "(-1, 0) should be out of bounds");
        assertFalse(map.isWithinBounds(0, -1), "(0, -1) should be out of bounds");
        assertFalse(map.isWithinBounds(width, 0), "(width, 0) should be out of bounds");
        assertFalse(map.isWithinBounds(0, height), "(0, height) should be out of bounds");
    }
}
