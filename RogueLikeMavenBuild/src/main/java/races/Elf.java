package RogueLikeMavenBuild.src.main.java.races;

import RogueLikeMavenBuild.src.main.java.Race;

// Elves have low health but are very agile and stronger than usual
public class Elf extends Race {
    public Elf() {
        super(0.5, 2, 1.25, 1.25, 1);
    }

    public void dash() {
        System.out.println("Whoosh!");
    }
}
