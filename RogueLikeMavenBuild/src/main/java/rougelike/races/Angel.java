package rougelike.races;
import rougelike.Race;

import java.util.Set;

// Angels are mythical creatures that are weak in strength but have strong magic
public class Angel extends Race {
    public Angel() {
        super(0.5, 0.5, 2, 0, 2, Set.of("walk", "fly"));
    }

    public void fly() {
        System.out.println("Flap, flap, flap.");
    }
}
