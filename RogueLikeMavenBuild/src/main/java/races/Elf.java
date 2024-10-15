package RogueLikeMavenBuild.src.main.java.races;

import RogueLikeMavenBuild.src.main.java.Race;

public class Elf extends Race {
    public Elf() {
        super(1, 0.75, 1.25);
    }

    public void dash() {
        System.out.println("Whoosh!");
    }
}
