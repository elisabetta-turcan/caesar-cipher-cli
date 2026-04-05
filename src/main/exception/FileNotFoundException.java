package main.exception;

public class FileNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Файл не найден";

    public FileNotFoundException() {
        super(ERROR_MESSAGE);
    }
}
