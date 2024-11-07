package rougelike;

public class PlayableCharacter extends GameCharacter {
    private int deathCounter;
    private Position position;

    public PlayableCharacter(String name, Race race) {
        super(name, race);
        this.deathCounter = 0;
        this.position = position;
    }

    @Override
    public double getExperience() {
        return super.getExperience(); // Använder getter från GameCharacter
    }

    public void addExperience(double amount) {
        double currentExperience = getExperience();
        currentExperience += amount; // Lägg till erfarenhet

        // Beräkna hur många levels att gå upp
        int levelsToGain = (int) (currentExperience / 100);
        currentExperience %= 100; // Behåll endast excess exp under 100

        // Öka levels
        for (int i = 0; i < levelsToGain; i++) {
            levelUpOnce();
        }

        setExperience(currentExperience); // Uppdatera experience med hjälp av setter
    }

    public void levelUpOnce() {
        this.setLevel(this.getLevel() + 1);
    }

    @Override
    public void setExperience(double experience) {
        super.setExperience(experience); // Använder setter från GameCharacter
    }

    @Override
    public void setHealth(double health) {
        super.setHealth(health);

        if (health <= 0) {
            playerDeathReset();
        }
    }

    public void setPosition(int x, int y){

        this.position = new Position(x, y);

    }

    public void playerDeathReset() {
        super.setHealth(100 * getRace().getHealthModifier());
        setLevel(1);
        setExperience(0);
        deathCounter++;
    }

    public boolean move(Map map, String direction) {
        Position newPosition = getPosition().move(direction);
        if (!isWithinBounds(map, newPosition)) {
            System.out.println("Out of bounds!");
            return false;
        }
        if (!canAccessTerrain(map, newPosition)) {
            System.out.println("Unable to move on this terrain!");
            return false;
        }
        updatePosition(newPosition);
        return true;
    }

    private boolean isWithinBounds(Map map, Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && y >= 0 && x < map.getWidth() && y < map.getHeight();
    }

    private boolean canAccessTerrain(Map map, Position position) {
        Terrain terrain = map.getTerrain(position.getX(), position.getY());
        return !terrain.isBlocking() && terrain.getAccessType().equals("walk");
    }

    private void updatePosition(Position newPosition) {
        setPosition(newPosition);
        System.out.println("Moved to " + newPosition.getX() + ", " + newPosition.getY());
    }
}
