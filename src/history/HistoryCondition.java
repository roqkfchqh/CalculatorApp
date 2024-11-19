package history;

import exception.BadInputException;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class HistoryCondition {

    //전달받은 string 값을 토대로 value 를 통해 기록 검색 조건 도출
    private static final Map<String, Function<Object, Predicate<HistoryData>>> conditionMap = Map.of(
            "id", value -> history -> history.getIdNum() == (double) value,
            "result", value -> history -> history.getResult() >= (double) value,
            "operator", value -> history -> history.getOperator().equals(value)
    );

    //map 에서 검색조건을 받아서 null 이라면 예외처리, 비어있지 않다면 조건 반환
    Predicate<HistoryData> createCondition(String type, Object value) throws BadInputException {
        Function<Object, Predicate<HistoryData>> condition = conditionMap.get(type);
        if (condition == null) {
            throw new BadInputException("❌유효하지 않은 검색 타입입니다.❌");
        }
        return condition.apply(value);
    }
}
