public abstract class Race {
    private final String name;
    private final int health;
    private final int strength;
    private final int speed;

    //

    public Race(String name, int health, int strength, int speed) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
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