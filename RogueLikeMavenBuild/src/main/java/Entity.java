package RogueLikeMavenBuild.src.main.java;


public class Entity {

    private String name;
    public int level;

    private int strength;
    private int speed;
    private int experience;
    private double health;
    private Race race;

    public Entity(String name, Race race) {
        this.race =  race;
        this.name = name;
        this.experience = 0;
        this.level = 1;
        this.health = 100 * race.getHealth();
        this.strength = 10 * (int)race.getStrength();
        this.speed = 10 * (int)race.getSpeed();
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

    public void setHealth(double health) {
        this.health = health;
    }

    public Race getRace() {
        return race;
    }

    public int getStrength() {
        return strength;
    }

    public int getExperience() {
        return experience;
    }

    protected void levelUp() {
        this.level++;
    }

}

