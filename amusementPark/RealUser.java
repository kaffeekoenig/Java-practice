package amusementPark;

import java.util.HashMap;
import java.util.Scanner;

public class RealUser extends User{
    @Override
    void makeFun() {
        Scanner scanner = new Scanner(System.in);
        String atr = scanner.nextLine();
        HashMap<String, Attraction> attractions = new HashMap<>();
        attractions.put("rc", new RollerCoaster());
        attractions.put("fc", new FuturamaCab());
        attractions.put("cr", new Carousel());

        while (!atr.equals("exit")) {
            if (!attractions.containsKey(atr)) {
                System.out.println("not exist");
                atr = scanner.nextLine();
                continue;
            }
            attractions.get(atr).ride();
            atr = scanner.nextLine();
        }
    }
}
