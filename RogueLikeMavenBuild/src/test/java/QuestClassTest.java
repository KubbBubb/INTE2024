import org.junit.jupiter.api.Test;
import rougelike.PlayableCharacter;
import rougelike.Position;
import rougelike.Quest;
import rougelike.races.Dwarf;

import static org.junit.jupiter.api.Assertions.*;

public class QuestClassTest {

    //skapar först testklasser - sedan skapar jag kod i klassen Quest som gör att koden kan köras steg för steg.

    // Testar att starta ett quest
    @Test
    public void testQuestStart() {
        Quest quest = new Quest("Defeat the evil boss", "It is time to defeat your enemy, the evil boss.", 1);
        assertEquals("Defeat the evil boss", quest.getName());
        assertEquals("It is time to defeat your enemy, the evil boss.", quest.getDescription());
        assertEquals(30, quest.getRewardExperience());  // Får 30 exp om man klarar questet
        assertFalse(quest.isCompleted());
    }

    // Testar att man får exp när man slutför ett quest
    @Test
    public void testQuestCompletionGivesExperience() {
        Quest quest = new Quest("Defeat the evil boss", "It is time to defeat your enemy, the evil boss.", 1);
        PlayableCharacter testPlayer = new PlayableCharacter("TestPlayer", new Dwarf(),new Position(0,0));

        // Skapa en Player för att se om den får exp vid avslutat quest
        quest.completeQuest(testPlayer);  // Koppla completeQuest till Player
        assertTrue(quest.isCompleted());
        assertEquals(30, testPlayer.getExperience());  // Spelaren ska få 30 exp
    }

    // Testar att man levlar upp korrekt när man slutför ett quest
    @Test
    public void testQuestLevelUpOnCompletion() {
        Quest quest = new Quest("Defeat the evil boss", "It is time to defeat your enemy, the evil boss.", 1);
        PlayableCharacter testPlayer = new PlayableCharacter("TestPlayer", new Dwarf(),new Position(0,0));
        testPlayer.addExperience(80);  // Player har 80 exp sedan innan

        quest.completeQuest(testPlayer);
        assertTrue(quest.isCompleted());
        assertEquals(10, testPlayer.getExperience());  // Player ska ha 10 exp över efter att ha gått upp en level
        assertEquals(2, testPlayer.getLevel());  // Player ska nu vara level 2
    }

    // Testar att man levlar upp korrekt när man slutför flera quests
    @Test
    public void testMultipleQuestsLevelUp() {
        Quest quest1 = new Quest("Defeat the evil boss", "It is time to defeat your enemy, the evil boss.",1);
        Quest quest2 = new Quest("Investigate the forest", "The forest is dark, you must investigate it.", 1);

        PlayableCharacter testPlayer = new PlayableCharacter("TestPlayer", new Dwarf(),new Position(0,0));

        testPlayer.addExperience(90);  // Player har 80 exp sedan innan

        quest1.completeQuest(testPlayer);
        quest2.completeQuest(testPlayer);

        // Player ska ha 50 exp kvar efter två quests och ska ha nått level 2
        assertEquals(50, testPlayer.getExperience());
        assertEquals(2, testPlayer.getLevel());
    }

    // Testar att man inte kan completa samma quest fler gånger
    @Test
    public void testSameQuestCannotBeCompletedTwice() {
        Quest quest = new Quest("Defeat the evil boss", "It is time to defeat your enemy, the evil boss.", 1);
        PlayableCharacter testPlayer = new PlayableCharacter("TestPlayer", new Dwarf(),new Position(0,0));

        quest.completeQuest(testPlayer);  // Första avslutet av questet
        quest.completeQuest(testPlayer);  // Andra avslutet av questet (ska inte ge mer experience)

        assertTrue(quest.isCompleted());
        assertEquals(30, testPlayer.getExperience());
    }

    // Testar att completa ett quest som har ett levelkrav
    @Test
    public void testQuestCompletionWithLevelRequirement() {
        final int REQUIRED_LEVEL = 5;

        Quest quest = new Quest("Talk to the Shaman who can help you develop your skills further",
                "The Shaman will only assist characters at level 5 or higher.", 5);
        quest.setLevelRequirement(REQUIRED_LEVEL);  // Sätt levelkrav

        PlayableCharacter testPlayer = new PlayableCharacter("TestPlayer", new Dwarf(),new Position(0,0));
        testPlayer.setLevel(REQUIRED_LEVEL - 1);  // Sätt playerlevel under kravet

        quest.completeQuest(testPlayer);  // Ska ej kunna slutföra

        assertFalse(quest.isCompleted());
        assertEquals(0, testPlayer.getExperience());  // Ingen exp ska ges om questet ej kan slutföras
    }

    // Testar att ett quest kan resettas
    @Test
    public void testResetQuest() {
        Quest quest = new Quest("Defeat the evil boss", "It's time to defeat your enemy, the evil boss.", 1);
        PlayableCharacter testPlayer = new PlayableCharacter("TestPlayer", new Dwarf(),new Position(0,0));

        quest.completeQuest(testPlayer);
        assertTrue(quest.isCompleted());

        quest.resetQuest();
        assertFalse(quest.isCompleted());
    }

    // Testar att ett quest markeras som misslyckat korrekt
    @Test
    public void testQuestFailureStatus() {
        Quest quest = new Quest("Defeat the evil boss", "It's time to defeat your enemy, the evil boss.", 1);
        PlayableCharacter testPlayer = new PlayableCharacter("TestPlayer", new Dwarf(),new Position(0,0));

        quest.failQuest(testPlayer);  // Failar questet

        // Kontrollerar att questet är markerat som failed
        assertTrue(quest.isFailed());
        assertFalse(quest.isCompleted());

        // Försöker slutföra ett misslyckat quest - ska inte gå
        quest.completeQuest(testPlayer);
        assertFalse(quest.isCompleted());
    }

    // Testar att man tappar exp som planerat när man failar ett quest
    @Test
    public void testExperienceLossOnQuestFailure() {
        Quest quest = new Quest("Defeat the evil boss", "It's time to defeat your enemy, the evil boss.", 1);
        PlayableCharacter testPlayer = new PlayableCharacter("TestPlayer", new Dwarf(),new Position(0,0));
        testPlayer.addExperience(50);  // Player startar med 50 exp

        quest.failQuest(testPlayer);  // Misslyckas med questet

        // Kontrollera att spelaren har förlorat 20 exp vid failat quest
        assertEquals(30, testPlayer.getExperience());  // Player ska ha tappat 20 exp
    }


}
