package amusementPark;

public abstract class Attraction {
    int price;
    int placeCount;
    abstract void ride();

    public int getPrice() {
        return price;
    }
}
