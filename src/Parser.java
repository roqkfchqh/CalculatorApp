import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator(
        new AddOperation(),
        new SubtractOperation(),
        new MultiplyOperation(),
        new DivideOperation()
    );

    public String parseFirstNum(String firstInput) throws BadInputException {
        boolean first = Pattern.matches(NUMBER_REG, firstInput);
        if(!first){
            throw new BadInputException("숫자가 아닙니다.");
        }
        return firstInput;
    }

    public String parseSecondNum(String secondInput) throws BadInputException {
        boolean second = Pattern.matches(NUMBER_REG, secondInput);
        if(!second){
            throw new BadInputException("숫자가 아닙니다.");
        }
        return secondInput;
    }

    public String parseOperator(String operationInput) throws BadInputException {
        boolean operation = Pattern.matches(OPERATION_REG, operationInput);
        if(!operation){
            throw new BadInputException("옳바른 연산자를 입력해주세요.");
        }
        return operationInput;
    }

    public double executeCalculator(double first, double second, String operation) {
        return calculator.calculate(operation,first,second);
    }
}