package client;

import server.*;
import server.exceptions.ExitToMenuException;

/**
 * A class for interpreting the user console
 */

public class Console {

    /**
     * Function that starts the console
     */
    public static void start(){
        if (AppConfig.appArgs.length != 1){
            OutputManager.logError("Invalid File Path. Try again");
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
