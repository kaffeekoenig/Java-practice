package park;

import java.util.Random;

public class VirtualUser extends User{
    int wallet;
    public VirtualUser(int money){
        wallet = money;
    }
    @Override
    void makeFun() {
        Random random = new Random();
        int atrNum = random.nextInt(3);
        Attraction[] attractions = {new RollyCoaster(), new Carousel(), new FuturamaCab()};
        int minPrice = Integer.MAX_VALUE;

        for (Attraction a : attractions) {
            minPrice = Math.min(minPrice, a.getPrice());
        }
        
        while (wallet >= minPrice) {
            attractions[atrNum].ride();
            wallet -= attractions[atrNum].getPrice();
            atrNum = random.nextInt(3);
        }
        System.out.println("out of money :(");
    }
}
