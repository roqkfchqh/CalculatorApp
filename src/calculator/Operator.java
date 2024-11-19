package calculator;

import calculator.operator.*;

public enum Operator {
    ADD(new AddOperation()),
    SUBTRACT(new SubstractOperation()),
    MULTIPLY(new MultiplyOperation()),
    DIVIDE(new DivideOperation()),
    SQUARE(new PowerOperation());

    private final Operation operation;

    Operator(Operation operation){
        this.operation = operation;
    }

    public Operation getOperation(){
        return new Operation(){

            @Override
            public double apply(double a, double b){
                return operation.apply(a, b);
            }
        };
    }

    //parser 에서 이미 유효성 검사를 끝낸 항목임. null 상관 없음
    //전달받은 연산자를 열거형 operator 로 변환
    public static Operator fromSymbol(String symbol){
        return switch (symbol) {
            case "+" -> ADD;
            case "-" -> SUBTRACT;
            case "*" -> MULTIPLY;
            case "/" -> DIVIDE;
            case "^" -> SQUARE;
            default -> null;
        };
    }
}