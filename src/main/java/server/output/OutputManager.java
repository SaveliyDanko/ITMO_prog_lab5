package server.output;

/**
 * The class that is responsible for outputting information to the console
 *
 * @since 1.0
 * @author savadanko
 */

public class OutputManager {
    private static final String ANSI_RED = "\u001B[31m";
    private final static String ANSI_RESET = "\u001B[0m";

    /**
     * The function that is responsible for error output*
     * @param errorMessage describes the error
     */
    public static void logError(String errorMessage){
        System.out.println(ANSI_RED + errorMessage + ANSI_RESET);
    }

    /**
     * The function that is responsible for the standard output to the console*
     * @param message describes the output
     */
    public static void stOutput(String message){
            System.out.println(message);
    }
}
