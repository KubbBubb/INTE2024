
import org.junit.jupiter.api.Test;
import rougelike.GameCharacter;
import rougelike.Player;
import rougelike.races.Angel;
import rougelike.races.Human;

import static org.junit.jupiter.api.Assertions.*;

public class GameCharacterClassTest {

    @Test
    public void testGameCharacterHasName() {
        GameCharacter gameCharacter = new GameCharacter("TestPlayer1", new Human());
        assertEquals("TestPlayer1", gameCharacter.getName(), "Character should have a name");
    }

    @Test
    public void testGameCharacterInitialHealth() {
        GameCharacter gameCharacter = new GameCharacter("TestPlayer", new Human());
        assertEquals(100, gameCharacter.getHealth(), "Character should have initial health of 100");
    }

    @Test
    public void testGameCharacterInitialLevel() {
        GameCharacter gameCharacter = new GameCharacter("TestPlayer", new Human());
                assertEquals(1, gameCharacter.getLevel(), "Character should have initial level of 1");
    }

    @Test
    public void testGetRace() {
        Player testPlayer = new Player("TestAngel", new Angel());
        assertInstanceOf(Angel.class, testPlayer.getRace(), "Race should be Angel");
    }

    @Test
    public void testGameCharacterStrengthBasedOnRace() {
        GameCharacter gameCharacter = new GameCharacter("TestHuman", new Human());
        assertEquals(10 * gameCharacter.getRace().getStrengthModifier(), gameCharacter.getStrength(),
                "Character's strength should be based on race modifier");
    }

    @Test
    public void testGameCharacterSpeedBasedOnRace() {
        GameCharacter gameCharacter = new GameCharacter("TestHuman", new Human());
        assertEquals(10 * gameCharacter.getRace().getSpeedModifier(), gameCharacter.getSpeed(),
                "Character's speed should be based on race modifier");
    }
}
