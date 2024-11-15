package calculator;

import history.History;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Calculator {
    //history.History 객체 선언
    private History<Double, Double> history;
    //생성자에서 history.History 객체 받아 초기화
    public Calculator(History<Double, Double> history) {
        this.history = history;
    }

    //calculator.Calculator App 의 number List 를 calculationFormula 로 명명
    public double calculate(List<String> calculationFormula) {

        //numbers List 에 있는 짝수번째 값 -> 숫자
        List<Double> numbers = IntStream.range(0, calculationFormula.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Double.parseDouble(calculationFormula.get(i)))
                .toList();

        //numbers List 에 있는 홀수번째 값 -> 연산자
        List<String> operators = IntStream.range(0, calculationFormula.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(calculationFormula::get)
                .toList();

        //Atomic 변수로 연속 계산을 위한 이전 계산 결과 저장
        //첫 a의 값은 List 의 첫번째 값이어야 하므로 초기값에 numbers.get(0)
        AtomicReference<Double> result = new AtomicReference<>(numbers.get(0));

        IntStream.range(0, operators.size()).forEach(i -> {
            //a의 값은 항상 Atomic 변수로부터 받아옴
            double firstNumber = result.get();
            double secondNumber = numbers.get(i + 1);
            String operator = operators.get(i);

            //enum 으로 숫자와 연산자를 각각 보내서 계산
            Operation operation = Operation.fromSymbol(operator);
            //set 으로 Atomic 변수에 연산 결과값 할당
            result.set(operation.apply(firstNumber, secondNumber));

            //history 저장
            if(i == operators.size() - 1) {
                history.saveHistory(firstNumber, secondNumber, operator, result.get());
            }
        });
        //현재 저장된 값 cmd 반환
        return result.get();
    }
}