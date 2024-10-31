package rougelike;

public class GameCharacter {

    private String name;
    public int level;

    private double strength;
    private double speed;
    private double experience;
    private double health;
    private double stamina;
    private Race race;

    public GameCharacter(String name, Race race) {
        this.race =  race;
        this.name = name;
        this.experience = 0;
        this.level = 1;
        this.health = 100 * race.getHealthModifier();
        this.strength = 10 * race.getStrengthModifier();
        this.speed = 10 * race.getSpeedModifier();
        this.stamina = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public double getHealth() {
        return this.health;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Race getRace() {
        return race;
    }

    public double getStrength() {
        return strength;
    }

    public double getExperience() {
        return experience;
    }

    public double getStamina() {
        return stamina;
    }

    protected void levelUp() {
        this.level++;
    }



}

