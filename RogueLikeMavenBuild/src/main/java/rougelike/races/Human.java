package rougelike.races;
import rougelike.Race;

import java.util.Set;

// Humans are balanced in everything with equal modifiers
public class Human extends Race {
    public Human() {
        super(1, 1 ,1, 1, 1, Set.of("walk", "swim"));
    }

    public void talk() {
        System.out.println("Greetings!");
    }
}
