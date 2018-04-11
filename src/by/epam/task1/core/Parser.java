package by.epam.task1.core;

public abstract class Parser {

    public static String[] parseSemicolon(String string) {
        return string.split(";");
    }

    public static String[] parseColon(String string) {
        return string.split(":");
    }

    public static String[] parseComma(String string) {
        return string.split(",");
    }

    public static String[] parseEqually(String string) {
        return string.split("=");
    }
}
