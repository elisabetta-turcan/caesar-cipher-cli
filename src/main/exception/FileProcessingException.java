package exception;

public class FileProcessingException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Не удалось прочитать файл";

    public FileProcessingException() {
        super(ERROR_MESSAGE);
    }
}
