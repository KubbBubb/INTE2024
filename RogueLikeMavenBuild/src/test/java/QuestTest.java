import org.junit.jupiter.api.Test;
import rougelike.Player;
import rougelike.Quest;
import rougelike.races.Dwarf;

import static org.junit.jupiter.api.Assertions.*;

public class QuestTest {

    //skapar först testklasser - sedan skapar jag kod i klassen Quest som gör att koden kan köras.

    @Test
    public void testQuestStart() {
        Quest quest = new Quest("Defeat the evil boss", "It is time to defeat your enemy, the evil boss.");
        assertEquals("Defeat the evil boss", quest.getName());
        assertEquals("It is time to defeat your enemy, the evil boss.", quest.getDescription());
        assertEquals(30, quest.getRewardExperience());  // Får 30 exp om man klarar questet
        assertFalse(quest.isCompleted());
    }

    @Test
    public void testQuestCompletionGivesExperience() {
        Quest quest = new Quest("Defeat the evil boss", "It is time to defeat your enemy, the evil boss.");
        Player testPlayer = new Player("TestPlayer", new Dwarf());
        ;  // Skapa en Player för att se om den får exp vid avslutat quest
        quest.completeQuest(testPlayer);  // Koppla completeQuest till Player
        assertTrue(quest.isCompleted());
        assertEquals(30, testPlayer.getExperience());  // Spelaren ska få 30 exp
    }

    @Test
    public void testQuestLevelUpOnCompletion() {
        Quest quest = new Quest("Defeat the evil boss", "It is time to defeat your enemy, the evil boss.");
        Player testPlayer = new Player("TestPlayer", new Dwarf());
        testPlayer.addExperience(80);  // Player har 80 exp sedan innan

        quest.completeQuest(testPlayer);
        assertTrue(quest.isCompleted());
        assertEquals(10, testPlayer.getExperience());  // Player ska ha 10 exp över efter att ha gått upp en level
        assertEquals(2, testPlayer.getLevel());  // Player ska nu vara level 2
    }

    @Test
    public void testMultipleQuestsLevelUp() {
        Quest quest1 = new Quest("Defeat the evil boss", "It is time to defeat your enemy, the evil boss.");
        Quest quest2 = new Quest("Investigate the forest", "The forest is dark, you must investigate it.");

        Player testPlayer = new Player("TestPlayer", new Dwarf());
        ;
        testPlayer.addExperience(90);  // Player har 80 exp sedan innan

        quest1.completeQuest(testPlayer);
        quest2.completeQuest(testPlayer);

        // Player ska ha 40 exp kvar efter två quests och ska ha nått level 2
        assertEquals(40, testPlayer.getExperience());
        assertEquals(2, testPlayer.getLevel());
    }
}
