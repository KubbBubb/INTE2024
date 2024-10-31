import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rougelike.NonPlayableCharacter;
import rougelike.Player;
import rougelike.Position;
import rougelike.races.Dwarf;
import rougelike.races.Elf;
import rougelike.races.Giant;
import rougelike.races.Human;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rougelike.Combat.fight;
import static rougelike.combat.Action.hit;
import static rougelike.combat.Initiative.initiativeOrder;


public class CombatTest {

    @Test
    @DisplayName("Testar att utdela ett slag. PC mot NPC ")
    void testUsingActionHit(){

        var human = new Human();

        var pc = new Player("test pc", human,new Position(0,0));
        var npc = new NonPlayableCharacter("test npc", human,new Position(0,0));

        double remainingHp =  npc.getHealth() - (npc.getRace().getStrengthModifier() * 10);
        hit(pc, npc);

        assertEquals(90, remainingHp);

    }

    @Test
    @DisplayName("Testar att initativet i strid fungerar när PC är snabbare")
    void testFastCombatSpeedInitiative(){

        var human = new Human();
        var elf = new Elf();

        var pc = new Player("test pc", elf,new Position(0,0));
        var npc = new NonPlayableCharacter("test npc", human,new Position(0,0));

        assertEquals(pc, initiativeOrder(pc, npc));

    }

    @Test
    @DisplayName("Testar att initativet i strid fungerar när PC är långsammare")
    void testSlowCombatSpeedInitiative(){

        var human = new Human();
        var dwarf = new Dwarf();

        var pc = new Player("test pc", dwarf,new Position(1,1));
        var npc = new NonPlayableCharacter("test npc", human,new Position(0,0));

        assertEquals(npc, initiativeOrder(pc, npc));

    }

    @Test
    @DisplayName("Testar att initativet i strid fungerar när PC är långsammare")
    void testSameCombatSpeedInitiative(){

        var human = new Human();
        var humanTwo = new Human();

        var pc = new Player("test pc", humanTwo,new Position(1,1));
        var npc = new NonPlayableCharacter("test npc", human,new Position(0,0));

        assertEquals(npc, initiativeOrder(pc, npc));

    }

    @Test
    @DisplayName("Testar att PC dör")
    void testPcDeath(){

        var human = new Human();
        var giant = new Giant();

        var pc = new Player("test pc", human,new Position(1,1));
        var npc = new NonPlayableCharacter("test unga bunga", giant,new Position(0,0));

        pc.setHealth(10);
        pc.setLevel(2);
        pc.setExperience(100);
        hit(npc, pc);

        assertEquals(-10, pc.getHealth());
        assertEquals(1, pc.getLevel());
        assertEquals(0, pc.getExperience());

    }

    @Test
    @DisplayName("Testar en enkel fight")
    void testFight(){

        var human = new Human();
        var giant = new Giant();

        var pc = new Player("pc", giant,new Position(1,1));
        var npc = new NonPlayableCharacter("npc", human,new Position(0,0));

        fight(pc, npc);

    }




}
