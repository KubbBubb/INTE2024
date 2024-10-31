package rougelike;

public class Player extends GameCharacter {
    private double experience;
    private int deathCounter;

     public Player(String name, Race race,Position startPosition) {
        super(name, race,startPosition);
        this.deathCounter = 0;
    }

    public double getExperience() {
        return this.experience;
    }

     public void addExperience(int amount) {
        this.experience += amount;

        while (this.experience >= 100) {
            this.experience -= 100;
            levelUp();
        }
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    public void death(){
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


