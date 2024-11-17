package history;

import exception.BadInputException;

import java.util.Scanner;

public class UserInputHistory {
    private History<Double, Double> history;

    public UserInputHistory(History<Double, Double> history) {
        this.history = history;
    }

    //유저에게 보이는 계산기록
    public void showHistory() throws BadInputException {
        if(history.getHistory().isEmpty()){
            System.out.println("계산 기록이 존재하지 않습니다.");
            return;
        }

        System.out.println("\uD83D\uDD54\uD83D\uDD5B\uD83D\uDD67\uD83D\uDD50계산기록\uD83D\uDD5C\uD83D\uDD51\uD83D\uDD5D\uD83D\uDD52");

        //전체 계산기록 호출
        history.getHistory().forEach(data -> System.out.println(data.getString()));

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
        }else{
            //사용자가 입력한 값을 파라미터로 전송
            int historyIndex = Integer.parseInt(id);
            HistoryData data = history.getHistoryById(historyIndex);
            if(data == null){
                System.out.println("해당 ID의 기록이 존재하지 않습니다.");
            }else{
                System.out.println(historyIndex + "번 계산 결과 : " + data.getResult());
            }
        }
    }
}
