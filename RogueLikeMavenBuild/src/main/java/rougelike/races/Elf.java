package rougelike.races;
import rougelike.Race;

import java.util.Set;

// Elves have low health but are very agile and stronger than usual
public class Elf extends Race {
    public Elf() {
        super(0.5, 2, 1.25, 1.25, 1, Set.of("walk", "swim"));
    }

    public void dash() {
        System.out.println("Whoosh!");
    }
}
