package calculator.operator;

import calculator.Operation;

public class DivideOperation extends Operation {
    @Override
    public double apply(double a, double b) {
        return a / b;
    }
}
