import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rougelike.GameCharacter;
import rougelike.NonPlayableCharacter;
import rougelike.Player;
import rougelike.races.Dwarf;
import rougelike.races.Elf;
import rougelike.races.Giant;
import rougelike.races.Human;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rougelike.combat.Action.hit;
import static rougelike.combat.Initiative.initativeOrder;


public class CombatTest {

    @Test
    @DisplayName("Testar att utdela ett slag. PC mot NPC ")
    void testUsingActionHit(){

        var human = new Human();

        var pc = new Player("test pc", human);
        var npc = new NonPlayableCharacter("test npc", human);

        double remainingHp =  npc.getHealth() - (npc.getRace().getStrengthModifier() * 10);
        hit(pc, npc);

        assertEquals(90, remainingHp);

    }

    @Test
    @DisplayName("Testar att initativet i strid fungerar när PC är snabbare")
    void testFastCombatSpeedInitiative(){

        var human = new Human();
        var elf = new Elf();

        var pc = new Player("test pc", elf);
        var npc = new NonPlayableCharacter("test npc", human);

        assertEquals(pc, initativeOrder(pc, npc));

    }

    @Test
    @DisplayName("Testar att initativet i strid fungerar när PC är långsammare")
    void testSlowCombatSpeedInitiative(){

        var human = new Human();
        var dwarf = new Dwarf();

        var pc = new Player("test pc", dwarf);
        var npc = new NonPlayableCharacter("test npc", human);

        assertEquals(npc, initativeOrder(pc, npc));

    }

    @Test
    @DisplayName("Testar att initativet i strid fungerar när PC är långsammare")
    void testSameCombatSpeedInitiative(){

        var human = new Human();
        var humanTwo = new Human();

        var pc = new Player("test pc", humanTwo);
        var npc = new NonPlayableCharacter("test npc", human);

        assertEquals(npc, initativeOrder(pc, npc));

    }



}
