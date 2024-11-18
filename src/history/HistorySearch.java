package history;

import java.util.List;
import java.util.function.Predicate;

public interface HistorySearch {
    List<HistoryData> search(Predicate<HistoryData> condition, List<HistoryData> history);
}