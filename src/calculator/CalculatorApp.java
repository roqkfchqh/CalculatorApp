package calculator;

import exception.BadInputException;
import history.CheckHistory;
import history.History;
import parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    private final Calculator calc;
    private final CheckHistory check;

    public CalculatorApp() {
        History<Double, Double> history = new History<>();  //history.History 객체 생성
        calc = new Calculator(history); //calculator.Calculator 에 history.History 객체 전달
        check = new CheckHistory();
        check.setH(history);
    }
    Parser parser = new Parser();

    //calculator.Calculator class 에 사용되는 List 생성
    List<String> numbers = new ArrayList<>();

    public void start(){
        Scanner calculation = new Scanner(System.in);
        while(true){
            try{
                System.out.println("첫 번째 숫자를 입력하고 엔터");
                String a = calculation.nextLine();
                //parser 로 보내서 유효성 검사
                double firstNumber = Double.parseDouble(parser.parseNum(a));
                //exception.BadInputException 에러가 안 떳으면 List 에 값 저장
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
                        //여태 저장된 값 없애기
                        numbers.clear();
                        break;
                    } else if (operator.equalsIgnoreCase("h")) {
                        numbers.clear();
                        showHistory();
                        break;
                    }
                    String operatorInput = parser.parseOperator(operator);
                    numbers.add(operatorInput);

                    System.out.println("다음 숫자를 입력하고 엔터");
                    String b = calculation.nextLine();
                    double secondNumber = Double.parseDouble(parser.parseNum(b));
                    numbers.add(String.valueOf(secondNumber));

                    //0으로 나눌 경우
                    if(operator.equals("/") && secondNumber == 0){
                        numbers.clear();
                        System.out.println("0으로 나눌 수 없습니다");
                        break;
                    }

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

    //계산 기록 불러오기
    public void showHistory(){
        System.out.println("\uD83D\uDD54\uD83D\uDD5B\uD83D\uDD67\uD83D\uDD50계산기록\uD83D\uDD5C\uD83D\uDD51\uD83D\uDD5D\uD83D\uDD52");
        Scanner scanner = new Scanner(System.in);
        System.out.println("몇번 결과를 가져오시겠습니까? 숫자로 입력 (또는 a: 계산기로 돌아가기 e: 나가기");

        try{
            System.out.println("\uD83D\uDD66\uD83D\uDD58\uD83D\uDD54\uD83D\uDD5B\uD83D\uDD67\uD83D\uDD50\uD83D\uDD5C\uD83D\uDD51\uD83D\uDD5D\uD83D\uDD52\uD83D\uDD65");
            //history.CheckHistory class 에서 메서드 호출
            check.checkHistory();
            String id = scanner.nextLine();
            if(id.equalsIgnoreCase("e")){
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }else if(id.equalsIgnoreCase("a")){
                return;
            }else{
                //사용자가 입력한 값을 파라미터로 전송
                int historyIndex = Integer.parseInt(id);
                check.equalIdHistory(historyIndex);
            }
        }catch(BadInputException e){
            System.out.println("해당 계산 기록이 존재하지 않습니다.");
        }
    }
}

