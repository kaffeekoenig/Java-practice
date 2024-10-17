package met;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Rofl {
    private static final Logger log = Logger.getLogger(Rofl.class.getName());
    static {
        SimpleFormatter formatter = new SimpleFormatter();
        try {
            FileHandler fh = new FileHandler("./log.log");
            log.addHandler(fh);
            fh.setFormatter(formatter);
            log.setUseParentHandlers(false);
        } catch (IOException e) {
            log.severe("l0l");
        }
    }
    public static void main(String[] args) {
        Class<MethodHolder> c = MethodHolder.class;
        Method[] m = c.getDeclaredMethods();
        MethodHolder mh = new MethodHolder();
        for (Method method : m) {
            if (Modifier.isPrivate(method.getModifiers()) || Modifier.isProtected(method.getModifiers())) {
                method.setAccessible(true);
                try {
                    System.out.println(method.invoke(mh));
                } catch (InvocationTargetException | IllegalAccessException e) {
                    log.severe("you died");
                } finally{
                    method.setAccessible(false);
                }
            }
        }
    }
}
