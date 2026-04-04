package main.exception;

public class FileReadException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Не удалось прочитать файл";

    public FileReadException() {
        super(ERROR_MESSAGE);
    }
}
