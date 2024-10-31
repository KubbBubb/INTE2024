package racetests;

import org.junit.jupiter.api.Test;
import rougelike.races.Giant;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class GiantTest {
    Giant testGiant = new Giant();

    @Test
    public void testGiantModifiers() {
        assertEquals(testGiant.getHealthModifier(), 2);
        assertEquals(testGiant.getStaminaModifier(), 0.5);
        assertEquals(testGiant.getSpeedModifier(), 0.5);
        assertEquals(testGiant.getStrengthModifier(), 2);
        assertEquals(testGiant.getMagicModifier(), 0);
    }

    @Test
    public void testGiantAbility() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testGiant.sleep();
        System.setOut(System.out);

        assertEquals("Zzz...", outputStream.toString().trim());
    }
    @Test
    public void testGiantAccessTypes() {
        assertTrue(testGiant.getCharacterType().contains("walk"), "Giant should be able walk");
    }
}
