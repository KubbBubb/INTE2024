import rougelike.NonPlayableCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.Player;
import rougelike.races.Giant;

import static org.junit.jupiter.api.Assertions.*;

public class NonPlayableCharacterClassTest {
    private NonPlayableCharacter npc;

    @BeforeEach
    public void setUp() {
        npc = new NonPlayableCharacter("TestNPC", new Giant());
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


    }
}
