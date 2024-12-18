import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.Terrain;

import static org.junit.jupiter.api.Assertions.*;

public class TerrainTests {
    private Terrain terrain;
    @BeforeEach
    void setUp() {
        terrain = new Terrain("Mountain", 10,false,"fly");
    }
    @Test
    void testConstructorForTerrainType() {
        assertEquals("Mountain", terrain.getTerrainType(), "Constructor should set the  terrain to Mountain");
    }
    @Test
    void testConstructorForAccessType() {
        assertEquals("fly", terrain.getAccessType(), "Constructor should set the accessType to 'fly'");
    }
    @Test
    void testConstructorForHeight() {
        assertEquals(10, terrain.getHeight(), "Constructor should set the correct height");
    }
    @Test
    void testConstructorForInitialVisibilityAndExpolaration(){
        assertFalse(terrain.isVisible(), "isVisible() should initially be false");
        assertFalse(terrain.isExplored(), "isExplored() should initially be false");
    }
    @Test
    void testGetTerrainType() {
        assertEquals("Mountain", terrain.getTerrainType(), "getTerrainType() should set the terrain to Mountain");
    }
    @Test
    void testIfVisibleMethod(){
        assertFalse(terrain.isVisible(),"isVisible() should return false");
    }
    @Test
    void testSetVisibleToTrue() {
        terrain.setVisible(true);
        assertTrue(terrain.isVisible(), "setVisible(true) should make isVisible() return true");
    }

    @Test
    void testSetVisibleToFalse() {
        terrain.setVisible(true);
        terrain.setVisible(false);
        assertFalse(terrain.isVisible(), "setVisible(false) should make isVisible() return false");
    }
    @Test
    void testIsExplored() {
        assertFalse(terrain.isExplored(),"isExplored() should return false");
    }
    @Test
    void testSetExploredToTrue() {
        terrain.setExplored(true);
        assertTrue(terrain.isExplored(), "setExplored(true) should make isExplored() return true");
    }

    @Test
     void testSetExploredToFalse() {
        terrain.setExplored(true);
        terrain.setExplored(false);
        assertFalse(terrain.isExplored(), "setExplored(false) should make isExplored() return false");
    }
    @Test
    void testGetHeight() {
        assertEquals(10, terrain.getHeight(), "getHeight() should return 10");
    }

    @Test
    void testIsBlocking(){
        Terrain nonBlockingTerrain = new Terrain("Grass", 1, false, "Walk");
        assertFalse(nonBlockingTerrain.isBlocking(), "isBlocking() should return false ");
        Terrain blockingTerrain = new Terrain("Mountain", 5, true, "fly");
        assertTrue(blockingTerrain.isBlocking(), "isBlocking() should return true ");
    }
    @Test
    void testGetAccessType() {
        assertEquals("fly", terrain.getAccessType(), "getAccessType() should return 'fly'");

    }

}
