package RogueLikeMavenBuild.src.main.java;

public class Map {
    private Terrain[][] map;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Terrain[width][height];
    }

    public void setTerrain(int x, int y, Terrain terrain) {
        map[x][y] = terrain;
    }

    public Terrain getTerrain(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return map[x][y];
        }
        return null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void calculateVisibility(int playerX, int playerY, int visionRange) {
           for (int x = -visionRange; x <= visionRange; x++) {
            for (int y = -visionRange; y <= visionRange; y++) {
                int targetX = playerX + x;
                    int targetY = playerY + y;
                if (isWithinBounds(targetX, targetY)) {
                      Terrain terrain = getTerrain(targetX, targetY);
                     if (terrain != null) {
                        terrain.setVisible(true);
                          terrain.setExplored(true);
                        }
                }
               }
        }
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
