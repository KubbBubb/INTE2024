package rougelike;

import java.util.*;

public class NonPlayableCharacter extends GameCharacter {
    private final HashMap<String, String> dialogues;
    private final HashMap<String, List<String>> randomDialogues = new HashMap<>();
    private final Position position;

    public NonPlayableCharacter(String name, Race race,Position position) {
        super(name, race);
        this.dialogues = new HashMap<>();
        this.position = position;

        addDialogue("What is your strength?", "My strength is " + getStrength() + ".");
        addDialogue("What is your speed?", "My speed is " + getSpeed() + ".");
        addDialogue("What is your stamina?", "My stamina is " + getStamina() + ".");
        addDialogue("What is your health?", "My health is " + getHealth() + ".");
        addDialogue("What is your level?", "I am level " + getLevel() + ".");
    }

    private String getHealthResponse() {
        if (getHealth() > 50) {
            return "I feel strong and healthy!";
        }
        return "I feel a bit weak...";
    }

    public HashMap<String, String> getDialogues() {
        return dialogues;
    }

    public void addDialogue(String prompt, String reply) {
        dialogues.put(prompt, reply);
    }

    public String getReply(String prompt) {
        if (prompt.equals("How are you feeling?")) {
            return getHealthResponse();
        }
        return dialogues.getOrDefault(prompt, "I don't quite understand...");
    }

    public void addRandomDialogue(String prompt, String... replies) {
        randomDialogues.putIfAbsent(prompt, new ArrayList<>());
        randomDialogues.get(prompt).addAll(Arrays.asList(replies));
    }

    public String getRandomReply(String prompt) {
        List<String> replies = randomDialogues.get(prompt);
        return (replies != null && !replies.isEmpty()) ? replies.get(new Random().nextInt(replies.size())) : "I don't really understand...";
    }


}
