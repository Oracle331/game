import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Weapons extends StarWars{
    public int crit;
    ArrayList<String> inventory = new ArrayList<>(20);



    public Weapons(){

    }
    public int weapon(){


        if(inventory.contains("Blaster")){
            dmg = blaster();
        }
        else if(inventory.contains("Saber")){
            saber();
        }
        else{
            noWeapon();
        }
        return dmg;
    }

    public int blaster(){

        // Random chance for shot to miss
        Random rand = new Random();
        int hit = rand.nextInt(5) + 1;

        // Range of potential damage
        dmg = rand.nextInt(5) + 3;

        // droids can't aim
        if(inventory.contains("d"))
            hit--;

        if(hit == 1)
            dmg = 0;

        return dmg;
    }
    public int saber(){
        Random rand = new Random();
        int hit = rand.nextInt(3)+1;

        dmg = hit * rand.nextInt(5) + 3;

        return dmg;
    }
    public void noWeapon(){

    }

    public int easyEnemy(){
        crit++;
        if(crit == 4) {
            crit = 0;
            return 5;
        }
        return 2;
    }

}
