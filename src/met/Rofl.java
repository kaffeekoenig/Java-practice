package met;

import java.io.IOException;
import java.lang.reflect.*;
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

    }


    private Method[] getPrivateProtected() {
        Class<MethodHolder> c = MethodHolder.class;
        Method[] m = c.getDeclaredMethods();
        MethodHolder mh = new MethodHolder();
        for (Method method : m) {
            if (Modifier.isPrivate(method.getModifiers()) || Modifier.isProtected(method.getModifiers())) {
                method.setAccessible(true);

                try {
                    Type[] pType = method.getParameterTypes();
                    if (pType.length == 0) {
                        method.invoke(mh);
                    } else {
                        Class<?>[] paramTypes = method.getParameterTypes();
                        Object[] arguments = new Object[paramTypes.length];
                        for (int i = 0; i < paramTypes.length; i++) {
                            //arguments[i] = getDe(paramTypes[i]);
                        }
                        //method.invoke(instanse, arguments);
                        for (int i = 0; i < pType.length; i++) {
                            paramTypes[i] = pType.getClass();
                        }
                        System.out.println(method.invoke(mh));
                    }
                } catch (InvocationTargetException | IllegalAccessException e) {
                    log.severe("you died, because " + e);
                } finally {
                    method.setAccessible(false);
                }
            }
        }
        return m;
    }

    private Object getDefaultValue(Class<?> type) {
        if (type.isPrimitive()) {
            if (type == boolean.class) return false;
            if (type == char.class) return '\u0000';
            if (type == byte.class) return (byte) 0;
            if (type == short.class) return (short) 0;
            if (type == int.class) return 0;
            if (type == long.class) return 0L;
            if (type == float.class) return 0.0f;
            if (type == double.class) return 0.0d;
        }
        return null;
    }
}