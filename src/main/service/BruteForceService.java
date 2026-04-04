package main.service;

import main.model.BruteForceResult;

import static main.config.Alphabet.ALPHABET;
import static main.config.ScoringRules.PATTERNS;
import static main.service.CipherService.cipher;

public class BruteForceService {

    public static BruteForceResult bruteForce(String input) {
        int bestScore = Integer.MIN_VALUE;
        String bestOutput = "";
        int bestKey = 0;

        for (int i = 0; i < ALPHABET.length; i++) {
            String output = cipher(input, -i);
            int score = calculateScore(output);

            if (score > bestScore) {
                bestScore = score;
                bestOutput = output;
                bestKey = i;
            }
        }

        return new BruteForceResult(bestOutput, bestKey, bestScore);
    }

    public static int calculateScore(String output) {
        int score = 0;

        for (var entry : PATTERNS.entrySet()) {
            score += countOccurrences(output, entry.getKey()) * entry.getValue();
        }

        return score;
    }

    private static int countOccurrences(String text, String pattern) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index += pattern.length();
        }
        return count;
    }

    private BruteForceService() {

    }
}