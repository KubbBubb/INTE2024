package RogueLikeMavenBuild.src.main.java.races;
import RogueLikeMavenBuild.src.main.java.Race;

public class Dwarf extends Race {
    public Dwarf() {
        super(1.2, 1.5, 0.75);
    }

    public void mine() {
        System.out.println("Tick!");
    }

}