package validator;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

import static config.Forbidden.FORBIDDEN_DIR_FILES;

public class InputValidator {

    public static Path validateInputPath(String inputPath) {
        Path path = parsePath(inputPath);

        if (!Files.exists(path)) {
            throw new exception.FileNotFoundException();
        }

        if (!Files.isRegularFile(path)) {
            throw new exception.InvalidPathException();
        }

        if (Files.isDirectory(path)) {
            throw new exception.FileIsDirectoryException();
        }

        if (!Files.isReadable(path)) {
            throw new exception.FileProcessingException();
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
            throw new exception.FileWriteException();
        }

        throw new exception.InvalidPathException();
    }

    private static Path parsePath(String pathString) {
        String stringSeparator = Pattern.quote(FileSystems.getDefault().getSeparator());
        for (String str : pathString.split(stringSeparator)) {
            if (FORBIDDEN_DIR_FILES.contains(str)) {
                throw new exception.ForbiddenPathException();
            }
        }

        try {
            return Path.of(pathString);
        } catch (java.nio.file.InvalidPathException e) {
            throw new exception.InvalidPathException();
        }
    }

    private InputValidator() {

    }
}