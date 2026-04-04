package main.service;

import java.util.HashMap;
import java.util.Map;

import static main.config.Alphabet.ALPHABET;

public class CipherService {

    private static final Map<Character, Integer> ALPHABET_INDEX = new HashMap<>();

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            ALPHABET_INDEX.put(ALPHABET[i], i);
        }
    }

    public static String cipher(String input, int key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char originalChar = input.charAt(i);
            boolean isUpperCase = Character.isUpperCase(originalChar);

            char lowerChar = Character.toLowerCase(originalChar);
            Integer inputCharIndex = ALPHABET_INDEX.get(lowerChar);

            if (inputCharIndex != null) {
                int outputCharIndex = (inputCharIndex + key + ALPHABET.length) % ALPHABET.length;
                char resultChar = ALPHABET[outputCharIndex];

                if (isUpperCase) {
                    resultChar = Character.toUpperCase(resultChar);
                }

                output.append(resultChar);
            } else {
                output.append(originalChar);
            }
        }

        return output.toString();
    }

    private CipherService() {

    }
}