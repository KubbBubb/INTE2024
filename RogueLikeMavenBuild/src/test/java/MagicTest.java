import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rougelike.*;
import rougelike.races.Angel;
import rougelike.races.Human;

import static org.junit.jupiter.api.Assertions.*;
import static rougelike.combat.Action.castSpell;

public class MagicTest {

    @Test
    @DisplayName("Testar att hitta en spell i spellbook")
    void testFindSpell(){

        var human = new Human();
        var pc = new PlayableCharacter("pc", human);
        var fireBolt = new Magic("FireBolt", true);
        var spellBook = new SpellBook();

        pc.setSpellBook(spellBook);
        pc.getSpellBook().addMagic(fireBolt);
        assertEquals(fireBolt, pc.getSpellBook().findMagic("FireBolt"));

    }

    @Test
    @DisplayName("Testar att ta bort en spell i spellbook")
    void testRemoveSpell(){

        var human = new Human();
        var pc = new PlayableCharacter("pc", human);
        var fireBolt = new Magic("FireBolt", true);
        var spellBook = new SpellBook();

        pc.setSpellBook(spellBook);
        pc.getSpellBook().addMagic(fireBolt);
        pc.getSpellBook().removeMagic("FireBolt");
        assertFalse(pc.getSpellBook().getMagics().contains(fireBolt));

    }

    @Test
    @DisplayName("Testar att använda offensiv magi")
    void testCastOffensiveSpell(){

        var angel = new Angel();
        var human = new Human();

        var pc = new PlayableCharacter("pc", angel);
        var npc = new NonPlayableCharacter("npc", human, new Position(0,0));
        var fireBolt = new Magic("FireBolt", true);
        var spellBook = new SpellBook();

        pc.setSpellBook(spellBook);
        pc.getSpellBook().addMagic(fireBolt);

        castSpell(pc, npc, "FireBolt");

        assertNotEquals(100, npc.getHealth(), 0.0);

    }

    @Test
    @DisplayName("Testar att använda defensiv magi")
    void testCastDefensiveSpell(){

        var angel = new Angel();
        var human = new Human();

        var pc = new PlayableCharacter("pc", angel);
        var npc = new NonPlayableCharacter("npc", human, new Position(0,0));
        var fireBolt = new Magic("FireBolt", false);
        var spellBook = new SpellBook();

        pc.setSpellBook(spellBook);
        pc.getSpellBook().addMagic(fireBolt);

        castSpell(pc, npc, "FireBolt");

        assertTrue(pc.getHealth() > 100);

    }



}
