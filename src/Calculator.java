import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {

    private List<History> historyList = new LinkedList<>();

    public double calculate(List<String> calculationFormula){
        List<Double> numbers = IntStream.range(0, calculationFormula.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Double.parseDouble(calculationFormula.get(i)))
                .toList();

        List<String> operators = IntStream.range(0, calculationFormula.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(calculationFormula::get)
                .toList();

        return IntStream.range(0, operators.size())
                .mapToObj(i -> new Object[]{numbers.get(i), numbers.get(i + 1), operators.get(i)})
                .map(calculationArray -> {
                    double a = (double) calculationArray[0];
                    double b = (double) calculationArray[1];
                    String operator = (String) calculationArray[2];
                    Operation operation = Operation.fromSymbol(operator);
                    return operation.apply(a, b);
                })
                .reduce(numbers.get(0), (a, b) -> b);
    }
}