import java.util.Scanner;

public class CalculatorApp {
    Parser parser = new Parser();

    public void start(){
        Scanner calculation = new Scanner(System.in);
        while(true){
            try {
                System.out.println("첫 번째 숫자를 입력하고 엔터");
                String firstNumber = calculation.nextLine();
                double firstInput = Double.parseDouble(parser.parseFirstNum(firstNumber));

                System.out.println("연산자(+,-,*,/)를 입력하고 엔터");
                String operator = calculation.nextLine();
                String operatorInput = parser.parseOperator(String.valueOf(operator));

                System.out.println("두 번째 숫자를 입력하고 엔터");
                String secondNumber = calculation.nextLine();
                double secondInput = Double.parseDouble(parser.parseSecondNum(secondNumber));

                System.out.println("계산 결과는 : " + parser.executeCalculator(firstInput, secondInput, operatorInput));
                System.out.println("더 계산하시겠습니까? 아무 키나 입력.(exit 입력 시 종료)");
                String input = calculation.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
            } catch (BadInputException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }
}

