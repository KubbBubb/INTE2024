import rougelike.Profession;
import rougelike.professions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfessionClassTest {
    private Profession testWizard = new Wizard();

    @Test
    public void testGetHealthModifier() {
        assertEquals(testWizard.getHealthModifier(), 0.8);
    }

    @Test
    public void testGetStrengthModifier() {
        assertEquals(testWizard.getStrengthModifier(), 0.5);
    }

    @Test
    public void testGetMagicModifier() {
        assertEquals(testWizard.getMagicModifier(), 1.5);
    }
}
