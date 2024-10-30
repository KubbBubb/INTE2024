
package RogueLikeMavenBuild.src.test.java;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import rougelike.Map;
import rougelike.MapGenerator;
import rougelike.Terrain;

import java.io.IOException;

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

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Terrain terrain = map.getTerrain(x, y);
                assertNotNull(terrain, "Terrain  should not be null");
                switch (terrain.getTerrainType()) {
                    case "Water" -> waterCount++;
                    case "Grass" -> grassCount++;
                    case "Mountain" -> mountainCount++;
                    default -> fail("Unknown terrain type: " + terrain.getTerrainType());
                }
            }
        }
        int totalTerrains = width * height;
        double waterExpectedMin = totalTerrains * 0.2;
        double waterExpectedMax = totalTerrains * 0.4;
        double grassExpectedMin = totalTerrains * 0.2;
        double grassExpectedMax = totalTerrains * 0.4;
        double mountainExpectedMin = totalTerrains * 0.2;
        double mountainExpectedMax = totalTerrains * 0.6;

        assertTrue(waterCount >= waterExpectedMin && waterCount <= waterExpectedMax,
                "Water terrain count should be within expected range");
        assertTrue(grassCount >= grassExpectedMin && grassCount <= grassExpectedMax,
                "Grass terrain count should be within expected range");
        assertTrue(mountainCount >= mountainExpectedMin && mountainCount <= mountainExpectedMax,
                "Mountain terrain count should be within expected range");

    }
}
