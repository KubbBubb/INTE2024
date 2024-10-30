package rougelike;
public class MapGenerator {
    private int width;
    private int height;

    public MapGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public Map generateMap() {
        Map map = new Map(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if ((x + y) % 4 == 0) {
                    map.setTerrain(x, y, new Terrain("Water", 0, false));
                } else if ((x + y) % 4 == 1) {
                    map.setTerrain(x, y, new Terrain("Grass", 1, false));
                } else if ((x + y) % 4 == 2) {
                    map.setTerrain(x, y, new Terrain("Mountain", 3, true));
                } else {
                    map.setTerrain(x, y, new Terrain("House", 2, false));
                }
            }
        }
        return map;
    }
}
