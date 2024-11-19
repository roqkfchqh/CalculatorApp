package history;

import java.util.List;
import java.util.function.Predicate;

public class HistoryDataSearch implements HistorySearch {
    private final List<HistoryData> history;

    public HistoryDataSearch(List<HistoryData> history) {
        this.history = history;
    }

    //HistorySearch 구현체
    //HistoryCondition 에서 받은 조건대로 현재 history 에서 filtering 함
    @Override
    public List<HistoryData> search(Predicate<HistoryData> condition, List<HistoryData> history){
        return history.stream()
                .filter(condition)
                .toList();
    }
}
