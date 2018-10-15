import java.util.*;

public class StarWars {

    // Global Variables
    public String characterType;
    public int health = 20, dmg;
    ArrayList<String> inventory = new ArrayList<>();


    public StarWars(){

    }

    public void intro (){


        // abstract methods
        Timer timer = new Timer();

        // intro
        System.out.println("A long time ago in a galaxy far, far away...");
        timer.schedule(new TimerTask(){
           public void run() { // wait a second to build anticipation
                System.out.println("...a hero chooses his adventure!");
                chooseClass();
            }
        }, 3000);

    }


    public void chooseClass(){

        // call abstract methods
        Scanner sc = new Scanner(System.in);

        // choose class
        System.out.println("Choose a class: Sharpshooter(s), Medic(m), Droid(d), Jedi(j) or type h for help");
        characterType = sc.next();
        if(characterType.equals("s")){
            sharpShooter();

        }
        else if(characterType.equals("m")){
            medic();
        }
        else if(characterType.equals("d")){
            droid();
        }
        else if(characterType.equals("j")){
            jedi();
        }
        else{
            System.out.println("To pick a class type the letter next to the class and hit enter.\n" +
                    "Sharpshooter - DESC\n" + // add character descriptions
                    "Medic - DESC\n" +
                    "Droid - DESC\n" +
                    "Jedi - DESC");
            chooseClass();

        }


    }
    public void sharpShooter(){
        Tatooine planet = new Tatooine();
        System.out.println("You've chosen Sharpshooter");
        inventory.add(0, "s");
        inventory.add(1, "Blaster");
        planet.start(inventory);
    }
    public void medic(){
        Tatooine planet = new Tatooine();
        System.out.println("You've chosen Medic");
        inventory.add(0, "m");
        inventory.add(1, "Blaster");
        planet.start(inventory);
    }
    public void droid(){
        Tatooine planet = new Tatooine();
        System.out.println("You've chosen Droid");
        inventory.add(0, "d");
        inventory.add(1, "Blaster");
        planet.start(inventory);

    }
    public void jedi(){
        Tatooine planet = new Tatooine();
        System.out.println("You've chosen Jedi");
        inventory.add(0, "j");
        inventory.add(1, "Saber");
        planet.start(inventory);
    }
    public ArrayList<String> getInventory(){
        return inventory;
    }
}
