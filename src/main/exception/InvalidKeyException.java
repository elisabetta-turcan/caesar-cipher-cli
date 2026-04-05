package exception;

public class InvalidKeyException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Введен некорректный ключ";

    public InvalidKeyException() {
        super(ERROR_MESSAGE);
    }
}
