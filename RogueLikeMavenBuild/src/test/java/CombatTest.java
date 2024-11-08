import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rougelike.NonPlayableCharacter;
import rougelike.PlayableCharacter;
import rougelike.Position;
import rougelike.races.Dwarf;
import rougelike.races.Elf;
import rougelike.races.Giant;
import rougelike.races.Human;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static rougelike.Combat.fight;
import static rougelike.combat.Action.hit;
import static rougelike.combat.Initiative.initiativeOrder;


public class CombatTest {

    @Test
    @DisplayName("Testar att utdela ett slag. PC mot NPC ")
    void testUsingActionHit(){

        var human = new Human();

        var pc = new PlayableCharacter("test pc", human);
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

        var pc = new PlayableCharacter("test pc", elf);
        var npc = new NonPlayableCharacter("test npc", human,new Position(0,0));

        assertEquals(pc, initiativeOrder(pc, npc).get(0));

    }

    @Test
    @DisplayName("Testar att initativet i strid fungerar när PC är långsammare")
    void testSlowCombatSpeedInitiative(){

        var human = new Human();
        var dwarf = new Dwarf();

        var pc = new PlayableCharacter("test pc", dwarf);
        var npc = new NonPlayableCharacter("test npc", human,new Position(0,0));

        assertEquals(npc, initiativeOrder(pc, npc).get(0));

    }

    @Test
    @DisplayName("Testar att initativet i strid fungerar när PC är långsammare")
    void testSameCombatSpeedInitiative(){

        var human = new Human();
        var humanTwo = new Human();

        var pc = new PlayableCharacter("test pc", humanTwo);
        var npc = new NonPlayableCharacter("test npc", human, new Position(0,0));

        assertEquals(npc, initiativeOrder(pc, npc).get(0));

    }

    @Test
    @DisplayName("Testar att PCs död räknas")
    void testPcDeathCounter(){

        var human = new Human();
        var giant = new Giant();

        var pc = new PlayableCharacter("test pc", human);

        pc.playerDeathReset();

        assertEquals(1, pc.getDeathCounter());


    }

    @Test
    @DisplayName("Testar att PCs död återställer lvl och exp")
    void testPcDeath(){

        var human = new Human();
        var giant = new Giant();

        var pc = new PlayableCharacter("test pc", human);
        var npc = new NonPlayableCharacter("test unga bunga", giant, new Position(0,0));

        pc.setHealth(10);
        pc.setLevel(2);
        pc.setExperience(100);
        fight(pc, npc);



        // Testar att leveln av spelaren återställs till 1 om hp mindre än 0
        assertEquals(1, pc.getLevel());

        // Testar att xpn av spelaren återställs till 0 om hp mindre än 0
        assertEquals(0, pc.getExperience());

    }

    @Test
    @DisplayName("Testar en enkel fight där PC är starkare")
    void testFightPcStrong(){

        var human = new Human();
        var giant = new Giant();

        var pc = new PlayableCharacter("pc", giant);
        var npc = new NonPlayableCharacter("npc", human,new Position(0,0));

        fight(pc, npc);

    }

    @Test
    @DisplayName("Testar en enkel fight där NPC är starkare")
    void testFightNpcStrong(){

        var human = new Human();
        var giant = new Giant();

        var pc = new PlayableCharacter("pc", human);
        var npc = new NonPlayableCharacter("npc", giant, new Position(0,0));

        fight(pc, npc);
        assertTrue(pc.getHealth() >= 0.0);

    }






}
