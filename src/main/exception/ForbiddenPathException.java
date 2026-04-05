package main.exception;

public class ForbiddenPathException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Введенный путь содержит запрещенный фрагмент";

    public FileIsDirectoryException() {
        super(ERROR_MESSAGE);
    }
}
