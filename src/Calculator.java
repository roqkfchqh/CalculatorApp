import java.util.LinkedList;
import java.util.List;

public class Calculator {
    private final AbstractOperation addOperation;
    private final AbstractOperation subtractOperation;
    private final AbstractOperation multiplyOperation;
    private final AbstractOperation divideOperation;
    private List<History> historyList = new LinkedList<>();

    public Calculator
    (AbstractOperation addOperation, AbstractOperation subtractOperation,
     AbstractOperation multiplyOperation, AbstractOperation divideOperation){
        this.addOperation = addOperation;
        this.subtractOperation = subtractOperation;
        this.multiplyOperation = multiplyOperation;
        this.divideOperation = divideOperation;
    }

    public double calculate(String operator, double firstNumber, double secondNumber){
        double result = 0;

        switch(operator){
            case "+":
                result = addOperation.operate(firstNumber, secondNumber);
                break;
            case "-":
                result = subtractOperation.operate(firstNumber, secondNumber);
                break;
            case "*":
                result = multiplyOperation.operate(firstNumber, secondNumber);
                break;
            case "/":
                result = divideOperation.operate(firstNumber, secondNumber);
                break;
            default:
                System.out.println("연산자 입력은 +, -, *, / 만 가능합니다.");
                return 0;
        }

        History history = new History(firstNumber, secondNumber, operator);
        historyList.add(history);

        return result;
    }
}
