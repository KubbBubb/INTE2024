package rougelike.combat;

import rougelike.Entity;

public class Action {

    public static void hit(Entity actionChar, Entity reactiveChar){

        int baseDamage = 10;
        int totalDamage = baseDamage * actionChar.getStrength();

        double effect = reactiveChar.getHealth() - totalDamage;
        reactiveChar.setHealth(effect);

    }

}
