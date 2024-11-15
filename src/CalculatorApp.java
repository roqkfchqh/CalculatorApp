import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {

    Calculator calc = new Calculator();
    Parser parser = new Parser();

    //Calculator class 에 사용되는 List 생성
    List<String> numbers = new ArrayList<>();

    public void start(){
        Scanner calculation = new Scanner(System.in);
        while(true){
            try{
                System.out.println("첫 번째 숫자를 입력하고 엔터");
                String a = calculation.nextLine();
                double firstInput = Double.parseDouble(parser.parseFirstNum(a));    //parser 로 보내서 유효성 검사
                numbers.add(String.valueOf(firstInput));    //BadInputException 에러가 안 떳으면 List 에 값 저장

                //연속 계산 while 문으로 처리
                while(true){
                    System.out.println("연산자(+,-,*,/)를 입력하고 엔터(또는 c:값 초기화, e:나가기, h: 히스토리)");
                    String operator = calculation.nextLine();
                    if (operator.equalsIgnoreCase("e")) {   //사용자가 e 입력 시 시스템 종료
                        System.exit(0);
                    } else if (operator.equalsIgnoreCase("c")) {    //사용자가 c 입력 시 numbers 초기화, 첫 번째 숫자부터 재시작
                        numbers.clear();
                        break;
                    }
                    String operatorInput = parser.parseOperator(operator);
                    numbers.add(operatorInput);

                    System.out.println("다음 숫자를 입력하고 엔터");
                    String b = calculation.nextLine();
                    double secondInput = Double.parseDouble(parser.parseSecondNum(b));
                    numbers.add(String.valueOf(secondInput));

                    calc.calculate(numbers);
                    double result = calc.calculate(numbers);
                    System.out.println("계산결과: " + result);
                }
            }catch(BadInputException e){
                //에러 발생 시 List 초기화
                System.out.println(e.getMessage());
                numbers.clear();
            }
        }
    }
}

