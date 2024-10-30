package rougelike;

import java.util.HashMap;

public class NonPlayableCharacter extends GameCharacter {
    private HashMap<String, String> dialogues;

    public NonPlayableCharacter(String name, Race race) {
        super(name, race);
        this.dialogues = new HashMap<>();

        addDialogue("What is your strength?", "My strength is " + getStrength() + ".");
        addDialogue("What is your speed?", "My speed is " + getSpeed() + ".");
        addDialogue("What is your stamina?", "My stamina is " + getStamina() + ".");
        addDialogue("What is your health?", "My health is " + getHealth() + ".");
        addDialogue("What is your level?", "I am level " + getLevel() + ".");
    }

    public void addDialogue(String prompt, String reply) {
        dialogues.put(prompt, reply);
    }

    public String getReply(String prompt) {
        return dialogues.getOrDefault(prompt, "I don't quite understand...");
    }
}
