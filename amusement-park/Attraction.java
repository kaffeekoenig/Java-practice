package park;

public abstract class Attraction {
    int price;
    int placeCount;
    abstract void ride();

    public int getPrice() {
        return price;
    }

    public int getPlaceCount() {
        return placeCount;
    }
}
