package RogueLikeMavenBuild.src.main.java.races;

import RogueLikeMavenBuild.src.main.java.Race;

public class Giant extends Race {
    public Giant() {
        super(1.5, 2, 0.25);
    }

    public void sleep() {
        System.out.println("Zzz...");
    }
}
