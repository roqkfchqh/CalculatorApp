package calculator;

import exception.BadInputException;
import history.History;
import history.HistoryInteraction;

public class CalculatorApp {
    private final Calculator calc;
    private final CalculatorInput calculatorInput;
    private final HistoryInteraction historyInteraction;
    History<Double, Double> history = new History<>();

    public CalculatorApp() {
        calc = new Calculator(history);
        calculatorInput = new CalculatorInput();
        historyInteraction = new HistoryInteraction(history);
    }

    public void start(){
        while(true){
            try{
                double firstNumber = calculatorInput.getNumbers("첫 번째 숫자를 입력해주세요.");
                //연속 계산 while 문으로 처리
                while(true){
                    System.out.println("\uD83D\uDCA1더하기, 빼기, 곱하기, 나누기, 거듭제곱 가능\uD83D\uDCA1");
                    String operator = calculatorInput.getOperator("연산자(+,-,*,/,^)를 입력하고 엔터 (c: 초기화, h: 히스토리, e: 종료)");
                    if (operator.equalsIgnoreCase("h")) {
                        historyInteraction.showHistory();
                        break;
                    }
                    double secondNumber = calculatorInput.getNumbers("다음 숫자를 입력해주세요.");

                    //0으로 나눌 경우
                    if(operator.equals("/") && secondNumber == 0){
                        System.out.println("❌0으로 나눌 수 없습니다.❌");
                        calculatorInput.clearNumbers();
                        break;
                    }

                    double result = calc.calculate(calculatorInput.getNumbers());
                    System.out.println("✨계산결과: " + result);
                }
            }catch(BadInputException e){
                //에러 발생 시 List 초기화
                System.out.println(e.getMessage());
                calculatorInput.clearNumbers();
            }
        }
    }
}