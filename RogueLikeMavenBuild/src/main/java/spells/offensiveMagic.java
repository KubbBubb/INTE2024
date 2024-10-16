package RogueLikeMavenBuild.src.main.java.spells;

import RogueLikeMavenBuild.src.main.java.Magic;

public class offensiveMagic extends Magic {

    private double multiplier;

    public offensiveMagic(String name, int effect, int missingHitPoints, int cost) {
        super(name, effect, missingHitPoints, cost);
    }

    public double getMultiplier() {
        return multiplier;
    }

    //testar


}
