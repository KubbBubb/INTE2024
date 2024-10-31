import rougelike.NonPlayableCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.races.Giant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class NonPlayableCharacterClassTest {
    private NonPlayableCharacter npc;

    @BeforeEach
    public void setUp() {
        npc = new NonPlayableCharacter("TestNPC", new Giant());
    }

    @Test
    public void testGetDialogues() {
        npc.addDialogue("Hi!", "Hey!");

        HashMap<String, String> test = npc.getDialogues();

        HashSet<String> expectedKeys = new HashSet<>(Arrays.asList(
                "Hi!", "What is your level?", "What is your strength?", "What is your stamina?", "What is your speed?", "What is your health?"
        ));

        assertEquals(expectedKeys, test.keySet());
    }

    @Test
    public void testGetReply() {
        String prompt = "Greetings!";
        String reply = "Howdy, my friend!";

        npc.addDialogue(prompt, reply);

        assertEquals("Howdy, my friend!", npc.getReply(prompt));
    }

    @Test
    public void testUnknownPromptReply() {
        String prompt = "Unknown";

        npc.getReply(prompt);

        assertEquals("I don't quite understand...", npc.getReply(prompt));
    }
}
