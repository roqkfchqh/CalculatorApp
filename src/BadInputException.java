import java.lang.Exception;

public class BadInputException extends Exception {
    public BadInputException(String message) {
        super("잘못된 입력입니다! " + message);
    }
}
