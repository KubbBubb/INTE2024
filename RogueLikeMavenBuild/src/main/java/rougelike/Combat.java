package rougelike;

import rougelike.races.Giant;
import rougelike.races.Human;

import java.util.ArrayList;

import static rougelike.combat.Action.hit;
import static rougelike.combat.Initiative.initiativeOrder;

public class Combat {

    /*
    Händelseförloppet ska ske här
    1. Strid etablerad
    2. Mät intiativ ordningen
    3. Val av handling
    4. Resultat.
    5. Repetera från 3 tills en karaktär är besegrad
     */

    public static void fight(PlayableCharacter pc, NonPlayableCharacter npc){

        ArrayList<GameCharacter> orderList = initiativeOrder(pc, npc);
        GameCharacter first = orderList.get(0);
        GameCharacter second =  orderList.get(1);

        while (pc.getHealth() > 0.0 && npc.getHealth() > 0.0){

            hit(first, second);
            System.out.println(first.getName() + " strikes " + second.getName() + ". " + second.getName() + " has "
                    + second.getHealth() + " hp left");
            hit(second, first);
            System.out.println(second.getName() + " strikes " + first.getName() + ". " + first.getName() + " has "
                    + first.getHealth() + " hp left");

            if(npc.getHealth() <= 0.0 ){
                System.out.println("You Won!");
            }else if (pc.getHealth() <= 0.0){
                pc.playerDeathReset();
                System.out.println("You died");
                System.out.println(pc.getDeathCounter());

            }


        }
    }

    public static void main(String[] args) {

        PlayableCharacter pc = new PlayableCharacter("pc", new Human());
        NonPlayableCharacter npc = new NonPlayableCharacter("npc", new Human(), new Position(0, 0));
        pc.setHealth(1000000000.0);
        npc.setHealth(1000000000.0);

        fight(pc, npc);


    }

}


