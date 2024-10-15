public abstract class Race {
    private final String name;
    private final int healthModifier;
    private final int strengthModifier;
    private final int speedModifier;

    //

    public Race(String name, int healthModifier, int strengthModifier, int speedModifier) {
        this.name = name;
        this.healthModifier = healthModifier;
        this.strengthModifier = strengthModifier;
        this.speedModifier = speedModifier;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return healthModifier;
    }

    public int getStrength() {
        return strengthModifier;
    }

    public int getSpeed() {
        return speedModifier;
    }
}

/*
Race examples:

Human
Elf
Giant
Dwarf
Gnome

*/