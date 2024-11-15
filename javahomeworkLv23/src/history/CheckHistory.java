package history;

import exception.BadInputException;

public class CheckHistory {

    private History<Double, Double> h;

    public void setH(History h) {
        this.h = h;
    }

    //계산 기록 불러오는 메서드
    public void checkHistory() throws BadInputException {
        if(this.h == null){
            throw new BadInputException("계산 기록이 존재하지 않습니다.");
        }
        if (this.h.getHistory().isEmpty()) {
            throw new BadInputException("계산 기록이 존재하지 않습니다.");
        }

        for(HistoryData data : this.h.getHistory()){
            System.out.println(
                    data.getIdNum() + ") " +
                    data.getFirstNumber() + " " + data.getOperator() + " " +
                    data.getSecondNumber() + " = " + data.getResult());
        }
    }

    //사용자에게 입력받은 id 를 가진 기록 불러오기 메서드
    public void equalIdHistory(int id) throws BadInputException {
        boolean equal = false;
        for(HistoryData data : this.h.getHistory()){
            if(data.getIdNum() == id){
                System.out.println(id + "번 계산결과: " + data.getResult());
                return;
            }
        }
        if(!equal){
            throw new BadInputException("해당 id의 기록이 존재하지 않습니다");
        }
    }
}
