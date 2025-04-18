package characterCreation;

public class Wizard extends Character{
    public Wizard(){
        className = "WIZARD";
        intelligence = 10;
        dexterity = 5;
        strength = 2;
    }
    @Override
    public void lvlUp() {
        intelligence += 3;
        dexterity++;
    }
}
