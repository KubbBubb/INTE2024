package rougelike;

public class Quest {
    private String name;
    private String description;
    private final int rewardExperience = 30;  // Fast belöning på 30 exp per quest
    private boolean isCompleted;

    public Quest(String name, String description) {
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

    public void completeQuest(Player player) {
        if (!isCompleted) {
            player.addExperience(rewardExperience);
            isCompleted = true;
        }
    }
}
