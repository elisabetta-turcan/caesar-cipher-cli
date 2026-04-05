package main.config;

public class Forbidden {

    private static final List<String> FORBIDDEN_DIR_FILES = List.of(
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