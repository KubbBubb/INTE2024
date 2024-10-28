package RogueLikeMavenBuild.src.main.java.races;

import RogueLikeMavenBuild.src.main.java.Race;

// Giants are incredibly strong but very slow and weak in magic
public class Giant extends Race {
    public Giant() {
        super(2, 0.5, 0.5, 2, 0);
    }

    public void sleep() {
        System.out.println("Zzz...");
    }
}
