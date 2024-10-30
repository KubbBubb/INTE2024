import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rougelike.GameCharacter;
import rougelike.Player;
import rougelike.races.Dwarf;
import rougelike.races.Elf;
import rougelike.races.Giant;
import rougelike.races.Human;


public class CombatTest {
    @Test
    @DisplayName("Testar att ge slag mot en rougelike.Entity")
    void testUsingActionHit(){


        var dwarf = new Dwarf();
        var elf = new Elf();
        var giant = new Giant();
        var human = new Human();


        var pc = new Player("test pc", dwarf);
        var npc = new GameCharacter("test npc", elf);

        //assertEquals();

    }


}
