
import org.junit.jupiter.api.Test;
import rougelike.GameCharacter;
import rougelike.NonPlayableCharacter;
import rougelike.Player;
import rougelike.races.Angel;
import rougelike.races.Human;

import static org.junit.jupiter.api.Assertions.*;

public class GameCharacterClassTest {

    @Test
    public void testGameCharacterHasName() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human());
        assertEquals("TestPlayer1", npc.getName(), "Character should have a name");
    }

    @Test
    public void testGameCharacterInitialHealth() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human());
        assertEquals(100, npc.getHealth(), "Character should have initial health of 100");
    }

    @Test
    public void testGameCharacterInitialLevel() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human());
                assertEquals(1, npc.getLevel(), "Character should have initial level of 1");
    }

    @Test
    public void testGetRace() {
        Player testPlayer = new Player("TestAngel", new Angel());
        assertInstanceOf(Angel.class, testPlayer.getRace(), "Race should be Angel");
    }

    @Test
    public void testGameCharacterStrengthBasedOnRace() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human());
        assertEquals(10 * npc.getRace().getStrengthModifier(), npc.getStrength(),
                "Character's strength should be based on race modifier");
    }

    @Test
    public void testGameCharacterSpeedBasedOnRace() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human());
        assertEquals(10 * npc.getRace().getSpeedModifier(), npc.getSpeed(),
                "Character's speed should be based on race modifier");
    }
}
