package nims;

import java.io.PrintStream;

public class Util {
    public enum Color {
        BLACK(30), RED(31), GREEN(32), YELLOW(33), BLUE(34), MAGENTA(35), CYAN(36), WHITE(37);

        private final int val;

        Color(int val) {
            this.val = val;
        }

        public int getVal() {
            return this.val;
        }
    }

    private static final char ESC = '\033';

    public static void clearScreen(PrintStream ps) {
        ps.print(ESC + "[2J");
        ps.print(ESC + "[H");
    }

    public static void setColor(PrintStream ps, Color color) {
        ps.print(ESC + "[" + color.getVal() + "m");
    }

    public static String setColor(Color color) {
        return ESC + "[" + color.getVal() + "m";
    }

    public static void invertFgBg(PrintStream ps) {
        ps.print(ESC + "[7m");
    }

    public static String invertFgBg() {
        return (ESC + "[7m");
    }

    public static void setBold(PrintStream ps) {
        ps.print(ESC + "[1m");
    }

    public static String setBold() {
        return (ESC + "[1m");
    }

    public static void clearFormatting(PrintStream ps) {
        ps.print(ESC + "[0m");
    }

    public static String clearFormatting() {
        return (ESC + "[0m");
    }
}
