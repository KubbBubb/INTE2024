import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.Armour;
import rougelike.Player;
import rougelike.Position;
import rougelike.armour.Chestplate;
import rougelike.armour.Helmet;
import rougelike.armour.Trinket;
import rougelike.races.Dwarf;

import static org.junit.jupiter.api.Assertions.*;

public class ArmourClassTest {

    private Player player;
    private Armour helmet;
    private Armour chestplate;
    private Armour trinket;

    @BeforeEach
    public void setUp() {
        player = new Player("TestPlayer", new Dwarf(),new Position(0,0));

        helmet = new Helmet();
        chestplate = new Chestplate();
        trinket = new Trinket();
    }

    @Test
    public void testHelmetModifiers() {
        player.setArmour(helmet);

        assertEquals(1.2, helmet.getHealthModifier(), "Health modifier should be 1.2 with Helmet equipped.");
        assertEquals(0.9, helmet.getSpeedModifier(), "Speed modifier should be 0.9 with Helmet equipped.");
        assertEquals(1.0, helmet.getStrengthModifier(), "Strength modifier should be 1.0 with Helmet equipped.");
        assertEquals(1.0, helmet.getMagicModifier(), "Magic modifier should be 1.0 with Helmet equipped.");
        assertEquals(1.0, helmet.getStaminaModifier(), "Stamina modifier should be 1.0 with Helmet equipped.");
    }

    @Test
    public void testChestplateModifiers() {
        player.setArmour(chestplate);

        assertEquals(1.5, chestplate.getHealthModifier(), "Health modifier should be 1.5 with Chestplate equipped.");
        assertEquals(0.8, chestplate.getSpeedModifier(), "Speed modifier should be 0.8 with Chestplate equipped.");
        assertEquals(1.2, chestplate.getStrengthModifier(), "Strength modifier should be 1.2 with Chestplate equipped.");
        assertEquals(1.0, chestplate.getMagicModifier(), "Magic modifier should be 1.0 with Chestplate equipped.");
        assertEquals(0.8, chestplate.getStaminaModifier(), "Stamina modifier should be 0.8 with Chestplate equipped.");
    }

    @Test
    public void testTrinketModifiers() {
        player.setArmour(trinket);

        assertEquals(1.0, trinket.getHealthModifier(), "Health modifier should remain 1.0 with Trinket equipped.");
        assertEquals(1.2, trinket.getSpeedModifier(), "Speed modifier should be 1.2 with Trinket equipped.");
        assertEquals(1.0, trinket.getStrengthModifier(), "Strength modifier should remain 1.0 with Trinket equipped.");
        assertEquals(1.8, trinket.getMagicModifier(), "Magic modifier should be 1.8 with Trinket equipped.");
        assertEquals(1.0, trinket.getStaminaModifier(), "Stamina modifier should remain 1.0 with Trinket equipped.");
    }
}
