package racetests;

import org.junit.jupiter.api.Test;
import rougelike.races.Human;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {
    Human testHuman = new Human();

    @Test
    public void testHumanModifiers() {
        assertEquals(testHuman.getHealthModifier(), 1);
        assertEquals(testHuman.getStaminaModifier(), 1);
        assertEquals(testHuman.getSpeedModifier(), 1);
        assertEquals(testHuman.getStrengthModifier(), 1);
        assertEquals(testHuman.getMagicModifier(), 1);
    }

    @Test
    public void testHumanAbility() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testHuman.talk();
        System.setOut(System.out);

        assertEquals("Greetings!", outputStream.toString().trim());
    }
    @Test
    public void testHumanAccessTypes() {
        assertTrue(testHuman.getCharacterType().containsAll(Set.of("walk", "swim")), "Human should be able to walk and swim");
    }
}
