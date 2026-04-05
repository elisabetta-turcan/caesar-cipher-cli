package service;

import exception.FileReadException;
import exception.FileWriteException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public static String readFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FileReadException();
        }
    }

    public static void writeFile(String filePath, String output) {
        try {
            Path path = Paths.get(filePath);
            if (Files.isDirectory(path)) {
                path = path.resolve("output.txt");
            }
            Files.writeString(path, output);
        } catch (IOException e) {
            throw new FileWriteException();
        }
    }

    private FileService() {

    }
}