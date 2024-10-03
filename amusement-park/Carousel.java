package park;

public class Carousel extends Attraction{
    public Carousel() {
        price = 5;
        placeCount = 30;
    }

    @Override
    void ride(){
        System.out.println("rotating wooOoOaH");
    }
}
