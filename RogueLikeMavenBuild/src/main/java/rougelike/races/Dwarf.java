package rougelike.races;
import rougelike.Race;

import java.util.Set;

// Dwarves have more brute strength and health but lacking in speed and stamina as well as magic
public class Dwarf extends Race {
    public Dwarf() {
        super(1.5, 0.5, 0.75, 1.5, 0.25, Set.of("walk"));
    }

    public void mine() {
        System.out.println("Tick!");
    }

}
