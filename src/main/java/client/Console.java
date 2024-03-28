package client;

import server.*;
import server.exceptions.ExitToMenuException;
import server.input.InputManager;
import server.input.EInputMode;
import server.input.UserInputSource;
import server.output.OutputManager;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * A class for interpreting the user console
 */

public class Console {

    /**
     * Function that starts the console
     */
    public static void start() {
        if (AppConfig.appArgs.length != 1){
            OutputManager.logError("Invalid File Path. File path must consist one argument. Try again");
            System.exit(0);
        }
        else {
            String classLocation = Console.class.getProtectionDomain().getCodeSource().getLocation().toString();
            classLocation = classLocation.substring(5);
            LinkedList<String> array = new LinkedList<>(List.of(classLocation.split(Pattern.quote(File.separator))));
            array.removeLast();
            classLocation = String.join(File.separator, array);
            AppConfig.csvFilePath = classLocation + File.separator + AppConfig.appArgs[0];
            CsvFileManager.collectionFiller(AppConfig.csvFilePath);

            InputManager.mode = EInputMode.USER_MODE;
            InputManager.userInputSource = new UserInputSource();
            OutputManager.stOutput(MessageConstant.WELCOME_TO_CONSOLE);
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
            while (InputManager.hasNextLine()){
                try {
                    String line = InputManager.getNextLine();
                    CommandAnalyzer.analyze(line);
                }
                catch (ExitToMenuException e){
                    OutputManager.logError(e.getMessage());
                }
            }
        }
    }
}