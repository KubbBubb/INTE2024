package rougelike;

public class Magic {

    private static final double BASE_EFFECT = 20;
    private final String name;
    private boolean isOffensive;

    public Magic(String name, boolean isOffensive){
        this.name = name;
        this.isOffensive = isOffensive;
    }

    public boolean getIsOffensive() {
        return isOffensive;
    }

    public String getName() {
        return name;
    }

    public static double getBaseEffect() {
        return BASE_EFFECT;
    }
}
