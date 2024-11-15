import java.util.LinkedList;
import java.util.List;

public class History <N extends Number, R> {
    //제네릭을 사용했으나 연습용임, N과 R 둘 다 double
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
