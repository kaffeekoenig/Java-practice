package chess;

public class Main {
    public static void main(String[] args) {
        String filename = "masha-sasha.txt";
        String[] players = filename.split("-");
        players[1] = players[1].substring(0, players[1].indexOf("."));
        System.out.println("Игрок 1: " + players[0] + " - " + "Игрок 2: " + players[1]);
    }
}