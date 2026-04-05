package exception;

public class FileProcessingException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Не удалось обработать файл";

    public FileProcessingException() {
        super(ERROR_MESSAGE);
    }
}
