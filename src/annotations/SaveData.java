package annotations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SaveData {
    private static final Logger logger = Logger.getLogger(SaveData.class.getName());

    static {
        try {
            FileHandler fh = new FileHandler("annotations-log.log", true);
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            logger.severe(e.toString());
        }
    }

    public static void saveToFile(Data data, String[] args) {
        Random random = new Random();
        StringBuilder s = new StringBuilder("{");

        try {
            Field[] fields = data.getClass().getFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Ok.class)) {
                    s.append("\"").append(field.getName()).append("\" ").append(field.getInt(data)).append(", ");
                } else if (field.isAnnotationPresent(Ugly.class)) {
                    Ugly ugly = field.getAnnotation(Ugly.class);
                    int k = ugly.k();
                    int randomValue = random.nextInt(2 * k + 1) - k;
                    s.append("\"").append(field.getName()).append("\" ").append(randomValue).append(", ");
                } else {
                    logger.info("not annotated field " + field.getName() + " : " + field);
                }
            }

            if (s.length() > 1) {
                s.setLength(s.length() - 2);
            }
            s.append("}");

            // организовать

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[0]))) {
                writer.write(s.toString());
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.severe("no path in String[] args");
            }

        } catch (IOException | IllegalAccessException err) {
            logger.severe("error " + err);
        }
    }

}
