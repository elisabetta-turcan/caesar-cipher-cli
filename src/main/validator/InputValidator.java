package main.validator;

import java.nio.file.Files;
import java.nio.file.Path;

public class InputValidator {

    public static Path validateInputPath(String inputPath) {
        Path path = parsePath(inputPath);

        if (!Files.exists(path)) {
            throw new main.exception.FileNotFoundException();
        }

        if (!Files.isRegularFile(path)) {
            throw new main.exception.InvalidPathException();
        }

        if (Files.isDirectory(path)) {
            throw new main.exception.FileIsDirectoryException();
        }

        if (!Files.isReadable(path)) {
            throw new main.exception.FileProcessingException();
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

        if (!Files.isWritable(path)) {
            throw new main.exception.FileWiteException();
        }

        throw new main.exception.InvalidPathException();
    }

    private static Path parsePath(String pathString) {
        try {
            return Path.of(pathString);
        } catch (java.nio.file.InvalidPathException e) {
            throw new main.exception.InvalidPathException();
        }

        String stringSeparator = Pattern.quote(FileSystems.getDefault().getSeparator());
        for (String str : filename.split(stringSeparator)) {
            if (FORBIDDEN_DIR_FILES.contains(str)) {
                throw new main.exception.ForbiddenPathException();
            }
        }

    private InputValidator() {
        }
    }
}