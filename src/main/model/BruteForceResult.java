package main.model;

public class BruteForceResult {
    private final String text;
    private final int key;
    private final int score;

    public BruteForceResult(String text, int key, int score) {
        this.text = text;
        this.key = key;
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public int getKey() {
        return key;
    }

    public int getScore() {
        return score;
    }
}
