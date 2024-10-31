package rougelike.combat;

import rougelike.GameCharacter;

import java.util.ArrayList;

public class Initiative {

    public static ArrayList<GameCharacter> initiativeOrder(GameCharacter pc, GameCharacter npc){

        ArrayList<GameCharacter> orderList = new ArrayList<>();
        double pcSpeed = pc.getSpeed();
        double npcSpeed = npc.getSpeed();

        if (pcSpeed > npcSpeed) {
            orderList.add(pc);
            orderList.add(npc);
        }else{
            orderList.add(npc);
            orderList.add(pc);
        }
        return orderList;

    }

}
