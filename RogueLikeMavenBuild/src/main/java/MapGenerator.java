package RogueLikeMavenBuild.src.main.java;
import java.util.Random;

public class MapGenerator {
    private int width;
    private int height;

    public MapGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Map generateMap() {
        Map map = new Map(width, height);
        Random random = new Random();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int randomValue = random.nextInt(100);
                if (randomValue < 30) {
                    map.setTerrain(x, y, new Terrain("Water", 0));
                } else if (randomValue < 60) {
                    map.setTerrain(x, y, new Terrain("Grass", 1));
                } else {
                    map.setTerrain(x, y, new Terrain("Mountain", 5));
                }
            }
        }
        return map;
    }
}
