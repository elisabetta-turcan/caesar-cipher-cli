package main.exception;

public class FileProcessingException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Файл не найден";

    public FileProcessingException() {
        super(ERROR_MESSAGE);
    }
}
