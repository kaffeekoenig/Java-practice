package amusementPark;

import java.util.Random;

public class RollerCoaster extends Attraction{
    private final int DEAD_NUM = 5;
    public RollerCoaster(){
        this.setPrice(10);
    }
    @Override
    void ride() {
        Random rand = new Random();
        int chance = rand.nextInt(20) + 1;
        System.out.println(chance <= DEAD_NUM ? "u are dead lol xD xD xD" : "roller coaster wooah!");
    }
}
