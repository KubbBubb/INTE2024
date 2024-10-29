package rougelike;

public abstract class Race {
    private final double healthModifier;
    private final double staminaModifier;
    private final double speedModifier;
    private final double strengthModifier;
    private final double magicModifier;

    public Race(double healthModifier, double staminaModifier, double speedModifier, double strengthModifier, double magicModifier) {
        this.healthModifier = healthModifier;
        this.staminaModifier = staminaModifier;
        this.speedModifier = speedModifier;
        this.strengthModifier = strengthModifier;
        this.magicModifier = magicModifier;
    }

    public double getHealth() {
        return healthModifier;
    }

    public double getStamina() {
        return staminaModifier;
    }

    public double getSpeed() {
        return speedModifier;
    }

    public double getStrength() {
        return strengthModifier;
    }

    public double getMagicModifier() {
        return magicModifier;
    }
}

/*
rougelike.Race examples:

Human
Elf
Dwarf
Giant
Angel

*/