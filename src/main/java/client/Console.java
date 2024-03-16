package client;

import server.*;
import server.exceptions.ExitToMenuException;
import server.input.CurrentInputMode;
import server.input.EInputMode;
import server.input.InputModeAnalyzer;
import server.input.UserInputSource;
import server.output.OutputManager;


/**
 * A class for interpreting the user console
 */

public class Console {

    /**
     * Function that starts the console
     */
    public static void start(){
        if (AppConfig.appArgs.length != 1){
            OutputManager.logError("Invalid File Path. File path must consist one argument. Try again");
            System.exit(0);
        }
        else {
            AppConfig.csvFilePath = AppConfig.appArgs[0];
            CsvFileManager.collectionFiller(AppConfig.csvFilePath);

            CurrentInputMode.mode = EInputMode.USER_MODE;
            CurrentInputMode.userInputSource = new UserInputSource();
            OutputManager.stOutput(MessageConstant.WELCOME_TO_CONSOLE);
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
            while (CurrentInputMode.hasNextLine()){
                try {
                    String line = CurrentInputMode.getNextLine();
                    InputModeAnalyzer.analyze(line);
                }
                catch (ExitToMenuException e){
                    OutputManager.logError(e.getMessage());
                }
            }
        }
    }
}
