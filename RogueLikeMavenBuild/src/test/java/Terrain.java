package rougelike;

public class Terrain {
    private boolean isVisible;
    private boolean isExplored;
    private String terrainType;
    private int height;
    private String accessType;

    public Terrain(String terrainType, int height) {
        this(terrainType, height, "walk");
    }

    public Terrain(String terrainType, int height, String accessType) {
        this.terrainType = terrainType;
        this.height = height;
        this.isVisible = false;
        this.isExplored = false;
        this.accessType = accessType;
    }
    public boolean isAccessibleBy(String characterType) {
        return characterType.equals(this.accessType) || "any".equals(this.accessType);
    }

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
}
