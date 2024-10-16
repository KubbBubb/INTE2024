package RogueLikeMavenBuild.src.main.java;

public class Terrain {
    private String name;
    private int cost;
    private boolean isUsable;
    public Terrain(String name, int cost, boolean isUsable) {
        if (cost<0){
            throw new IllegalArgumentException("Cost must be greater than zero");
        }
        this.name = name;
        this.cost = cost;
        this.isUsable = isUsable;
    }
    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }

    public boolean isUsable() {
        return isUsable;
    }
}