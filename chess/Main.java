package chess;

import java.io.*;
import java.util.logging.Logger;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "masha-sasha.txt";
        String[] players = filename.split("-");
        players[1] = players[1].substring(0, players[1].indexOf("."));
        System.out.println("Игрок 1: " + players[0] + " - " + "Игрок 2: " + players[1]);
    }
}