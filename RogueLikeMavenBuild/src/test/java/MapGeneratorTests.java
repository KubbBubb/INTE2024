import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import rougelike.Map;
import rougelike.MapGenerator;
import rougelike.Terrain;

import static org.junit.jupiter.api.Assertions.*;
public class MapGeneratorTests {

    private final int width = 10;
    private final int height = 10;
    private MapGenerator mapGenerator;


    @BeforeEach
    void setUp() {
        mapGenerator = new MapGenerator(width, height);
    }

    @Test
    void testGenerateMapDimensions() {
        Map map = mapGenerator.generateMap();
        assertEquals(width, map.getWidth(), "Map width should match the given width");
        assertEquals(height, map.getHeight(), "Map height should match the given height");
    }


    @Test
    void testGenerateMapLeavesNoEmptySpaces() {
        Map map = mapGenerator.generateMap();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Terrain terrain = map.getTerrain(x, y);
                assertNotNull(terrain, "Terrain  should not be null");
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
                assertNotNull(terrain, "Terrain should not be null");
                switch (terrain.getTerrainType()) {
                    case "Water" -> waterCount++;
                    case "Grass" -> grassCount++;
                    case "Mountain" -> mountainCount++;
                    case "House" -> houseCount++;
                    default -> fail("Unknown terrain type: " + terrain.getTerrainType());
                }
            }
        }
        int totalTerrains = map.getWidth() * map.getHeight();
        int expectedCountPerType = totalTerrains / 4;
        int tolerance = 1;
        assertTrue(Math.abs(waterCount - expectedCountPerType) <= tolerance,
                "Water terrain count should be within the expected range ±1");
        assertTrue(Math.abs(grassCount - expectedCountPerType) <= tolerance,
                "Grass terrain count should be within the expected range ±1");
        assertTrue(Math.abs(mountainCount - expectedCountPerType) <= tolerance,
                "Mountain terrain count should be within the expected range ±1");
        assertTrue(Math.abs(houseCount - expectedCountPerType) <= tolerance,
                "House terrain count should be within the expected range ±1");
    }

    @Test
    public void testVisibilityInGeneratedMap() {
        int height = 15;
        MapGenerator generator = new MapGenerator(width, height);
        Map map = generator.generateMap();
        int playerX = 5;
        int playerY = 5;
        int visionRange = 2;
        map.calculateVisibility(playerX, playerY, visionRange);
        for (int x = playerX - visionRange; x <= playerX + visionRange; x++) {
            for (int y = playerY - visionRange; y <= playerY + visionRange; y++) {
                if (map.isWithinBounds(x, y)) {
                    Terrain terrain = map.getTerrain(x, y);
                    assertTrue(terrain.isVisible(), "Terrain should be marked visible");
                    assertTrue(terrain.isExplored(), "Terrain should be marked explored");

                }
            }
        }
    }
}
