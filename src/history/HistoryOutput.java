package history;

import java.util.List;

public class HistoryOutput {
    private static final String DECOR = "\uD83D\uDD54\uD83D\uDD5B\uD83D\uDD67\uD83D\uDD50계산기록\uD83D\uDD5C\uD83D\uDD51\uD83D\uDD5D\uD83D\uDD52";

    //모든 저장된 계산 기록을 불러오는 메서드
    public void displayAllHistory(List<HistoryData> history){
        if(history.isEmpty()){
            System.out.println("❌계산 기록이 존재하지 않습니다.❌");
        }else{
            System.out.println(DECOR);
            history.forEach(data -> System.out.println(data.getString()));
        }
    }
}
