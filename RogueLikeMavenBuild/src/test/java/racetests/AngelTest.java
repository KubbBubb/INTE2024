package racetests;

import org.junit.jupiter.api.Test;
import rougelike.races.Angel;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AngelTest {
    Angel testAngel = new Angel();

    @Test
    public void testAngelModifiers() {
        assertEquals(testAngel.getHealthModifier(), 0.5);
        assertEquals(testAngel.getStaminaModifier(), 0.5);
        assertEquals(testAngel.getSpeedModifier(), 2);
        assertEquals(testAngel.getStrengthModifier(), 0);
        assertEquals(testAngel.getMagicModifier(), 2);
    }

    @Test
    public void testAngelAbility() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testAngel.fly();
        System.setOut(System.out);

        assertEquals("Flap, flap, flap.", outputStream.toString().trim());
    }
    @Test
    public void testAngelAccessTypes() {
        assertTrue(testAngel.getCharacterType().containsAll(Set.of("walk", "fly")), "Angel should be able walk and fly");
    }
}
