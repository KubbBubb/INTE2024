import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.Player;
import rougelike.armour.Chestplate;
import rougelike.armour.Helmet;
import rougelike.armour.Trinket;
import rougelike.races.Dwarf;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerWithRaceAndArmourModifierTest {

    private Player testDwarfPlayer;
    private Helmet helmet;
    private Chestplate chestplate;
    private Trinket trinket;

    @BeforeEach
    public void setUp() {
        testDwarfPlayer = new Player("DwarfPlayer", new Dwarf());
        helmet = new Helmet();
        chestplate = new Chestplate();
        trinket = new Trinket();
    }

    @Test
    public void testHelmetWithDwarfRaceModifiers() {
        testDwarfPlayer.setArmour(helmet);

        assertEquals(100 * testDwarfPlayer.getRace().getHealthModifier() * helmet.getHealthModifier(),
                testDwarfPlayer.getHealth(), "Health should reflect combined Dwarf and Helmet modifiers."
        );
        assertEquals(10 * testDwarfPlayer.getRace().getSpeedModifier() * helmet.getSpeedModifier(),
                testDwarfPlayer.getSpeed(), "Speed should reflect combined Dwarf and Helmet modifiers."
        );
        assertEquals(10 * testDwarfPlayer.getRace().getStrengthModifier() * helmet.getStrengthModifier(),
                testDwarfPlayer.getStrength(), "Strength should reflect combined Dwarf and Helmet modifiers."
        );
        assertEquals(100 * testDwarfPlayer.getRace().getStaminaModifier() * helmet.getStaminaModifier(),
                testDwarfPlayer.getStamina(), "Stamina should reflect combined Dwarf and Helmet modifiers."
        );
    }

    @Test
    public void testChestplateWithDwarfRaceModifiers() {
        testDwarfPlayer.setArmour(chestplate);

        assertEquals(100 * testDwarfPlayer.getRace().getHealthModifier() * chestplate.getHealthModifier(),
                testDwarfPlayer.getHealth(), "Health should reflect combined Dwarf and Chestplate modifiers."
        );
        assertEquals(10 * testDwarfPlayer.getRace().getSpeedModifier() * chestplate.getSpeedModifier(),
                testDwarfPlayer.getSpeed(), "Speed should reflect combined Dwarf and Chestplate modifiers."
        );
        assertEquals(10 * testDwarfPlayer.getRace().getStrengthModifier() * chestplate.getStrengthModifier(),
                testDwarfPlayer.getStrength(), "Strength should reflect combined Dwarf and Chestplate modifiers."
        );
        assertEquals(100 * testDwarfPlayer.getRace().getStaminaModifier() * chestplate.getStaminaModifier(),
                testDwarfPlayer.getStamina(), "Stamina should reflect combined Dwarf and Chestplate modifiers."
        );
    }

    @Test
    public void testTrinketWithDwarfRaceModifiers() {
        testDwarfPlayer.setArmour(trinket);

        assertEquals(100 * testDwarfPlayer.getRace().getHealthModifier() * trinket.getHealthModifier(),
                testDwarfPlayer.getHealth(), "Health should reflect combined Dwarf and Trinket modifiers."
        );
        assertEquals(10 * testDwarfPlayer.getRace().getSpeedModifier() * trinket.getSpeedModifier(),
                testDwarfPlayer.getSpeed(), "Speed should reflect combined Dwarf and Trinket modifiers."
        );
        assertEquals(10 * testDwarfPlayer.getRace().getMagicModifier() * trinket.getMagicModifier(),
                testDwarfPlayer.getMagic(), "Magic should reflect combined Dwarf and Trinket modifiers."
        );
        assertEquals(100 * testDwarfPlayer.getRace().getStaminaModifier() * trinket.getStaminaModifier(),
                testDwarfPlayer.getStamina(), "Stamina should reflect combined Dwarf and Trinket modifiers."
        );
    }
}
