package history;

import exception.BadInputException;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class HistoryInput {
    private static final String DECOR = "\uD83D\uDD66\uD83D\uDD58\uD83D\uDD54\uD83D\uDD5B\uD83D\uDD67\uD83D\uDD50\uD83D\uDD5C\uD83D\uDD51\uD83D\uDD5D\uD83D\uDD52\uD83D\uDD65";
    private final Scanner scanner;
    private final HistoryDataSearchManager searchManager;
    private final HistoryDataSearch dataSearch;
    private final History<Double, Double> history;

    public HistoryInput(History<Double, Double> history) {
        this.history = history;
        this.scanner = new Scanner(System.in);
        this.searchManager = new HistoryDataSearchManager();
        this.dataSearch = new HistoryDataSearch(history.getHistory());
    }

    public String getUserInput(){
        System.out.println("\uD83D\uDD0D기록 검색기: 원하시는 검색 기능을 선택해주세요 (또는 a:계산기로 돌아가기 e:나가기)");
        System.out.println("\uD83D\uDD0Did: 특정 계산값 불러오기, r: 특정 값보다 큰 계산결과 불러오기, o: 특정 연산자를 사용한 계산 불러오기");
        System.out.println(DECOR);
        String input = scanner.nextLine();
        if(input.isEmpty()){
            System.out.println("❌입력값이 비어 있습니다. 다시 시도해주세요.❌");
            return getUserInput();
        }
        return input;
    }

    void searchHandler(String type, String input) throws BadInputException {
        Object value = switch(type){
            case "id", "result" -> Double.parseDouble(input);
            case "operator" -> input;
            default -> throw new BadInputException("❌유효하지 않은 검색입니다.❌");
        };
        try{
            Predicate<HistoryData> condition = searchManager.createCondition(type, value);
            List<HistoryData> result = dataSearch.search(condition, history.getHistory());

            if(result.isEmpty()){
                System.out.println("❌조건에 맞는 결과가 없습니다.❌");
            }else{
                result.forEach(data -> System.out.println(data.getString()));
            }
        }catch(BadInputException e){
            System.out.println("❌유효하지 않은 입력입니다.❌");
        }
    }
}
