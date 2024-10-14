package amusementPark;

public abstract class Attraction {
    private int price;
    abstract void ride();

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
