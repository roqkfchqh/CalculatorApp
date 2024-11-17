package history;

import exception.BadInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class History<N extends Number, R> {
    //제네릭을 사용했으나 연습용임, N과 R 둘 다 double
    private List<HistoryData> history;
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

    //유저에게 보이는 계산기록
    public void showHistory() throws BadInputException {
        if(history.isEmpty()){
            System.out.println("계산 기록이 존재하지 않습니다.");
            return;
        }

        System.out.println("\uD83D\uDD54\uD83D\uDD5B\uD83D\uDD67\uD83D\uDD50계산기록\uD83D\uDD5C\uD83D\uDD51\uD83D\uDD5D\uD83D\uDD52");

        //전체 계산기록 호출
        getHistory().stream()
                .map(HistoryData::getString)
                .forEach(System.out::println);

        //유저에게 id 값 입력받음
        Scanner scanner = new Scanner(System.in);
        System.out.println("몇번 결과를 가져오시겠습니까? 숫자로 입력 (또는 a: 계산기로 돌아가기 e: 나가기");
        System.out.println("\uD83D\uDD66\uD83D\uDD58\uD83D\uDD54\uD83D\uDD5B\uD83D\uDD67\uD83D\uDD50\uD83D\uDD5C\uD83D\uDD51\uD83D\uDD5D\uD83D\uDD52\uD83D\uDD65");
        String id = scanner.nextLine();

        if(id.equalsIgnoreCase("e")){
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }else if(id.equalsIgnoreCase("a")){
            System.out.println("첫 화면으로 돌아갑니다.");
            return;
        }else{
            //사용자가 입력한 값을 파라미터로 전송
            int historyIndex = Integer.parseInt(id);
            HistoryData data = getHistoryById(historyIndex);
            if(data == null){
                System.out.println("해당 ID의 기록이 존재하지 않습니다.");
            }else{
                System.out.println(historyIndex + "번 계산 결과 : " + data.getResult());
            }
        }
    }
}
