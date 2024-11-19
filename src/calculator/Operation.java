package calculator;

public abstract class Operation {
    public abstract double apply(double a, double b);

    public static Operation fromEnum(Operator operator){
        return operator.getOperation();
    }
}
