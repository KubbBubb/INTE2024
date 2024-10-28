package RogueLikeMavenBuild.src.test.java;

import RogueLikeMavenBuild.src.main.java.Player;
import RogueLikeMavenBuild.src.main.java.races.Dwarf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerClassTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        var dwarf = new Dwarf();
        player = new Player("TestPlayer", dwarf);
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
        assertEquals(10, player.getLevel(), "Player level should not exceed max level of 10");
    }
}
