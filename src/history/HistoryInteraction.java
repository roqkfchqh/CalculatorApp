package history;

import exception.BadInputException;

import java.util.Scanner;

public class HistoryInteraction {
    private final History<Double, Double> history;
    private final HistoryInput historyInput;
    private final HistoryOutput historyOutput;
    private final Scanner scanner;

    public HistoryInteraction(History<Double, Double> history) {
        this.history = history;
        this.historyInput = new HistoryInput(history);
        this.historyOutput = new HistoryOutput();
        this.scanner = new Scanner(System.in);
    }

    //사용자에게 보이는 계산기록
    public void showHistory() throws BadInputException {
        historyOutput.displayAllHistory(history.getHistory());

        //전체 계산기록 보여준 후 사용자가 할 행동 받기
        String input = historyInput.getUserInput();

        //특수 명령어 처리
        if(input.equalsIgnoreCase("e")){
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }else if(input.equalsIgnoreCase("a")){
            System.out.println("계산기로 돌아갑니다.");

        //사용자에게 입력받은 string 으로 어떤 검색을 할 지 정함
        }else if(input.equalsIgnoreCase("id")){
            System.out.println("검색할 계산결과의 id를 입력해주세요.");
            String valueId = scanner.nextLine();
            historyInput.searchHandler("id", valueId);

        }else if(input.equalsIgnoreCase("r")){
            System.out.println("몇보다 큰 수를 찾으시겠습니까?");
            String valueResult = scanner.nextLine();
            historyInput.searchHandler("result", valueResult);

        }else if(input.equalsIgnoreCase("o")){
            System.out.println("검색할 계산결과의 연산자를 입력해주세요.");
            String valueOperator = scanner.nextLine();
            historyInput.searchHandler("operator", valueOperator);
        }else{
            System.out.println("❌유효하지 않은 입력입니다. 다시 입력해주세요.❌");
            showHistory();
        }
    }
}


