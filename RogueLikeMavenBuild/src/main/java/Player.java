
package RogueLikeMavenBuild.src.main.java;

public class Player extends Entity {
    private int experience;
    private static final int EXPERIENCE_MAX = 100;

    public Player(String name) {
        super(name);
    }

    public int getExperience() {
        return this.experience;
    }


    public void addExperience(int amount) {
        this.experience += amount;
        checkLevelUp();
    }

    private void checkLevelUp() {
        if (this.experience >= EXPERIENCE_MAX) {
            int levelsGained = this.experience / EXPERIENCE_MAX;
            this.experience %= EXPERIENCE_MAX;
            for (int i = 0; i < levelsGained; i++) {
                levelUp();
            }
        }
    }
    @Override
    protected void levelUp() {
        if (this.getLevel() < MAX_LEVEL) { // Endast öka level om vi inte nått maxlevel
            super.levelUp();
        }
    }






}

