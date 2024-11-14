public class DivideOperation extends AbstractOperation {
    @Override
    public double operate(double firstNumber, double secondNumber) {
        if(secondNumber == 0){
            throw new ArithmeticException("0으로 나눌 순 없습니다.");
        }
        return firstNumber / secondNumber;
    }
}
