package rougelike.combat;

import rougelike.GameCharacter;

public class Initiative {

    public static GameCharacter initativeOrder(GameCharacter pc, GameCharacter npc){

        double pcSpeed = pc.getSpeed();
        double npcSpeed = npc.getSpeed();

        if (pcSpeed > npcSpeed){
            return pc;
        } else if (pcSpeed == npcSpeed) {
            if(Math.random() % 2 == 0){
                return pc;
            }
        }
        return npc;

    }

}
