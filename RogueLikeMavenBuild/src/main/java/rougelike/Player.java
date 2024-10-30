package rougelike;

public class Player extends GameCharacter {
    private double experience;

    public Player(String name, Race race) {
        super(name, race);
    }

    public double getExperience() {
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


