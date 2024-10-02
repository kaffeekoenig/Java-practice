package simpleCalculator;

public class Calculator {
    public static double calculate(char op, double a, double b) {
        Operation operation = getOperation(op);
        if (operation == null) {
            System.out.println("Unexpected operation!");
            return Double.NaN;
        }
        return operation.calculate(a, b);
    }
    private static Operation getOperation(char op) {
        return switch (op) {
            case '+' -> new PlusOperation();
            case '-' -> new MinusOperation();
            case '*' -> new MultiplyOperation();
            case '/' -> new DevideOperation();
            default -> null;
        };
    }
}
