package parser;

import exception.BadInputException;

import java.util.regex.Pattern;

public class Parser {
    //+, -, *, /, ^ 외에는 예외 처리
    private static final String OPERATION_REG = "[+\\-*/^]";
    //음수 포함 숫자 가능
    private static final String NUMBER_REG = "^-?[0-9]+$";

    public String parseNum(String number) throws BadInputException {
        boolean first = Pattern.matches(NUMBER_REG, number);
        if(!first){
            throw new BadInputException("숫자가 아닙니다.");
        }
        return number;
    }

    public String parseOperator(String operationInput) throws BadInputException {
        boolean operation = Pattern.matches(OPERATION_REG, operationInput);
        if(!operation){
            throw new BadInputException("올바른 연산자를 입력해주세요.");
        }
        return operationInput;
    }
}