import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    private History<Double, Double> history;
    private Calculator calc;
    private CheckHistory check;

    public CalculatorApp() {
        history = new History<>();  //History 객체 생성
        calc = new Calculator(history); //Calculator 에 History 객체 전달
        check = new CheckHistory();
        check.setH(history);
    }
    Parser parser = new Parser();

    //Calculator class 에 사용되는 List 생성
    List<String> numbers = new ArrayList<>();

    public void start(){
        Scanner calculation = new Scanner(System.in);
        while(true){
            try{
                System.out.println("첫 번째 숫자를 입력하고 엔터");
                String a = calculation.nextLine();
                //parser 로 보내서 유효성 검사
                double firstNumber = Double.parseDouble(parser.parseNum(a));
                //BadInputException 에러가 안 떳으면 List 에 값 저장
                numbers.add(String.valueOf(firstNumber));

                //연속 계산 while 문으로 처리
                while(true){
                    System.out.println("연산자(+,-,*,/)를 입력하고 엔터(또는 c:값 초기화, e:나가기, h: 히스토리)");
                    String operator = calculation.nextLine();
                    //사용자가 e 입력 시 시스템 종료
                    if (operator.equalsIgnoreCase("e")) {
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                        //사용자가 c 입력 시 numbers 초기화, 첫 번째 숫자부터 재시작
                    } else if (operator.equalsIgnoreCase("c")) {
                        numbers.clear();
                        break;
                    } else if (operator.equalsIgnoreCase("h")) {
                        showHistory();
                        break;
                    }
                    String operatorInput = parser.parseOperator(operator);
                    numbers.add(operatorInput);

                    System.out.println("다음 숫자를 입력하고 엔터");
                    String b = calculation.nextLine();
                    double secondNumber = Double.parseDouble(parser.parseNum(b));
                    numbers.add(String.valueOf(secondNumber));

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

    public void showHistory(){
        System.out.println("\uD83D\uDD54\uD83D\uDD5B\uD83D\uDD67\uD83D\uDD50계산기록\uD83D\uDD5C\uD83D\uDD51\uD83D\uDD5D\uD83D\uDD52");
        Scanner scanner = new Scanner(System.in);
        System.out.println("몇번 결과를 가져오시겠습니까? 숫자로 입력 (또는 a: 계산기로 돌아가기 e: 나가기");
        try{
            check.checkHistory();
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("e")){
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }else if(input.equalsIgnoreCase("a")){
                return;
            }else{
                int historyIndex = Integer.parseInt(input);
            }
        }catch(BadInputException e){
            System.out.println("계산 기록이 존재하지 않습니다.");
        }
        System.out.println("\uD83D\uDD66\uD83D\uDD58\uD83D\uDD54\uD83D\uDD5B\uD83D\uDD67\uD83D\uDD50\uD83D\uDD5C\uD83D\uDD51\uD83D\uDD5D\uD83D\uDD52\uD83D\uDD65");
    }
}

