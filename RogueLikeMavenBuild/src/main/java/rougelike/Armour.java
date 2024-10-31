package rougelike;

public abstract class Armour {
    private final double healthModifier;
    private final double staminaModifier;
    private final double speedModifier;
    private final double strengthModifier;
    private final double magicModifier;

    public Armour(double healthModifier, double staminaModifier, double speedModifier, double strengthModifier, double magicModifier) {
        this.healthModifier = healthModifier;
        this.staminaModifier = staminaModifier;
        this.speedModifier = speedModifier;
        this.strengthModifier = strengthModifier;
        this.magicModifier = magicModifier;
    }

    public double getHealthModifier() {
        return healthModifier;
    }

    public double getStaminaModifier() {
        return staminaModifier;
    }

    public double getSpeedModifier() {
        return speedModifier;
    }

    public double getStrengthModifier() {
        return strengthModifier;
    }

    public double getMagicModifier() {
        return magicModifier;
    }

}
