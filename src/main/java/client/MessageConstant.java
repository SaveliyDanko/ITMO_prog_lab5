package client;

/**
 * A class that contains global text constants
 *
 * @since 1.0
 * @author savadanko
 */
public class MessageConstant {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static final String CONSOLE_MESSAGE = "Enter " + ANSI_PURPLE + "help" + ANSI_RESET + " command for command reference // Enter " + ANSI_PURPLE + "exit" + ANSI_RESET + " command for exit.";

    public static final String WELCOME_TO_CONSOLE = "Welcome to console Application";

    public static final String EXIT_TO_MENU = ANSI_RESET + "Exit to menu // Enter" + ANSI_PURPLE + " help " + ANSI_RESET +  "command for command reference // Enter" + ANSI_PURPLE +  " exit " + ANSI_RESET +  "command for exit.";

    public static final String VIEW_INPUT = """
                    Enter View number or `q` for exit:
                    1. STREET
                    2. YARD
                    3. PARK
                    4. NORMAL""";

    public static final String TRANSPORT_INPUT = """
                    Enter Transport number or `q` for exit:
                    1. FEW
                    2. NONE
                    3. LITTLE
                    4. NORMAL""";
}
