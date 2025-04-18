package annotations;

import java.util.Random;

public class Data {
    @Ok
    private int a;
    @Ok
    private int b;
    @Ugly(k = 5)
    private int c;
    @Ugly(k = 10)
    private int d;
    private final int E = 666;

    public Data(){
        Random random = new Random();
        a = random.nextInt(100);
        b = random.nextInt(10);
        c = random.nextInt(30);
        d = random.nextInt(5);
    }
}
