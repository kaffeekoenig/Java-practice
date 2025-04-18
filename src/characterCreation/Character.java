package characterCreation;

public abstract class Character {
    protected String className;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int charisma;
    public abstract void lvlUp();

    public String getClassName() {
        return className;
    }
}
