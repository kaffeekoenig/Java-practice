package simpleCalculator;

public class MinusOperation implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}
