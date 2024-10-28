package RogueLikeMavenBuild.src.main.java;

public class Player extends Character {
    private int experience;

    public Player(String name) {
        super(name);
    }

    public int getExperience() {
        return this.experience;
    }

    public void addExperience(void amount) {
        this.experience += amount;

        while (this.experience >= 100) {
            this.experience -= 100;
            levelUp();
        }
    }

    private void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }

    private void setLevel(int newLevel) {
        super.level = newLevel;
    }
}


}