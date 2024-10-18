package RogueLikeMavenBuild.src.main.java;

public class Terrain {
    private boolean isVisible;
    private boolean isExplored;
    private String terrainType;
    private int height;

    public Terrain(String terrainType, int height) {
        this.terrainType = terrainType;
        this.height = height;
        this.isVisible = false;
        this.isExplored = false;
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
