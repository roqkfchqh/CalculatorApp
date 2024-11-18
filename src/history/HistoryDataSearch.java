package history;

import java.util.List;
import java.util.function.Predicate;

public class HistoryDataSearch implements HistorySearch {
    private final List<HistoryData> history;

    public HistoryDataSearch(List<HistoryData> history) {
        this.history = history; // 원본 리스트를 참조
    }

    @Override
    public List<HistoryData> search(Predicate<HistoryData> condition, List<HistoryData> history){
        return history.stream()
                .filter(condition)
                .toList();
    }
}
