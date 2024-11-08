package rougelike;

public class PlayableCharacter extends GameCharacter {
    private int deathCounter;  //räknar mängden resets för spelaren
    private Position position; //spelarens geografiska position

    public PlayableCharacter(String name, Race race) {
        super(name, race);
        this.deathCounter = 0;
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

        if (getExperience() + experience > Integer.MAX_VALUE){
            throw new IllegalArgumentException("Overflow");
        }else{
            super.setExperience(experience);
        }
    }

    @Override
    public void setHealth(double health) {

        if (getHealth() + health > Integer.MAX_VALUE){
            throw new IllegalArgumentException("Overflow");
        }else{
            super.setHealth(health);
        }

    }



    public void playerDeathReset() {

        /*
        Metod för spelardöd, som ställer om alla stats till level 1
         */


        setLevel(1);
        setExperience(0);
        deathCounter++;
    }

    public int getDeathCounter() {
        return deathCounter;
    }

    public boolean move(Map map, String direction) {

        try{
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
        }catch (NullPointerException e){
            throw new NullPointerException("Parametern i metoden move får inte vara null");
        }

    }

    private boolean isWithinBounds(Map map, Position position) {

        try{
            int x = position.getX();
            int y = position.getY();
            return x >= 0 && y >= 0 && x < map.getWidth() && y < map.getHeight();
        }catch (NullPointerException e){
            throw new NullPointerException("Parametern i metoden move får inte vara null");
        }


    }

    private boolean canAccessTerrain(Map map, Position position) {

        try{
            Terrain terrain = map.getTerrain(position.getX(), position.getY());
            return !terrain.isBlocking() && terrain.getAccessType().equals("walk");
        }catch (NullPointerException e){
            throw new NullPointerException("Parametern i metoden move får inte vara null");
        }

    }

    private void updatePosition(Position newPosition) {

        try{
            setPosition(newPosition);
        }catch (NullPointerException e){
            throw new NullPointerException("Parametern i metoden move får inte vara null");
        }

    }
}
