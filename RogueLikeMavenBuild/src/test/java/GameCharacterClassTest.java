
import org.junit.jupiter.api.Test;
import rougelike.GameCharacter;
import rougelike.NonPlayableCharacter;
import rougelike.Player;
import rougelike.armour.Chestplate;
import rougelike.armour.Helmet;
import rougelike.armour.Trinket;
import rougelike.professions.Wizard;
import rougelike.races.Angel;
import rougelike.races.Dwarf;
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

    @Test
    public void testGameCharacterProfessionBoost() {
        NonPlayableCharacter npc1 = new NonPlayableCharacter("TestPlayer1", new Human());
        NonPlayableCharacter npc2 = new NonPlayableCharacter("TestPlayer1", new Human());
        npc1.setProfession(new Wizard());

        assertEquals(npc2.getHealth() * 0.8, npc1.getHealth());
        assertEquals(npc2.getStrength() * 0.5, npc1.getStrength());
        assertEquals(npc2.getMagic() * 1.5, npc1.getMagic());
    }

    @Test
    public void testGameCharacterSuccessfulGetProfession() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human());
        npc.setProfession(new Wizard());

        assertInstanceOf(Wizard.class, npc.getProfession(), "Profession should be wizard");
    }

    @Test
    public void testGameCharacterFailedGetProfession() {
        NonPlayableCharacter npc = new NonPlayableCharacter("TestPlayer1", new Human());
        assertThrows(IllegalStateException.class, npc::getProfession);
    }

}
