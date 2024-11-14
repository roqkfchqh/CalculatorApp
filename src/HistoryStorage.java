import java.util.List;

public interface HistoryStorage {
    double getFirstNumberValue();
    double getSecondNumberValue();
    String getOperator();
    List<String> saveHistory();
}
