package rougelike.combat;

import rougelike.GameCharacter;
import rougelike.Magic;

public class Action {

    public static void hit(GameCharacter actionChar, GameCharacter reactiveChar){

        int baseDamage = 10;
        double totalDamage = baseDamage * actionChar.getRace().getStrengthModifier();

        double effect = reactiveChar.getHealth() - totalDamage;
        reactiveChar.setHealth(effect);

    }

    public static void castSpell(GameCharacter actionChar, GameCharacter reactiveChar, String spellName){

        Magic spell = actionChar.getSpellBook().findMagic(spellName);

        if(spell != null){
            double totalPower = Magic.getBaseEffect() * actionChar.getMagic();
            if (spell.getIsOffensive()){
                double effect = reactiveChar.getHealth() - totalPower;
                reactiveChar.setHealth(effect);
            }else{
                double totalHealthRestored = Magic.getBaseEffect() + totalPower;
                actionChar.setHealth(totalHealthRestored);
            }
        }

    }
}
