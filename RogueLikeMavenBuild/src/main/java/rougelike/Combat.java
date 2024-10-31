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

    public static void fight(Player pc, NonPlayableCharacter npc){

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

            if(pc.getHealth() == 0.0){
                pc.death();
                System.out.println("You died");
            }else if (npc.getHealth() == 0.0){
                System.out.println("You Won!");
            }


        }
    }

    public static void main(String[] args) {

        var human = new Human();
        var giant = new Giant();

        var pc = new Player("pc", giant);
        var npc = new NonPlayableCharacter("npc", human);

        fight(pc, npc);


    }
}


