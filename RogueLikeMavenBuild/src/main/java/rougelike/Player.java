package rougelike;

public class Player extends GameCharacter {
    private double experience;
    private int deathCounter;

    public Player(String name, Race race) {
        super(name, race);
        this.deathCounter = 0;
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


    public void setExperience(int experience){
        this.experience = experience;
    }

    public void death(){
        setLevel(1);
        setExperience(0);
        deathCounter++;
    }

}


