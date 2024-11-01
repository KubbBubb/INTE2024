package rougelike;

public abstract class Profession {
    private final double healthModifier;
    private final double strengthModifier;
    private final double magicModifier;

    public Profession(double healthModifier, double strengthModifier, double magicModifier) {
        this.healthModifier = healthModifier;
        this.strengthModifier = strengthModifier;
        this.magicModifier = magicModifier;
    }

    public double getHealthModifier() {
        return healthModifier;
    }

    public double getStrengthModifier() {
        return strengthModifier;
    }

    public double getMagicModifier() {
        return magicModifier;
    }

}

/*
rougelike.Profession examples:

Swordsman
Archer
Assassin
Wizard
Merchant

 */