package history;

import java.util.ArrayList;
import java.util.List;

public class History<N extends Number, R> {
    //제네릭을 사용했으나 연습용임, N과 R 둘 다 double
    public List<HistoryData> history;

    //계산 기록 별 고유 ID
    private int idNum = 1;

    public History(){
        this.history = new ArrayList<>();
    }

    //계산기록 저장
    public void saveHistory(N firstNumberValue, N secondNumberValue, String operator, R result){
        HistoryData data = new HistoryData(
                firstNumberValue.doubleValue(),
                secondNumberValue.doubleValue(),
                operator,
                ((Number) result).doubleValue(),
                idNum
        );
        history.add(data);
        idNum++;
    }

    //전체 기록 반환
    public List<HistoryData> getHistory(){
        return new ArrayList<>(history);
    }

    //특정Id 기록 조회
    public HistoryData getHistoryById(int id){
        return history.stream()
                .filter(data -> data.getIdNum() == id)
                .findFirst()
                .orElse(null);
    }
}
