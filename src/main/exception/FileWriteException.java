package exception;

public class FileWriteException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Не удалось записать файл";

    public FileWriteException() {
        super(ERROR_MESSAGE);
    }
}
