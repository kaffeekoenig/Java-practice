package simpleCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        Scanner scanLine = new Scanner(s);

        double a;
        if (scanLine.hasNextDouble()) a = scanLine.nextDouble();
        else {
            System.out.println("Wrong argument!");
            return;
        }

        char op = scanLine.next().charAt(0);

        double b;
        if (scanLine.hasNextDouble()) b = scanLine.nextDouble();
        else {
            System.out.println("Wrong argument");
            return;
        }

        System.out.println(Calculator.calculate(op, a, b));
    }
}
