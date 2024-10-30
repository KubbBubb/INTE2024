
import org.junit.jupiter.api.Test;
import rougelike.Entity;
import rougelike.GameCharacter;
import rougelike.Race;

import static org.junit.jupiter.api.Assertions.*;

public class GameCharacterTest {

    @Test
    public void testGameCharacterHasName() {
        GameCharacter gameCharacter = new GameCharacter("TestPlayer", Race __);
        assertEquals("Testname", gameCharacter.getName(), "Character should have a name");
    }

    @Test
    public void testGameCharacterInitialHealth() {
        GameCharacter gameCharacter = new GameCharacter("TestPlayer", Race __);
        assertEquals(100, gameCharacter.getHealth(), "Character should have initial health of 100");
    }

    @Test
    public void testGameCharacterInitialLevel() {
        GameCharacter gameCharacter = new GameCharacter("TestPlayer", Race __);
                assertEquals(1, gameCharacter.getLevel(), "Character should have initial level of 1");
    }
}
