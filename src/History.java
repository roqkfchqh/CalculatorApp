import java.util.LinkedList;
import java.util.List;

public class History implements HistoryStorage{

    private double firstNumberValue;
    private double secondNumberValue;
    private String operator;

    public History (double firstNumber, double secondNumber, String operator){
        this.firstNumberValue = firstNumber;
        this.secondNumberValue = secondNumber;
        this.operator = operator;
    }

    @Override
    public double getFirstNumberValue(){
        return firstNumberValue;
    }

    @Override
    public double getSecondNumberValue(){
        return secondNumberValue;
    }

    @Override
    public String getOperator(){
        return operator;
    }

    @Override
    public List<String> saveHistory(){
        List<String> history = new LinkedList<>();
        history.add("First number: " + firstNumberValue);
        history.add("Second number: " + secondNumberValue);
        history.add("Operation: " + operator);
        return history;
    }
}
