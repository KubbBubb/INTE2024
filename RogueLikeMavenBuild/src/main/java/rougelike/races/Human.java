package rougelike.races;
import rougelike.Race;

// Humans are balanced in everything with equal modifiers
public class Human extends Race {
    public Human() {
        super(1, 1 ,1, 1, 1);
    }

    public void talk() {
        System.out.println("Greetings!");
    }
}
