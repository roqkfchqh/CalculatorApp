import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {

    Calculator calc = new Calculator();

    private List<String> numbers = new ArrayList<>();

    public void start(){
        Scanner calculation = new Scanner(System.in);
        while(true){
            try{
                System.out.println("첫 번째 숫자를 입력하고 엔터");
                String a = calculation.nextLine();
                numbers.add(String.valueOf(a));

                while(true){
                    System.out.println("연산자(+,-,*,/)를 입력하고 엔터(또는 c:값 초기화, e:나가기, h: 히스토리)");
                    String operator = calculation.nextLine();
                    if (operator.equalsIgnoreCase("e")) {
                        Main.exit = false;
                    } else if (operator.equalsIgnoreCase("c")) {
                        break;
                    }
                    numbers.add(operator);

                    System.out.println("다음 숫자를 입력하고 엔터");
                    String b = calculation.nextLine();
                    numbers.add(String.valueOf(b));
                    calc.calculate(numbers);
                    double result = calc.calculate(numbers);
                    System.out.println("계산결과: " + calc.originNumber + operator + b + "=" + result);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

