public class CheckHistory {

    private History<Double, Double> h;

    public void setH(History h) {
        this.h = h;
    }

    public void checkHistory() throws BadInputException {
        if(this.h == null){
            throw new BadInputException("계산기록이 존재하지 않습니다.");
        }
        if (this.h.getHistory().isEmpty()) {
            throw new BadInputException("계산 기록이 존재하지 않습니다.");
        }

        for(HistoryData data : this.h.getHistory()){
            System.out.println(
                    data.getFirstNumber() + " " + data.getOperator() + " " +
                    data.getSecondNumber() + " = " + data.getResult());
        }
    }


}
