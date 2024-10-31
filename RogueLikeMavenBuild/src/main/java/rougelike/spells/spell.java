package rougelike.spells;
import rougelike.Magic;

public class spell extends Magic {

    private double multiplier;

    public spell(String name, int effect, int missingHitPoints, int cost) {
        super(name, effect, missingHitPoints, cost);
    }

    public double getMultiplier() {
        return multiplier;
    }

}
