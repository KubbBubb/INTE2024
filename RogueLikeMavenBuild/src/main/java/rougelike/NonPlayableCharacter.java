package rougelike;

import java.util.*;

/**
 * Represents a non-playable character (NPC) that can respond to specific dialogue prompts,
 * including both fixed and random responses, and has a set position in the game world.
 */
public class NonPlayableCharacter extends GameCharacter {
    // Default prompts that every NPC should have.
    private static final String STRENGTH_PROMPT = "What is your strength?";
    private static final String SPEED_PROMPT = "What is your speed?";
    private static final String STAMINA_PROMPT = "What is your stamina?";
    private static final String HEALTH_PROMPT = "What is your health?";
    private static final String LEVEL_PROMPT = "What is your level?";
    private static final String FEELING_PROMPT = "How are you feeling?";

    // Default reply if a prompt is not found in a dialogue map.
    private static final String DEFAULT_REPLY = "I don't quite understand...";

    // Hashmap for storing the dialogues for each NPC.
    private final HashMap<String, String> dialogues;

    // Hashmap for storing the dialogues for each NPC which have a random reply from a list of replies.
    private final HashMap<String, List<String>> randomDialogues = new HashMap<>();

    // Position variable to store the NPCs standing position.
    private final Position position;

    /**
     * Initializes the NPC with a name, race, position and some default dialogues.
     */
    public NonPlayableCharacter(String name, Race race, Position standingPosition) {
        super(name, race);
        this.dialogues = new HashMap<>();

        if (standingPosition == null) {
            throw new IllegalArgumentException("Standing position must not be null");
        }

        this.position = standingPosition;

        addDialogue(STRENGTH_PROMPT, "My strength is " + getStrength() + ".");
        addDialogue(SPEED_PROMPT, "My speed is " + getSpeed() + ".");
        addDialogue(STAMINA_PROMPT, "My stamina is " + getStamina() + ".");
        addDialogue(HEALTH_PROMPT, "My health is " + getHealth() + ".");
        addDialogue(LEVEL_PROMPT, "I am level " + getLevel() + ".");
    }

    /**
     * @return A response based on the NPCs health status.
     */
    private String getHealthResponse() {
        if (getHealth() > 50) {
            return "I feel strong and healthy!";
        }
        return "I feel a bit weak...";
    }

    /**
     * @return The dialogue map.
     */
    public HashMap<String, String> getDialogues() {
        return dialogues;
    }

    /**
     * Adds a dialogue to the dialogues map with input validation.
     * Ensures that both prompt and reply are non-null
     * Throws IllegalArgumentException if any of the conditions are violated.
     * @param prompt The prompt to reply to (must be non-null).
     * @param reply The reply to the prompt (must be non-null).
     */
    public void addDialogue(String prompt, String reply) {
        if (prompt == null || reply == null) {
            throw new IllegalArgumentException("Prompt and reply must not be null");
        }
        dialogues.put(prompt, reply);
    }

    /**
     * @param prompt The prompt used for getting a reply.
     * @return The prompt or if the prompt does not exist in the map return a default value.
     */
    public String getReply(String prompt) {
        if (FEELING_PROMPT.equals(prompt)) {
            return getHealthResponse();
        }
        return dialogues.getOrDefault(prompt, DEFAULT_REPLY);
    }

    /**
     * Adds a random dialogue entry to the randomDialogues map with input validation.
     * Ensures that both the prompt and the replies are non-null.
     * If the prompt already exists, new replies are added to the existing list.
     * @param prompt The prompt to reply to (must be a non-null String).
     * @param replies The list of replies to the prompt (must contain non-null Strings).
     * @throws IllegalArgumentException if prompt is null.
     */
    public void addRandomDialogue(String prompt, String... replies) {
        if (prompt == null) {
            throw new IllegalArgumentException("Prompt must not be null");
        }
        if (replies == null || Arrays.stream(replies).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Replies must be non-null Strings");
        }
        List<String> currentReplies = randomDialogues.computeIfAbsent(prompt, k -> new ArrayList<>());
        for (String reply : replies) {
            if (!currentReplies.contains(reply)) {
                currentReplies.add(reply);
            }
        }
    }

    /**
     * @param prompt The prompt used for getting a reply.
     * @return The reply at random if it exists and the reply list isn't empty otherwise a default value.
     */
    public String getRandomReply(String prompt) {
        List<String> replies = randomDialogues.get(prompt);
        return (replies != null && !replies.isEmpty()) ? replies.get(new Random().nextInt(replies.size()))
                : DEFAULT_REPLY;
    }

    /**
     * @return The position in which the NPC is standing.
     */
    public Position getStandingPosition() {
        return this.position;
    }
}