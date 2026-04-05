package config;

public enum Modes {
    CIPHER("шифрования"),
    DECIPHER("расшифровки"),
    BRUTEFORCE("brute force");

    private final String title;

    Modes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
