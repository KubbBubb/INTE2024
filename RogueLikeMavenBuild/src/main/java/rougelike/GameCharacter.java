package rougelike;

public abstract class GameCharacter {

    // Konstanter för hårdkodade värden
    private static final double BASE_HEALTH = 100.0;
    private static final double BASE_STRENGTH = 10.0;
    private static final double BASE_SPEED = 10.0;
    private static final double BASE_STAMINA = 100.0;
    private static final double BASE_MAGIC = 10.0;

    private final String name;
    private int level;
    private double strength;
    private double speed;
    private double experience;
    private double health;
    private double stamina;
    private double magic;
    private final Race race;
    private SpellBook spellBook;
    private Profession profession;
    private Position position;

    // Konstruktor
    public GameCharacter(String name, Race race) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (race == null) {
            throw new IllegalArgumentException("Race cannot be null.");
        }

        this.name = name;
        this.race = race;
        this.experience = 0;
        this.level = 1;
        this.health = BASE_HEALTH * race.getHealthModifier();
        this.strength = BASE_STRENGTH * race.getStrengthModifier();
        this.speed = BASE_SPEED * race.getSpeedModifier();
        this.stamina = BASE_STAMINA * race.getStaminaModifier();
        this.magic = BASE_MAGIC * race.getMagicModifier();
        this.position = new Position(0, 0); // Se till att positionen är initialiserad
    }

    // Getter-metoder

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

    public Profession getProfession() {
        if (this.profession == null) {
            throw new IllegalStateException("Character has no profession.");
        }
        return this.profession;
    }

    public Position getPosition() {
        return position;
    }

    public SpellBook getSpellBook() {
        return spellBook;
    }



    // Setter-metoder med validering

    public void setHealth(double health) {
        this.health = health;
    }

    public void setLevel(int newLevel) {
        if (newLevel < 1) {
            throw new IllegalArgumentException("Level must be at least 1.");
        }
        this.level = newLevel;
    }

    public void setSpellBook(SpellBook spellBook) {
        this.spellBook = spellBook;
    }

    public void setPosition(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null.");
        }
        this.position = position;
    }

    public void setPosition(int x, int y){
        this.position = new Position(x, y);
    }

    // Sätter profession och ändrar variablerna beroende på profession
    public void setProfession(Profession profession) {
        if (profession == null) {
            throw new IllegalArgumentException("Profession cannot be null.");
        }
        this.profession = profession;
        this.health = health * profession.getHealthModifier();
        this.strength = strength * profession.getStrengthModifier();
        this.magic = magic * profession.getMagicModifier();
    }

    public void setExperience(double experience) {
        if (experience < 0) {
            throw new IllegalArgumentException("Experience cannot be negative.");
        }
        this.experience = experience;
    }

    // Sätter armour och ändrar variablerna beroende på vilket armour det är
    public void setArmour(Armour armour) {
        if (armour == null) {
            throw new IllegalArgumentException("Armour cannot be null.");
        }
        this.health = health * armour.getHealthModifier();
        this.strength = strength * armour.getStrengthModifier();
        this.magic = magic * armour.getMagicModifier();
        this.stamina = stamina * armour.getStaminaModifier();
        this.speed = speed * armour.getSpeedModifier();
    }
}