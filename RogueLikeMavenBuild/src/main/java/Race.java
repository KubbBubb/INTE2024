public abstract class Race {
    private final double healthModifier;
    private final double strengthModifier;
    private final double speedModifier;

    public Race(double healthModifier, double strengthModifier, double speedModifier) {
        this.healthModifier = healthModifier;
        this.strengthModifier = strengthModifier;
        this.speedModifier = speedModifier;
    }

    public double getHealth() {
        return healthModifier;
    }

    public double getStrength() {
        return strengthModifier;
    }

    public double getSpeed() {
        return speedModifier;
    }
}

/*
Race examples:

Human
Elf
Giant
Dwarf

*/