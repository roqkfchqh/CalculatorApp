package history;

public class HistoryData {
    private final double firstNumber;
    private final double secondNumber;
    private final String operator;
    private final double result;
    private final int idNum;

    public HistoryData(double firstNumber, double secondNumber, String operator, double result, int idNum) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = result;
        this.idNum = idNum;
    }

    //각 데이터 불러오는 메서드
    public double getFirstNumber() {return firstNumber;}
    public double getSecondNumber() {return secondNumber;}
    public String getOperator() {return operator;}
    public double getResult() {return result;}
    public int getIdNum() {return idNum;}

    public String getString() {
        return idNum + ") " + firstNumber + " " + operator + " " + secondNumber + " " + result;
    }
}
