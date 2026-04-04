package main.validator;

import java.nio.file.Files;
import java.nio.file.Path;

public class InputValidator {

    public static Path validateInputPath(String inputPath) {
        Path path = parsePath(inputPath);

        if (!Files.exists(path)) {
            throw new main.exception.InvalidPathException();
        }

        if (!Files.isRegularFile(path)) {
            throw new main.exception.InvalidPathException();
        }

        return path;
    }

    public static Path validateOutputPath(String outputPath) {
        Path path = parsePath(outputPath);

        if (Files.exists(path) && Files.isDirectory(path)) {
            return path;
        }

        if (outputPath.endsWith(".txt")) {
            return path;
        }

        throw new main.exception.InvalidPathException();
    }

    private static Path parsePath(String pathString) {
        try {
            return Path.of(pathString);
        } catch (java.nio.file.InvalidPathException e) {
            throw new main.exception.InvalidPathException();
        }
    }

    private InputValidator() {
    }
}
