package RogueLikeMavenBuild.src.main.java;

public class Player {
    private String name;
    private int level;
    private int experience;
    private int health;
    private int strength;
    private int speed;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.health = 100;
        this.strength = 10;
        this.speed = 10;
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getExperience() {
        return experience;
    }
    public int getHealth() {
        return health;
    }
    public int getStrength() {
        return strength;
    }
    public int getSpeed() {
        return speed;
    }
}
