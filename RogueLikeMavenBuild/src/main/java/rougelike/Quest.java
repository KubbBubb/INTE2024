package rougelike;

public class Quest {
    private final String name;
    private final String description;
    private final int rewardExperience = 30;  // Fast belöning på 30 exp per quest
    private boolean isCompleted;
    private int levelRequirement = 1;
    private boolean isFailed;

    public Quest(String name, String description, int levelRequirement) {
        this.name = name;
        this.description = description;
        this.isCompleted = false;
        this.isFailed = false;
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

    public boolean isFailed() {
        return isFailed;
    }

    public void resetQuest() {
        isCompleted = false;
        isFailed = false;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public void completeQuest(PlayableCharacter player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        // Tillåter bara att lämna in questet om det varken är misslyckat eller redan slutfört samt om playerns level är tillräcklig
        if (!isCompleted && !isFailed && player.getLevel() >= levelRequirement) {
            player.addExperience(rewardExperience);
            isCompleted = true;
        }
    }

    public void failQuest(PlayableCharacter player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        if (!isCompleted && !isFailed) {
            double newExperience = player.getExperience() - 20;
            // Se till att exp inte blir negativ
            if (newExperience < 0) {
                newExperience = 0;
            }
            player.setExperience(newExperience); // Uppdatera exp
            isFailed = true;
        }
    }

}
