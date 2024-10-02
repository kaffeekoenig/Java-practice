package simpleCalculator;

public class DevideOperation implements Operation {
    @Override
    public double calculate(double a, double b) {
        if (b == 0) return a > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;

        return a / b;
    }
}
