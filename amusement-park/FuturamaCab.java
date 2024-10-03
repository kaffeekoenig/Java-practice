package park;

public class FuturamaCab extends Attraction {
    int count = 0;
    public FuturamaCab(){
        price = 500;
        placeCount = 1;
    }

    void visit() {
        count++;
        price++;
    }
    @Override
    void ride() {
        visit();
        System.out.println("u tried to die already " + count + " times lol");
    }
}
