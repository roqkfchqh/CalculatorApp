package calculator;

import exception.BadInputException;
import history.History;
import history.UserInputHistory;

public class CalculatorApp {
    private Calculator calc;
    private UserInputCalc userInputCalc;
    private UserInputHistory userInputHistory;
    History<Double, Double> history = new History<>();

    public CalculatorApp() {
        calc = new Calculator(history);
        userInputCalc = new UserInputCalc();
        userInputHistory = new UserInputHistory(history);
    }

    public void start(){
        while(true){
            try{
                double firstNumber = userInputCalc.getNumbers("첫 번째 숫자를 입력해주세요.");
                //연속 계산 while 문으로 처리
                while(true){
                    String operator = userInputCalc.getOperator("연산자(+,-,*,/)를 입력하고 엔터 (c: 초기화, h: 히스토리, e: 종료)");
                    if (operator.equalsIgnoreCase("h")) {
                        userInputHistory.showHistory();
                        break;
                    }
                    double secondNumber = userInputCalc.getNumbers("다음 숫자를 입력해주세요.");

                    //0으로 나눌 경우
                    if(operator.equals("/") && secondNumber == 0){
                        System.out.println("0으로 나눌 수 없습니다");
                        userInputCalc.clearNumbers();
                        break;
                    }

                    double result = calc.calculate(userInputCalc.getNumbers());
                    System.out.println("계산결과: " + result);
                }
            }catch(BadInputException e){
                //에러 발생 시 List 초기화
                System.out.println(e.getMessage());
                userInputCalc.clearNumbers();
            }
        }
    }
}