
import org.junit.jupiter.api.Test;
import rougelike.GameCharacter;
import rougelike.Player;
import rougelike.races.Angel;
import rougelike.races.Human;

import static org.junit.jupiter.api.Assertions.*;

public class GameCharacterTest {

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
}
