package RogueLikeMavenBuild.src.main.java;

public class Player extends Entity {
    private int experience;
    private static final int EXPERIENCE_MAX = 100;

    public Player(String name, Race race) {
        super(name, race);
    }

    public int getExperience() {
        return this.experience;
    }

    public void addExperience(int amount) {
        this.experience += amount;

        while (this.experience >= 100) {
            this.experience -= 100;
            levelUp();
        }
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }

    public void setLevel(int newLevel) {
        super.level = newLevel;
    }
}


