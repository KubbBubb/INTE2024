package racetests;

import org.junit.jupiter.api.Test;
import rougelike.races.Dwarf;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DwarfTest {
    Dwarf testDwarf = new Dwarf();

    @Test
    public void testDwarfModifiers() {
        assertEquals(testDwarf.getHealthModifier(), 1.5);
        assertEquals(testDwarf.getStaminaModifier(), 0.5);
        assertEquals(testDwarf.getSpeedModifier(), 0.75);
        assertEquals(testDwarf.getStrengthModifier(), 1.5);
        assertEquals(testDwarf.getMagicModifier(), 0.25);
    }

    @Test
    public void testDwarfAbility() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testDwarf.mine();
        System.setOut(System.out);

        assertEquals("Tick!", outputStream.toString().trim());
    }
    @Test
    public void testDwarfAccessTypes() {
        assertTrue(testDwarf.getCharacterType().contains("walk"), "Dwarf should be able to walk");
    }
}
