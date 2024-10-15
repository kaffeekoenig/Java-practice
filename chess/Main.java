package chess;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String fileName = "masha-sasha.txt";
        String path = String.valueOf(Main.class.getResource(fileName)).substring(5);

        String[] players = fileName.split("-");
        players[1] = players[1].substring(0, players[1].indexOf("."));
        System.out.println("Игрок 1: " + players[0] + " - " + "Игрок 2: " + players[1]);

        try (FileReader fileReader = new FileReader(path)) {
            String s = "";
            while (fileReader.ready()) System.out.print((char)fileReader.read());
        } catch (IOException e) {
            logger.severe("something went wrong >> " + e);
        }
    }
}