public class HistoryData {
    private double firstNumber;
    private double secondNumber;
    private String operator;
    private double result;
    private int idNum;

    public HistoryData(double firstNumber, double secondNumber, String operator, double result, int idNum) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = result;
        this.idNum = idNum;
    }

    public double getFirstNumber() {return firstNumber;}
    public double getSecondNumber() {return secondNumber;}
    public String getOperator() {return operator;}
    public double getResult() {return result;}
    public int getIdNum() {return idNum;}
}