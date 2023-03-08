package org.darkdev5.lib.console;

import org.darkdev5.lib.console.exception.UnsupportedConsoleException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class Console {
    public static final String RESET = "\u001b[0m";
    public static final String BLACK = "\u001b[0;30m";
    public static final String RED = "\u001b[0;31m";
    public static final String GREEN = "\u001b[0;32m";
    public static final String YELLOW = "\u001b[0;33m";
    public static final String BLUE = "\u001b[0;34m";
    public static final String PURPLE = "\u001b[0;35m";
    public static final String CYAN = "\u001b[0;36m";
    public static final String WHITE = "\u001b[0;37m";
    public static final String BLACK_BOLD = "\u001b[1;30m";
    public static final String RED_BOLD = "\u001b[1;31m";
    public static final String GREEN_BOLD = "\u001b[1;32m";
    public static final String YELLOW_BOLD = "\u001b[1;33m";
    public static final String BLUE_BOLD = "\u001b[1;34m";
    public static final String PURPLE_BOLD = "\u001b[1;35m";
    public static final String CYAN_BOLD = "\u001b[1;36m";
    public static final String WHITE_BOLD = "\u001b[1;37m";
    public static final String BLACK_UNDERLINED = "\u001b[4;30m";
    public static final String RED_UNDERLINED = "\u001b[4;31m";
    public static final String GREEN_UNDERLINED = "\u001b[4;32m";
    public static final String YELLOW_UNDERLINED = "\u001b[4;33m";
    public static final String BLUE_UNDERLINED = "\u001b[4;34m";
    public static final String PURPLE_UNDERLINED = "\u001b[4;35m";
    public static final String CYAN_UNDERLINED = "\u001b[4;36m";
    public static final String WHITE_UNDERLINED = "\u001b[4;37m";
    public static final String BLACK_BRIGHT = "\u001b[0;90m";
    public static final String RED_BRIGHT = "\u001b[0;91m";
    public static final String GREEN_BRIGHT = "\u001b[0;92m";
    public static final String YELLOW_BRIGHT = "\u001b[0;93m";
    public static final String BLUE_BRIGHT = "\u001b[0;94m";
    public static final String PURPLE_BRIGHT = "\u001b[0;95m";
    public static final String CYAN_BRIGHT = "\u001b[0;96m";
    public static final String WHITE_BRIGHT = "\u001b[0;97m";
    public static final String BLACK_BOLD_BRIGHT = "\u001b[1;90m";
    public static final String RED_BOLD_BRIGHT = "\u001b[1;91m";
    public static final String GREEN_BOLD_BRIGHT = "\u001b[1;92m";
    public static final String YELLOW_BOLD_BRIGHT = "\u001b[1;93m";
    public static final String BLUE_BOLD_BRIGHT = "\u001b[1;94m";
    public static final String PURPLE_BOLD_BRIGHT = "\u001b[1;95m";
    public static final String CYAN_BOLD_BRIGHT = "\u001b[1;96m";
    public static final String WHITE_BOLD_BRIGHT = "\u001b[1;97m";

    /**
     * Print text to the console screen and don't go to the next line.
     *
     * @param input The object you send will convert to String.
     */
    public static void print(Object input) {
        System.out.print(input);
    }

    /**
     * Print text to the console screen and go to the next line.
     *
     * @param input The object you send will convert to the String.
     */
    public static void println(Object input) {
        System.out.println(input);
    }

    /**
     * Prints entire list to the console screen.
     *
     * @param list       The list you want to print.
     * @param lineNumber Enable this if you want to show the line numbers.
     * @param nextLine   Set this true to go to next line.
     */
    public static void printList(List<String> list, boolean lineNumber, boolean nextLine) {
        for (int i = 0; i < list.size(); i++) {
            if (lineNumber) {
                System.out.printf("[%d] ", i + 1);
            }

            System.out.print(list.get(i));

            if (nextLine) {
                System.out.println();
            }
        }
    }

    /**
     * Print sequence of characters to the console screen.
     *
     * @param c        The character you want to print.
     * @param len      The number of times that print must be repeated.
     * @param nextLine Enable this if you want to go to the next line after printing completed.
     */
    public static void printCharacters(char c, int len, boolean nextLine) {
        for (int i = 0; i < len; i++) {
            System.out.print(c);
        }

        if (nextLine) {
            System.out.println();
        }
    }

    /**
     * Clears screen with limited of lines.
     *
     * @param line The lines you want to push text to the top.
     */
    public static void clear(int line) {
        for (int i = 0; i < line; i++) {
            System.out.println();
        }
    }

    /**
     * Print message and wait for the user to press enter from the keyboard.
     */
    public static void pressEnter() {
        System.out.println("Press enter to continue!...");
        new Scanner(System.in).nextLine();
    }

    /**
     * Print message and wait for the user to press enter from the keyboard.
     *
     * @param message The message you want to print before user hits enter.
     */
    public static void pressEnter(String message) {
        System.out.println(message);
        new Scanner(System.in).nextLine();
    }

    /**
     * Ask user if he/she sure about continue to do something.
     *
     * @param message The message you want to say to the user.
     * @param repeat  Enable this if user enters incorrect option and repeat process.
     * @return Returns true if user selects yes otherwise it will return false.
     */
    public static boolean sure(String message, boolean repeat) {
        String answer = null;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.printf("%s [Y/N]: ", message);
            answer = scanner.nextLine();

            switch (answer.toLowerCase()) {
                case "y" -> {
                    return true;
                }

                case "n" -> {
                    return false;
                }
            }
        } while (repeat);

        return false;
    }

    /**
     * Ask user multiple options and wait for user to select one of it.
     *
     * @param message The message you want to say to the user.
     * @param options The options you want user to select one of them.
     * @param repeat  Enable this if user enters incorrect option and repeat process.
     * @return Returns the index of selected option or -1 if none of them were true.
     */
    public static int ask(String message, List<String> options, boolean repeat) {
        String answer = null;

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(message).append(" [");

        for (int i = 0; i < options.size(); i++) {
            sb.append(options.get(i));

            if (i + 1 < options.size()) {
                sb.append(",");
            }
        }

        sb.append("]: ");

        do {
            System.out.print(sb);
            answer = scanner.nextLine();

            if (options.contains(answer)) {
                return options.indexOf(answer) + 1;
            }
        } while (repeat);

        return -1;
    }

    /**
     * Reads password from terminal without showing user.
     *
     * @return Returns the input get from user.
     */
    public String read() {
        return read("", false);
    }

    /**
     * Reads password from terminal without showing user.
     *
     * @param message The message you want to show the user before reading input.
     * @return Returns the input get from user.
     */
    public String read(String message) {
        return read(message, false);
    }

    /**
     * Reads password from terminal without showing user.
     *
     * @param message The message you want to show the user before reading input.
     * @param trim    Enable this if you want to cut invalid spaces at the end of input.
     * @return Returns the input get from user.
     */
    public String read(String message, boolean trim) {
        String input = null;
        Scanner sc = new Scanner(System.in);

        System.out.print(message);
        input = sc.nextLine();

        if (trim) {
            input = input.trim();
        }

        return input;
    }

    /**
     * Reads password from terminal without showing user.
     *
     * @return Returns the input get from user.
     * @throws UnsupportedConsoleException Throws exception if current console is not supported for reading password.
     */
    public String readPassword() throws UnsupportedConsoleException {
        return readPassword("", false);
    }

    /**
     * Reads password from terminal without showing user.
     *
     * @param message The message you want to show the user before reading input.
     * @return Returns the input get from user.
     * @throws UnsupportedConsoleException Throws exception if current console is not supported for reading password.
     */
    public String readPassword(String message) throws UnsupportedConsoleException {
        return readPassword(message, false);
    }

    /**
     * Reads password from terminal without showing user.
     *
     * @param message The message you want to show the user before reading input.
     * @param trim    Enable this if you want to cut invalid spaces at the end of input.
     * @return Returns the input get from user.
     * @throws UnsupportedConsoleException Throws exception if current console is not supported for reading password.
     */
    public String readPassword(String message, boolean trim) throws UnsupportedConsoleException {
        String input = null;
        StringBuilder sb = new StringBuilder();

        java.io.Console console = System.console();
        Scanner sc = new Scanner(System.in);

        if (console == null) {
            throw new UnsupportedConsoleException("This console is not supported for reading password.");
        }

        System.out.print(message);
        for (char ch : console.readPassword()) {
            sb.append(ch);
        }

        input = sb.toString();

        if (trim) {
            input = input.trim();
        }

        return input;
    }
}
