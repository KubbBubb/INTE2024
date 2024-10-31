import rougelike.NonPlayableCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rougelike.races.Giant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
        assertEquals("My strength is " + npc.getStrength() + ".", npc.getReply("What is your strength?"));
    }

    @Test
    public void testUnknownPromptReply() {
        String prompt = "Unknown";

        npc.getReply(prompt);

        assertEquals("I don't quite understand...", npc.getReply(prompt));
    }

    @Test
    public void testHealthPrompt() {
        String prompt = "How are you feeling?";
        assertEquals("I feel strong and healthy!", npc.getReply(prompt));
        npc.setHealth(30);
        assertEquals("I feel a bit weak...", npc.getReply(prompt));
    }

    @Test
    public void testAddRandomDialogue() {
        npc.addRandomDialogue("What's up?", "Nothing much.", "Today is my birthday!", "I'm doing amazing!");

        Set<String> replies = Set.of(
                "Nothing much.",
                "Today is my birthday!",
                "I'm doing amazing!"
        );

        assertTrue(replies.contains(npc.getRandomReply("What's up?")));
    }

    @Test
    public void testGetRandomReplyMultipleOptions() {
        String prompt = "What's the best race?";

        npc.addRandomDialogue(prompt,
                "Elf.",
                "Giants, cause they are strong!",
                "Angel.",
                "My race of course, I am a " + npc.getRace().toString() + ".");

        Set<String> expectedReplies = Set.of(
                "Elf.",
                "Giants, cause they are strong!",
                "Angel.",
                "My race of course, I am a " + npc.getRace().toString() + "."
        );

        HashSet<String> replies = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            String reply = npc.getRandomReply(prompt);
            replies.add(reply);
        }

        assertTrue(replies.size() > 1, "Expected more than one distinct reply.");

        for (String reply : replies) {
            assertTrue(expectedReplies.contains(reply), "Unexpected reply: " + reply);
        }
    }

    @Test
    public void testGetRandomReplyWithNoReplies() {
        assertEquals("I don't really understand...", npc.getRandomReply("Unknown"));
    }
}
