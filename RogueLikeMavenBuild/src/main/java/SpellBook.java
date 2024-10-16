package RogueLikeMavenBuild.src.main.java;

import java.util.ArrayList;

public class SpellBook {

    private final ArrayList<Magic> magics = new ArrayList<>();

    public boolean removeMagic(String name) {

        if(magics.isEmpty()){
            return false;
        }else{
            for (Magic magic : magics){
                if (magic.getName().equalsIgnoreCase(name)){
                        magics.remove(magic);
                        return true;
                    }
                }
            }
        return false;
    }

    public boolean addMagic(Magic spell){

        if (magics.contains(spell)){
            return false;
        }else{
            magics.add(spell);
        }
        return true;
    }

}
