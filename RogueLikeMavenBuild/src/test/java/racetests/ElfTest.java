package racetests;

import org.junit.jupiter.api.Test;
import rougelike.races.Elf;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ElfTest {
    Elf testElf = new Elf();

    @Test
    public void testElfModifiers() {
        assertEquals(testElf.getHealthModifier(), 0.5);
        assertEquals(testElf.getStaminaModifier(), 2);
        assertEquals(testElf.getSpeedModifier(), 1.25);
        assertEquals(testElf.getStrengthModifier(), 1.25);
        assertEquals(testElf.getMagicModifier(), 1);
    }

    @Test
    public void testElfAbility() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testElf.dash();
        System.setOut(System.out);

        assertEquals("Whoosh!", outputStream.toString().trim());
    }
}
