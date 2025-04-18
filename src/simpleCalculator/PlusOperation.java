package simpleCalculator;

public class PlusOperation implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
