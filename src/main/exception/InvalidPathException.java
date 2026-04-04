package main.exception;

public class InvalidPathException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Некорректно указан путь к файлу";

    public InvalidPathException() {
        super(ERROR_MESSAGE);
    }
}
