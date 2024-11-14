import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Calculator {

    public double calculate(List<String> calculationFormula) {
        List<Double> numbers = IntStream.range(0, calculationFormula.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Double.parseDouble(calculationFormula.get(i)))
                .toList();

        List<String> operators = IntStream.range(0, calculationFormula.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(calculationFormula::get)
                .toList();

        AtomicReference<Double> result = new AtomicReference<>(numbers.get(0));

        IntStream.range(0, operators.size()).forEach(i -> {
            String operator = operators.get(i);
            Operation operation = Operation.fromSymbol(operator);
            double a = result.get();
            double b = numbers.get(i + 1);
            result.set(operation.apply(a, b));
        });
        return result.get();
    }
}