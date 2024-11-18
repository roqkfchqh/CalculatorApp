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

    //유저에게 보이는 계산기록
    public void showHistory() throws BadInputException {
        historyOutput.displayAllHistory(history.getHistory());
        String input = historyInput.getUserInput();

        if(input.equalsIgnoreCase("e")){
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }else if(input.equalsIgnoreCase("a")){
            System.out.println("계산기로 돌아갑니다.");

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


