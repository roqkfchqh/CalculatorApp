import java.util.function.BiFunction;

public enum Operation {
    //전달된 연산자에 따라 연산 수행
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private final BiFunction<Double, Double, Double> operator;

    Operation(String symbol, BiFunction<Double, Double, Double> operator){
        this.symbol = symbol;
        this.operator = operator;
    }

    //숫자 메서드
    public double apply(double a, double b){
        return operator.apply(a, b);
    }

    //연산자 메서드
    public static Operation fromSymbol(String symbol){
        for(Operation operation : Operation.values()){
            if(operation.symbol.equals(symbol)){
                return operation;
            }
        }
        throw new IllegalArgumentException();
    }
}