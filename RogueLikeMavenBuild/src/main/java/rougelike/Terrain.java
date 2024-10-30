package rougelike;

public class Terrain {
    private boolean isVisible;
    private boolean isExplored;
    private String terrainType;
    private int height;
    private boolean isBlocking;
    //private String accessType;

    //public Terrain(String terrainType, int height) {
    //   this(terrainType, height,"walk");
    // }
    public Terrain(String terrainType, int height,boolean isBlocking) {
        this.terrainType = terrainType;
        this.height = height;
        this.isVisible = false;
        this.isExplored = false;
        this.isBlocking = isBlocking;
        //this.accessType = accessType;
    }
    // public boolean isAccessibleBy(Entity entity) {
    //  return entity.getCharacterType().equals(this.accessType) || "any".equals(this.accessType);
    // }


    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }

    public boolean isExplored() {
        return isExplored;
    }

    public void setExplored(boolean explored) {
        this.isExplored = explored;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public int getHeight() {
        return height;
    }

    public boolean isBlocking() {
        return isBlocking;
    }
}
