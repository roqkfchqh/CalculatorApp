import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Calculator {

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
        AtomicReference<Double> result = new AtomicReference<>(numbers.get(0));

        //enum 으로 숫자와 연산자를 각각 보내서 계산
        IntStream.range(0, operators.size()).forEach(i -> {
            String operator = operators.get(i);
            Operation operation = Operation.fromSymbol(operator);
            double a = result.get();
            double b = numbers.get(i + 1);
            result.set(operation.apply(a, b));
        });
        //Atomic 변수에 result 값 할당
        return result.get();

    }
}