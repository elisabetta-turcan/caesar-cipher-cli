package exception;

public class InvalidMenuChoiceException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Пункт отсутствует в меню";

    public InvalidMenuChoiceException() {
        super(ERROR_MESSAGE);
    }
}
