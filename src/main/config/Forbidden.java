package config;

import java.util.List;

public class Forbidden {

    public static final List<String> FORBIDDEN_DIR_FILES = List.of(
            ".bash_history",
            ".bash_profile",
            ".bashrc",
            "etc",
            "proc",
            "System32",
            "Windows"
    );

    private Forbidden() {
    }
}