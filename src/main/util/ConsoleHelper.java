package main.util;

public class ConsoleHelper {
    public static void printMenu() {
        System.out.println("""
                ╔══════════════════════════════════╗
                ║        (≧◡≦) ♡ Caesar App        ║
                ╠══════════════════════════════════╣
                ║  1. 🔐 Шифрование                ║
                ║  2. 🔓 Расшифровка               ║
                ║  3. 🧠 Brute Force               ║
                ║  0. 🚪 Выход                     ║
                ╠══════════════════════════════════╣
                ║  Введи номер и нажми Enter ⚡️    ║
                ╚══════════════════════════════════╝
                """);
    }

    public static void printScreenTitle(String title) {
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        String text = "⋆｡°✩ Режим " + title;
        System.out.printf("║ %-36s ║%n", text);
        System.out.println("╚══════════════════════════════════════╝");
    }

    public static void askInputFilePath(String action) {
        System.out.println("૮ ˶ᵔ ᵕ ᵔ˶ ა Введите путь к файлу для " + action);
    }

    public static void askOutputFilePath(String action) {
        System.out.println("૮ ˶ᵔ ᵕ ᵔ˶ ა Введите путь для сохранения результата " + action);
    }

    public static void askKey() {
        System.out.println("🔑 Введите ключ: ");
    }

    public static void printSuccess(String outputPath) {
        System.out.println("""
                ₍^. .^₎⟆
                Готово! Результат сохранён в файл или папку:
                """ + outputPath);
    }

    public static void printBruteForceResult(int key, int score) {
        System.out.println("🧠 Наиболее подходящий ключ: " + key);
        System.out.println("⭐ Оценка результата: " + score);
    }

    public static void printError(String message) {
        System.out.println("""
                (╥﹏╥)
                Ошибка:\n""" + message);
    }

    public static void printGoodbye() {
        System.out.println("""
                ｡･:*:･ﾟ★,｡･:*:･ﾟ☆
                Программа завершена. Пока-пока ♡
                """);
    }

    public static void printDivider() {
        System.out.println("────────────────────────────────────────");
    }

    private ConsoleHelper() {

    }
}
