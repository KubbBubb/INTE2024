
import org.junit.jupiter.api.Test;
import rougelike.NonPlayableCharacter;
import rougelike.Player;
import rougelike.Position;
import rougelike.professions.Wizard;
import rougelike.races.Angel;
import rougelike.races.Dwarf;
import rougelike.races.Human;


import static org.junit.jupiter.api.Assertions.*;

public class GameCharacterClassTest {

    @Test
    public void testGameCharacterHasName() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human(),new Position(2,2));
        assertEquals("TestPlayer1", npc.getName(), "Character should have a name");
    }

    @Test
    public void testGameCharacterInitialHealth() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human(),new Position(2,2));
        assertEquals(100, npc.getHealth(), "Character should have initial health of 100");
    }

    @Test
    public void testGameCharacterInitialLevel() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human(),new Position(2,2));
                assertEquals(1, npc.getLevel(), "Character should have initial level of 1");
    }

    @Test
    public void testGetRace() {
        Player testPlayer = new Player("TestAngel", new Angel(),new Position(2,2));
        assertInstanceOf(Angel.class, testPlayer.getRace(), "Race should be Angel");
    }

    @Test
    public void testGameCharacterStrengthBasedOnRace() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human(),new Position(2,2));
        assertEquals(10 * npc.getRace().getStrengthModifier(), npc.getStrength(),
                "Character's strength should be based on race modifier");
    }

    @Test
    public void testGameCharacterSpeedBasedOnRace() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human(),new Position(2,2));
        assertEquals(10 * npc.getRace().getSpeedModifier(), npc.getSpeed(),
                "Character's speed should be based on race modifier");
    }

    @Test
    public void testGameCharacterProfessionBoost() {
        NonPlayableCharacter npc1 = new NonPlayableCharacter("TestPlayer1", new Human(),new Position(2,2));
        NonPlayableCharacter npc2 = new NonPlayableCharacter("TestPlayer1", new Human(),new Position(3,3));
        npc1.setProfession(new Wizard());

        assertEquals(npc2.getHealth() * 0.8, npc1.getHealth());
        assertEquals(npc2.getStrength() * 0.5, npc1.getStrength());
        assertEquals(npc2.getMagic() * 1.5, npc1.getMagic());
    }

    @Test
    public void testGameCharacterSuccessfulGetProfession() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human(),new Position(2,2));
        npc.setProfession(new Wizard());

        assertInstanceOf(Wizard.class, npc.getProfession(), "Profession should be wizard");
    }

    @Test
    public void testGameCharacterFailedGetProfession() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human(),new Position(2,2));
        assertThrows(IllegalStateException.class, npc::getProfession);
    }
    @Test
    public void testInitialPosition() {
        Human human = new Human();
       Player player = new Player("TestPlayer", human,new Position(0,0));
        Position initialPosition = player.getPosition();
        assertEquals(0, initialPosition.getX(), "Initial X position should be 2");
        assertEquals(0, initialPosition.getY(), "Initial Y position should be 3");
    }
    @Test
    public void testSetPosition() {
        Human human = new Human();
        Player player = new Player("TestPlayer", human,new Position(0,0));
        Position newPosition = new Position(5, 5);
        player.setPosition(newPosition);

        assertEquals(newPosition, player.getPosition(), "Position should update to (5,5)");
        assertEquals(5, player.getPosition().getX(), "Updated X position should be 5");
        assertEquals(5, player.getPosition().getY(), "Updated Y position should be 5");
    }
    @Test
    public void testGetPosition() {
        Human human = new Human();
        Player player = new Player("TestPlayer", human,new Position(0,0));
        assertNotNull(player.getPosition(), "Position should not be null");
        assertEquals(new Position(0, 0), player.getPosition(), "Position should be initialized correctly at (2,3)");
    }


}
