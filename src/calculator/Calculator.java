package calculator;

import history.History;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Calculator {
    private final History<Double, Double> history;
    public Calculator(History<Double, Double> history) {
        this.history = history;
    }

    //Calculator App 의 number List 를 calculationFormula 로 명명
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

            //문자열을 Operator 로 변환
            String operatorSymbol = operators.get(i);
            Operator enumOperator = Operator.fromSymbol(operatorSymbol);
            //fromEnum 에 Operator 전달 후 알맞은 연산법 가져옴
            Operation operation = Operation.fromEnum(enumOperator);

            //set 으로 Atomic 변수에 연산 결과값 할당 (다음 연속 계산을 위해)
            result.set(operation.apply(firstNumber, secondNumber));

            //history 저장
            if(i == operators.size() - 1) {
                history.saveHistory(firstNumber, secondNumber, operatorSymbol, result.get());
            }
        });
        //현재 저장된 값 cmd 반환
        return result.get();
    }
}