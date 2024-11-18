package calculator;

import parser.Parser;

import exception.BadInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorInput {
    private final Scanner scanner = new Scanner(System.in);
    private final Parser parser = new Parser();
    private final List<String> numbers = new ArrayList<>();

    //유저 입력 받기
    double getNumbers(String sentense) throws BadInputException {
        System.out.println(sentense);
        String input = scanner.nextLine();
        double number = Double.parseDouble(parser.parseNum(input));
        numbers.add(String.valueOf(number));
        return number;
    }

    String getOperator(String sentense) throws BadInputException {
        System.out.println(sentense);
        String input = scanner.nextLine();

        //특수 명령어 처리
        if (input.equalsIgnoreCase("c")) {
            numbers.clear();
            throw new BadInputException("계산을 처음부터 시작합니다");
        } else if (input.equalsIgnoreCase("h")) {
            numbers.clear();
            return "h";
        } else if (input.equalsIgnoreCase("e")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        String operator = parser.parseOperator(input);
        numbers.add(operator);
        return operator;
    }

    //리스트 반환
    public List<String> getNumbers() {
        return new ArrayList<>(numbers);
    }

    //유저 입력 리스트 초기화
    public void clearNumbers(){
        numbers.clear();
    }
}
