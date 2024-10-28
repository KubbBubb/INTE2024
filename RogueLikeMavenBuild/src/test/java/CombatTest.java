package RogueLikeMavenBuild.src.test.java;
import RogueLikeMavenBuild.src.main.java.Character;
import RogueLikeMavenBuild.src.main.java.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombatTest {

    @Test
    @DisplayName("Testar att ge slag mot en NPC")
    void testUsingActionHit(){

        var pc = new Player("test pc");
        var npc = new Character("test npc");

        //assertEquals();

    }


}
