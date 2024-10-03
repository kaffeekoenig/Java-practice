package park;

import java.util.Random;

public class RollyCoaster extends Attraction{
    int deadNum = 1;
    public RollyCoaster(){
        price = 10;
        placeCount = 15;
    }
    @Override
    void ride() {
        Random rand = new Random();
        int chance = rand.nextInt(20) + 1;
        System.out.println(chance == deadNum ? "u are dead lol xD xD xD" : "rollycoaster wooah!");
    }
}
