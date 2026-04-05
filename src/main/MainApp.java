import config.Modes;
import exception.InvalidKeyException;
import exception.InvalidMenuChoiceException;
import model.BruteForceResult;

import java.nio.file.Path;
import java.util.Scanner;

import static service.BruteForceService.bruteForce;
import static service.CipherService.cipher;
import static service.FileService.readFile;
import static service.FileService.writeFile;
import static util.ConsoleHelper.*;
import static validator.InputValidator.validateInputPath;
import static validator.InputValidator.validateOutputPath;

public class MainApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                printMenu();
                int mode = readMenuChoice(s);
                if (mode == 0) {
                    printGoodbye();
                    break;
                }
                switch (mode) {
                    case 1 -> processCipher(s);
                    case 2 -> processDecipher(s);
                    case 3 -> processBruteforce(s);
                    default -> throw new InvalidMenuChoiceException();
                }
                printDivider();
            } catch (RuntimeException e) {
                printError(e.getMessage());
                printDivider();
            }
        }
    }

    private static void processCipher(Scanner s) {
        printScreenTitle(Modes.CIPHER.getTitle());
        askInputFilePath(Modes.CIPHER.getTitle());
        String input = processInput(s);
        askOutputFilePath(Modes.CIPHER.getTitle());
        String outputPath = processOutputPath(s);
        askKey();
        int key = readKey(s);
        String result = cipher(input, key);
        writeFile(outputPath, result);
        printSuccess(outputPath);
    }

    private static void processDecipher(Scanner s) {
        printScreenTitle(Modes.DECIPHER.getTitle());
        askInputFilePath(Modes.DECIPHER.getTitle());
        String input = processInput(s);
        askOutputFilePath(Modes.DECIPHER.getTitle());
        String outputPath = processOutputPath(s);
        askKey();
        int key = readKey(s);
        String result = cipher(input, -key);
        writeFile(outputPath, result);
        printSuccess(outputPath);
    }

    private static void processBruteforce(Scanner s) {
        printScreenTitle(Modes.BRUTEFORCE.getTitle());
        askInputFilePath(Modes.BRUTEFORCE.getTitle());
        String input = processInput(s);
        askOutputFilePath(Modes.BRUTEFORCE.getTitle());
        String outputPath = processOutputPath(s);
        BruteForceResult result = bruteForce(input);
        printBruteForceResult(result.getKey(), result.getScore());
        writeFile(outputPath, result.getText());
        printSuccess(outputPath);
    }

    private static String processInput(Scanner s) {
        String inputPath = s.nextLine();
        Path path = validateInputPath(inputPath);

        try {
            return readFile(path.toString());
        } catch (exception.FileReadException e) {
            throw new exception.FileProcessingException();
        }
    }

    private static String processOutputPath(Scanner s) {
        String outputPath = s.nextLine();
        Path path = validateOutputPath(outputPath);
        return path.toString();
    }

    // нет валидации на размер ключа -> нормализация встроена в логику шифра
    private static int readKey(Scanner s) {
        String input = s.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidKeyException();
        }
    }

    private static int readMenuChoice(Scanner s) {
        String input = s.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidMenuChoiceException();
        }
    }

    private MainApp() {

    }
}
