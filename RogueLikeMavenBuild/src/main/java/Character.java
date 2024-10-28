package RogueLikeMavenBuild.src.main.java;

public class Character {
    private String name;
    private int level;
    private int health;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.health = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

