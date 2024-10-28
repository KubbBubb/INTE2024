package RogueLikeMavenBuild.src.test.java;
import RogueLikeMavenBuild.src.main.java.Entity;
import RogueLikeMavenBuild.src.main.java.Player;
import RogueLikeMavenBuild.src.main.java.Race;
import RogueLikeMavenBuild.src.main.java.races.Dwarf;
import RogueLikeMavenBuild.src.main.java.races.Elf;
import RogueLikeMavenBuild.src.main.java.races.Giant;
import RogueLikeMavenBuild.src.main.java.races.Human;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class CombatTest {

    @Test
    @DisplayName("Testar att ge slag mot en Entity")
    void testUsingActionHit(){

        ArrayList<Race> raceArrayList = new ArrayList<>();

        var dwarf = new Dwarf();
        var elf = new Elf();
        var giant = new Giant();
        var human = new Human();

        raceArrayList.add(dwarf);
        raceArrayList.add(elf);
        raceArrayList.add(giant);
        raceArrayList.add(human);



        var pc = new Player("test pc", dwarf);
        var npc = new Entity("test npc", elf);

        //assertEquals();

    }


}
