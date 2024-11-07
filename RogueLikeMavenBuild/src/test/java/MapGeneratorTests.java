import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.Map;
import rougelike.MapGenerator;
import rougelike.Terrain;

import static org.junit.jupiter.api.Assertions.*;

public class MapGeneratorTests {
    private final int width = 30;
    private final int height = 30;
    private MapGenerator mapGenerator;

    @BeforeEach
    void setUp() {
        mapGenerator = new MapGenerator(width, height);
    }

    @Test
    void testGenerateMapCorrectDimensions() {
        Map map = mapGenerator.generateMap();
        assertEquals(width, map.getWidth(), "Map width should be equal to the given width");
        assertEquals(height, map.getHeight(), "Map height should be equal to the given height");
    }

    @Test
    void testGenerateMapLeavesNoEmptySpaces() {
        Map map = mapGenerator.generateMap();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Terrain terrain = map.getTerrain(x, y);
                assertNotNull(terrain, "No terrain space should be null");
            }
        }
    }

    @Test
    void testTerrainPresence() {
        Map map = mapGenerator.generateMap();
        boolean waterExists = false;
        boolean grassExists = false;
        boolean mountainExists = false;
        boolean houseExists = false;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Terrain terrain = map.getTerrain(x, y);
                switch (terrain.getTerrainType()) {
                    case "Water" -> waterExists = true;
                    case "Grass" -> grassExists = true;
                    case "Mountain" -> mountainExists = true;
                    case "House" -> houseExists = true;
                }
                if (waterExists && grassExists && mountainExists && houseExists) {
                    break;
                }
            }
        }
        assertTrue(waterExists, "Map should contain at least one water terrain type.");
        assertTrue(grassExists, "Map should contain at least one grass terrain type.");
        assertTrue(mountainExists, "Map should contain at least one mountain terrain type.");
        assertTrue(houseExists, "Map should contain at least one house terrain type.");
    }

    @Test
    public void testVisibilityInGeneratedMap() {
        Map map = mapGenerator.generateMap();
        int playerX = 5;
        int playerY = 5;
        int visionRange = 2;

        map.calculateVisibility(playerX, playerY, visionRange);

        for (int x = playerX - visionRange; x <= playerX + visionRange; x++) {
            for (int y = playerY - visionRange; y <= playerY + visionRange; y++) {
                if (map.isWithinBounds(x, y)) {
                    Terrain terrain = map.getTerrain(x, y);
                    assertTrue(terrain.isVisible(), "Terrain within range should be visible");
                    assertTrue(terrain.isExplored(), "Terrain within range should be explored");
                }
            }
        }
    }

    @Test
    void testGenerateMapTerrainDistribution() {
        Map map = mapGenerator.generateMap();
        int waterCount = 0;
        int grassCount = 0;
        int mountainCount = 0;
        int houseCount = 0;
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Terrain terrain = map.getTerrain(x, y);
                switch (terrain.getTerrainType()) {
                    case "Water" -> waterCount++;
                    case "Grass" -> grassCount++;
                    case "Mountain" -> mountainCount++;
                    case "House" -> houseCount++;
                }
            }
        }
        int totalTerrains = map.getWidth() * map.getHeight();
        double waterRatio = (double) waterCount / totalTerrains;
        double grassRatio = (double) grassCount / totalTerrains;
        double mountainRatio = (double) mountainCount / totalTerrains;
        double houseRatio = (double) houseCount / totalTerrains;
        assertTrue(waterRatio >= 0.20 && waterRatio <= 0.30, "Water terrain ratio should be close to 0.25 ± 0.05");
        assertTrue(grassRatio >= 0.20 && grassRatio <= 0.30, "Grass terrain ratio should be close to 0.25 ± 0.05");
        assertTrue(mountainRatio >= 0.20 && mountainRatio <= 0.30, "Mountain terrain ratio should be close to 0.25 ± 0.05");
        assertTrue(houseRatio >= 0.20 && houseRatio <= 0.30, "House terrain ratio should be close to 0.25 ± 0.05");
    }
}
