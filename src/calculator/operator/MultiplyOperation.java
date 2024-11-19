package calculator.operator;

import calculator.Operation;

public class MultiplyOperation extends Operation {
    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}
