package RogueLikeMavenBuild.src.main.java;

public abstract class Magic {

    private final String name;
    private int effect;
    private int cost; //eventuell resurs hos spelarkaraktären??
    private int missingHitPoints;


    public Magic(String name, int effect, int missingHitPoints, int cost){

        this.name = name;
        this.missingHitPoints = missingHitPoints;
        this.effect = effect;
        this.cost =  cost;

    }

    public int getEffect() {
        return effect;
    }

    public int getMissingHitPoints() {
        return missingHitPoints;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
