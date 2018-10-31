
public class StarWarsRunner extends StarWars{

    public static void main(String[] args){
        StarWars war = new StarWars();
        //war.intro();
        Tatooine quest = new Tatooine();
        war.sharpShooter();
        quest.quest();
        Trading items = new Trading();
    }
}
