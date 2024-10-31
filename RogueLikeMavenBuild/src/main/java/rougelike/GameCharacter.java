package rougelike;

public abstract class GameCharacter {

    private String name;
    private int level;
    private double strength;
    private double speed;
    private double experience;
    private double health;
    private double stamina;
    private double magic;
    private Race race;
    private SpellBook spellBook;
    private Armour armour;
    private Profession profession;

    public GameCharacter(String name, Race race) {
        this.race =  race;
        this.name = name;
        this.experience = 0;
        this.level = 1;
        this.health = 100 * race.getHealthModifier();
        this.strength = 10 * race.getStrengthModifier();
        this.speed = 10 * race.getSpeedModifier();
        this.stamina = 100 * race.getStaminaModifier();
        this.magic = 10 * race.getMagicModifier();
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public double getHealth() {
        return this.health;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Race getRace() {
        return race;
    }

    public double getStrength() {
        return strength;
    }

    public double getExperience() {
        return experience;
    }

    public double getStamina() {
        return stamina;
    }

    public double getMagic() {
        return magic;
    }

    public void setLevel(int newLevel) {
        this.level = newLevel;
    }

    protected void levelUp() {
        this.level++;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
        this.health = health * profession.getHealthModifier();
        this.strength = strength * profession.getStrengthModifier();
        this.magic = magic * profession.getMagicModifier();
    }

    public Profession getProfession() {
        if (this.profession == null) {
            throw new IllegalStateException("Character has no profession.");
        }
        return this.profession;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
        this.health = health * armour.getHealthModifier();
        this.strength = strength * armour.getStrengthModifier();
        this.magic = magic * armour.getMagicModifier();
        this.stamina = stamina * armour.getStaminaModifier();
        this.speed = speed * armour.getSpeedModifier();
    }

    public Armour getArmour() {
        if (this.armour == null) {
            throw new IllegalStateException("Character has no armour.");
        }
        return this.armour;
    }
}

