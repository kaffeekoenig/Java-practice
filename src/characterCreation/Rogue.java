package characterCreation;

public class Rogue extends Character {
    public Rogue(){
        className = "ROGUE";
        dexterity = 10;
        intelligence = 5;
        strength = 2;
    }

    @Override
    public void lvlUp(){
        dexterity += 3;
        intelligence++;
        strength++;
    }
}
