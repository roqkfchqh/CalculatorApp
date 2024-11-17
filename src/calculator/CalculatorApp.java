package calculator;

import exception.BadInputException;
import history.History;

public class CalculatorApp {
    private final Calculator calc;
    private final UserInput userInput;
    History<Double, Double> history = new History<>();

    public CalculatorApp() {
        calc = new Calculator(history);
        userInput = new UserInput();
    }

    public void start(){
        while(true){
            try{
                double firstNumber = userInput.getNumbers("첫 번째 숫자를 입력해주세요.");
                //연속 계산 while 문으로 처리
                while(true){
                    String operator = userInput.getOperator("연산자(+,-,*,/)를 입력하고 엔터 (c: 초기화, h: 히스토리, e: 종료)");
                    if (operator.equalsIgnoreCase("h")) {
                        history.showHistory();
                        break;
                    }
                    double secondNumber = userInput.getNumbers("다음 숫자를 입력해주세요.");

                    //0으로 나눌 경우
                    if(operator.equals("/") && secondNumber == 0){
                        System.out.println("0으로 나눌 수 없습니다");
                        userInput.clearNumbers();
                        break;
                    }

                    double result = calc.calculate(userInput.getNumbers());
                    System.out.println("계산결과: " + result);
                }
            }catch(BadInputException e){
                //에러 발생 시 List 초기화
                System.out.println(e.getMessage());
                userInput.clearNumbers();
            }
        }
    }
}