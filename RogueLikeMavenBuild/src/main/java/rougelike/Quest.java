package rougelike;

public class Quest {
    private String name;
    private String description;
    private final int rewardExperience = 30;  // Fast belöning på 30 exp per quest
    private boolean isCompleted;
    private int levelRequirement = 1;

    public Quest(String name, String description, int levelRequirement) {
        this.name = name;
        this.description = description;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRewardExperience() {
        return rewardExperience;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public void completeQuest(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        if (!isCompleted && player.getLevel() >= levelRequirement) {
            player.addExperience(rewardExperience);
            isCompleted = true;
        }
    }

    public void resetQuest() {
        isCompleted = false;
    }
}
