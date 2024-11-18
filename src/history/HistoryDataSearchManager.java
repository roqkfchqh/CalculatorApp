package history;

import exception.BadInputException;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class HistoryDataSearchManager {

    private static final Map<String, Function<Object, Predicate<HistoryData>>> conditionMap = Map.of(
            "id", value -> history -> history.getIdNum() == (double) value,
            "result", value -> history -> history.getResult() >= (double) value,
            "operator", value -> history -> history.getOperator().equals(value)
    );

    Predicate<HistoryData> createCondition(String type, Object value) throws BadInputException {
        Function<Object, Predicate<HistoryData>> condition = conditionMap.get(type);
        if(condition == null) {
            throw new BadInputException("❌유효하지 않은 검색 타입입니다.❌");
        }
        return condition.apply(value);
    }


}
