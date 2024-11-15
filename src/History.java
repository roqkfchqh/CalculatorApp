import java.util.LinkedList;
import java.util.List;

public class History <N extends Number, R> {

    private N firstNumberValue;
    private N secondNumberValue;
    private String operator;
    private R result;

    private int idNum = 1;
    private List<String> history;

    public History (N firstNumber, N secondNumber, String operator, R result){
        this.firstNumberValue = firstNumber;
        this.secondNumberValue = secondNumber;
        this.operator = operator;
        this.result = result;
        this.history = new LinkedList<>();
    }

    public void saveHistory(){
        history.add(idNum + ") " + firstNumberValue + operator + secondNumberValue + "=");
        history.add((String) result);
        idNum++;
    }
}
