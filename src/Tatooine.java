import java.util.Scanner;
import java.util.*;

public class Tatooine extends StarWars {

    public int action, enemyHealth, enemyDmg, jawaTrust = 0;
    public String enemy;
    public Trading trade = new Trading();

    public void start(ArrayList<String> inventory){

        Scanner sc = new Scanner(System.in);

        System.out.println("You're surrounded by an endless desert.\n" +
                "You notice the tracks from a sandcrawler blow into the wind as a\ngroup of Jawa's move" +
                "behind a rock. What would you like to do?" +
                "\n1. Approach Jawas" +
                "\n2. Attack Jawas" +
                "\n3. Run away");
        action = sc.nextInt();

        if(action == 2){
            enemyHealth = 6;
            battle(inventory);
            jawaTrust = -1;
            action = 1;
        }
        if(action == 1){

            if(jawaTrust > -1)
                System.out.println("\"Utinni! Utinni!\"");
            else
                System.out.println("\"Ny shootogawa!\"");

            // droids know all languages
            if(inventory.contains("d") && jawaTrust > -1)
                System.out.println("The jawa is surprised to see you");
            else if(inventory.contains("d") && jawaTrust < 0)
                System.out.println("The jawa are scared.");
            else
                System.out.println("You don't understand what they say, but they seem surprised to see you");
            if(jawaTrust > -1) {
                System.out.println("\"Etee uwanna waa.\"");

                if (inventory.contains("d"))
                    System.out.println("The jawa wants to trade");
                else
                    System.out.println("They gesture towards some junk on the sand crawler, implying they want to trade.");

                System.out.println("You don't have any credits to trade with, but the jawa has a request in\n" +
                        "in exchange for a few credits. Do you accept?");
            } else{
                System.out.println("\"Ikee perupa Ja'bo'ba ashuna shootogawa ikee hunya; ton ton ayafa\"");

                if(inventory.contains("d")) {
                    System.out.println("The Jawas needs someone to take care of the Tusken Raiders" +
                            " looting their cargo");
                } else
                    System.out.println("They seem to be imitating some Tusken raiders being violent" +
                            "\nPerhaps they need something to be done about them?");

            }
            System.out.println("What would you like to do?" +
                    "\n1. Accept quest" +
                    "\n2. Deny quest" +
                    "\n3. Run away");
            action = sc.nextInt();

            while(action != 1){


                System.out.println("Take a chance\nWhat would you like to do?" +
                            "\n1. Accept quest" +
                            "\n2. Deny quest" +
                            "\n3. Run away");
                action = sc.nextInt();
            }

            quest();
        }
    }

    public void quest(){

        trade.add("Quest1");

        // variables
        String action = "";
        Boolean possibleAction = true;
        Scanner sc = new Scanner(System.in);
        int act = 0;

        // user decides what to do
        System.out.println("You see footprints heading west, towards a desert mountain range\n" +
                "with arches towering over the group of raiders yelling loudly. \n" +
                "To the North you see a group of speeders racing toward's Mos Eisley\n" +
                "To the South there are a few more Jawa's trading with locals\n" +
                "To the East is desert as far as the eye can see.");



        while(act == 0){

            System.out.print("What would you like to do? ");
            action = sc.nextLine();
            action = action.toLowerCase();

            // north = 1, south = 2, west = 3;
            if (action.contains("north") || action.contains("west") || action.contains("south")){
                if(action.contains("north"))
                    act = 1;
                else if(action.contains("west"))
                    act = 3;
                else if(action.contains("south"))
                    act = 2;

            }
            else if(action.contains("east")) {
                System.out.println("Going this way would be pointless, it's just desert.");

            }
            else if(action.contains("footprints")) {
                act = 3;
            }
            else if(action.contains("city") || action.contains("mos eisley") || action.contains("trade")) {
                if(action.contains("city") || action.contains("mos eisley"))
                    act = 1;
                else
                    act = 2;
            }

        }
        possibleAction = true;
        if (act == 1) {
            do {
                System.out.println("You've gone about a half of the way to Mos Eisley\n" +
                        "Would you like to continue or turn back?");
                action = sc.nextLine();
                action = action.toLowerCase();
                if (action.contains("continue") || action.contains("cont") || action.contains("mos eisley")) {
                    possibleAction = false;
                } else if (action.contains("turn") || action.contains("back")) {
                    possibleAction = false;
                } else
                    System.out.println("Command not recognized.");

            } while (possibleAction);
            mosEisley();
        }
        else if(act == 2){

        }
    }
    public void mosEisley(){

    }
    public void battle(ArrayList<String> inventory){

        Scanner sc = new Scanner(System.in);
        Weapons attack = new Weapons();
        do{

            if(inventory.contains("Blaster"))
                dmg = attack.blaster();
            else if(inventory.contains("Saber"))
                dmg = attack.saber();
            else
                System.out.println("Only a fool goes into battle without a weapon");

            if (dmg > 0) {
                System.out.println("You did " + dmg + " damage. The enemy prepares to strike");
                enemyHealth -= dmg;

            } else if(dmg == 0)
                System.out.println("Your shot missed!");
            enemyDmg = attack.easyEnemy();
            System.out.println("The enemy throws a rock at your big dumb head for " + enemyDmg + " damage.");
            health -= enemyDmg;
            if(enemyHealth > 0)
                System.out.println("The enemy has " + enemyHealth + " health remaining");
            else
                System.out.println("The enemy has no health remaining");

            if(health < 20 && enemyHealth > 0){
                System.out.println("Do you wish to continue this fight? y/n");
                String cont = sc.next();

                if(cont.equals("n"))
                    break;
            }
        }while(enemyHealth > 1 && health > 1);
        if(health < 1) {
            System.out.println("How did you get killed by a " + enemy + " Maybe you shouldn't play this game.");
            System.exit(0);
        }
        System.out.println("You have " + health + " health left.");

        }
    }
