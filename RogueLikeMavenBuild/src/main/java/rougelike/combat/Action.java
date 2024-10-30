package rougelike.combat;

import rougelike.GameCharacter;

public class Action {

    public static void hit(GameCharacter actionChar, GameCharacter reactiveChar){

        int baseDamage = 10;
        int totalDamage = baseDamage * actionChar.getStrength();

        double effect = reactiveChar.getHealth() - totalDamage;
        reactiveChar.setHealth(effect);

    }

}
