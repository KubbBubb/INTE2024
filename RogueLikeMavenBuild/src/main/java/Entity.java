package RogueLikeMavenBuild.src.main.java;
//test
public class Entity {
    private String name;
    private int level;
    private int experience;
    private int health;

    public Entity(String name, Race race) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.health = 100;
        this.race = race;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getHealth() {
        return this.health;
    }

    protected void levelUp() {
        this.level++;
    }


}


