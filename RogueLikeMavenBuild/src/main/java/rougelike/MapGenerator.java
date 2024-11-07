package rougelike;

import java.util.Random;

public class MapGenerator {
    private int width;
    private int height;
    private static final double WATER_PROBABILITY = 0.25;
    private static final double GRASS_PROBABILITY = 0.25;
    private static final double MOUNTAIN_PROBABILITY = 0.25;
    private static final double HOUSE_PROBABILITY = 0.25;
  
    
    public MapGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public Map generateMap() {
        Map map = new Map(width, height);
        Random random = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double randomValue = random.nextDouble();
                if (randomValue < WATER_PROBABILITY) {
                    map.setTerrain(x, y, new Terrain("Water", 0, false, "swim"));
                } else if (randomValue < WATER_PROBABILITY + GRASS_PROBABILITY) {
                    map.setTerrain(x, y, new Terrain("Grass", 1, false, "walk"));
                } else if (randomValue < WATER_PROBABILITY + GRASS_PROBABILITY + MOUNTAIN_PROBABILITY) {
                    map.setTerrain(x, y, new Terrain("Mountain", 3, true, "fly"));
                } else {
                    map.setTerrain(x, y, new Terrain("House", 2, false, "walk"));
                }
            }
        }
        return map;
    }
}

