package amusementPark;

public class Carousel extends Attraction{
    public Carousel() {
        this.setPrice(5);
    }

    @Override
    void ride(){
        System.out.println("rotating wooOoOaH");
    }
}
