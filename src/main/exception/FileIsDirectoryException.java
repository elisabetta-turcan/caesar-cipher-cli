package main.exception;

public class FileIsDirectoryException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Указан путь к папке, а не файлу";

    public FileIsDirectoryException() {
        super(ERROR_MESSAGE);
    }
}
