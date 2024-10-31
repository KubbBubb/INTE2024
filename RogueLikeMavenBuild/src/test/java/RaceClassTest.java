import rougelike.Race;
import rougelike.races.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

// Testar de olika metoderna som Rasklassen innehåller
public class RaceClassTest {
    @Test
    public void testGetHealthModifier() {
        Race testHuman = new Human();
        assertEquals(testHuman.getHealthModifier(), 1);
    }

    @Test
    public void testGetStaminaModifier() {
        Race testElf = new Elf();
        assertEquals(testElf.getStaminaModifier(), 2);
    }

    @Test
    public void testGetSpeedModifier() {
        Race testDwarf = new Dwarf();
        assertEquals(testDwarf.getSpeedModifier(), 0.75);
    }

    @Test
    public void testGetStrengthModifier() {
        Race testGiant = new Giant();
        assertEquals(testGiant.getStrengthModifier(), 2);
    }

    @Test
    public void testGetMagicModifier() {
        Race testAngel = new Angel();
        assertEquals(testAngel.getMagicModifier(), 2);
    }
    @Test
    public void testCharacterType() {
        Race Angel = new Angel();
        assertTrue(Angel.getCharacterType().containsAll(Set.of("walk", "fly")), "Angel should be able to walk and fly");
        Race testHuman = new Human();
        assertTrue(testHuman.getCharacterType().containsAll(Set.of("walk", "swim")), "Human should be able to to walk and swim");
    }
}
