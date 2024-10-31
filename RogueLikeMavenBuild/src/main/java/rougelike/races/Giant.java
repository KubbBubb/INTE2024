package rougelike.races;
import rougelike.Race;

import java.util.Set;

// Giants are incredibly strong but very slow and weak in magic
public class Giant extends Race {
    public Giant() {
        super(2, 0.5, 0.5, 2, 0, Set.of("walk"));
    }

    public void sleep() {
        System.out.println("Zzz...");
    }
}
