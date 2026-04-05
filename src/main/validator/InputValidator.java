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

        if (Files.isDirectory(path)) {
            throw new exception.FileIsDirectoryException();
        }

        if (!Files.isRegularFile(path)) {
            throw new exception.FileProcessingException();
        }

        if (!Files.isReadable(path)) {
            throw new exception.FileReadException();
        }

        return path;
    }

    public static Path validateOutputPath(String outputPath) {
        Path path = parsePath(outputPath);

        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                return path;
            }

            if (!Files.isRegularFile(path)) {
                throw new exception.InvalidPathException();
            }

            if (!Files.isWritable(path)) {
                throw new exception.FileWriteException();
            }

            return path;
        }

        Path parent = path.getParent();

        if (parent == null || !Files.exists(parent) || !Files.isDirectory(parent)) {
            throw new exception.InvalidPathException();
        }

        if (!Files.isWritable(parent)) {
            throw new exception.FileWriteException();
        }

        return path;
    }

    private static Path parsePath(String pathString) {
        Path path;

        try {
            path = Path.of(pathString);
        } catch (java.nio.file.InvalidPathException e) {
            throw new exception.InvalidPathException();
        }

        String stringSeparator = Pattern.quote(FileSystems.getDefault().getSeparator());
        for (String part : pathString.split(stringSeparator)) {
            if (FORBIDDEN_DIR_FILES.contains(part)) {
                throw new exception.ForbiddenPathException();
            }
        }

        return path;
    }

    private InputValidator() {
    }
}