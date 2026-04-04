package main.validator;

import main.exception.FileProcessingException;
import main.exception.InvalidPathException;

import java.nio.file.Files;
import java.nio.file.Path;

public class InputValidator {
    public static void validateInputFile(Path path) {
        if (!Files.exists(path)) {
            throw new FileProcessingException();
        }
        if (Files.isDirectory(path)) {
            throw new InvalidPathException();
        }
    }

    private InputValidator() {

    }
}
