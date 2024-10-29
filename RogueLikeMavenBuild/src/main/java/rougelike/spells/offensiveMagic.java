package rougelike.spells;
import rougelike.Magic;

public class offensiveMagic extends Magic {

    private double multiplier;

    public offensiveMagic(String name, int effect, int missingHitPoints, int cost) {
        super(name, effect, missingHitPoints, cost);
    }

    public double getMultiplier() {
        return multiplier;
    }

}
