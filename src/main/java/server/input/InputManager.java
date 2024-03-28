package server.input;

/**
 * A class that contains information about the current mode of input and output
 *
 * @since 1.0
 * @author savadanko
 */

public class InputManager {
    public static EInputMode mode;

    public static UserInputSource userInputSource;
    public static FileInputSource fileInputSource;

    /**
     * A function that returns the next line of input depending on the input mode
     * @return next input line
     */
    public static String getNextLine(){
        if (mode.equals(EInputMode.USER_MODE)){
            return userInputSource.getNextLine();
        }
        else return fileInputSource.getNextLine();
    }

    /**
     * A function that checks for input depending on the input status
     * @return true, if exist next input line
     */
    public static boolean hasNextLine(){
        if (mode.equals(EInputMode.USER_MODE)){
            return userInputSource.hasNextLine();
        }
        else return fileInputSource.hasNextLine();
    }
}
