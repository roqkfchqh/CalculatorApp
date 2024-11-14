import java.util.function.BiFunction;

public enum Operation {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    //멤버 변수 선언
    private final String symbol;
    private final BiFunction<Double, Double, Double> operator;

    //생성자
    Operation(String symbol, BiFunction<Double, Double, Double> operator){
        this.symbol = symbol;
        this.operator = operator;
    }

    public double apply(double a, double b){
        return operator.apply(a, b);
    }

    public static Operation fromSymbol(String symbol){
        for(Operation operation : Operation.values()){
            if(operation.symbol.equals(symbol)){
                return operation;
            }
        }
        throw new IllegalArgumentException(symbol + "은 사용할 수 없는 연산자입니다.");
    }
}
