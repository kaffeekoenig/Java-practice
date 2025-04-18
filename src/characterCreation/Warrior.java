package characterCreation;

public class Warrior extends Character{
    public Warrior() {
        className = "WARRIOR";
        strength = 10;
        dexterity = 5;
        intelligence = 2;
    }
    @Override
    public void lvlUp(){
        strength += 3;
        dexterity++;
    }
}
