package calculator.operator;

import calculator.Operation;

public class PowerOperation extends Operation {
    @Override
    public double apply(double a, double b) {
        return Math.pow(a, b);
    }
}
