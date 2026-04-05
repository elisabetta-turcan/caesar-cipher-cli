package config;

import java.util.Map;

public class ScoringRules {
    public static final Map<String, Integer> PATTERNS = Map.ofEntries(
            Map.entry(" ", 1),
            Map.entry(" и ", 8),
            Map.entry(" в ", 7),
            Map.entry(" не ", 7),
            Map.entry(" на ", 6),
            Map.entry(" что ", 10),
            Map.entry("  ", -3),
            Map.entry("ъъ", -5),
            Map.entry("ьь", -5),
            Map.entry("йй", -3),
            Map.entry(",,", -3),
            Map.entry("!!", -1),
            Map.entry("??", -1)
    );

    private ScoringRules() {

    }
}
