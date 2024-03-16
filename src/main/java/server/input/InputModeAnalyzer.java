package server.input;

import server.CommandAnalyzer;
import server.CommandManager;
import server.collectiondatabasecommands.ExecuteScriptCommand;
import server.exceptions.ExitToMenuException;
import java.io.File;

/**
 * The class that is responsible for analyzing the current input mode
 *
 * @since 1.0
 * @author savadanko
 */

public class InputModeAnalyzer {

    /**
     * A function that is responsible for analyzing and changing the current input mode
     * @param command current command
     * @throws ExitToMenuException exception, that discard user to menu
     */
    public static void analyze(String command) throws ExitToMenuException {
        String line;
        if (command.split(" ").length == 2 && command.split(" ")[0].equals("execute_script")){
                CurrentInputMode.mode = EInputMode.FILE_MODE;
                File file = new File(command.split(" ")[1]);
                CurrentInputMode.fileInputSource = new FileInputSource(file);
                CommandManager.history.push(new ExecuteScriptCommand());
                while (true){
                    if (CurrentInputMode.hasNextLine()){
                        line = CurrentInputMode.getNextLine();
                        CommandAnalyzer.analyze(line);
                    }
                    else {
                        CurrentInputMode.mode = EInputMode.USER_MODE;
                        break;
                    }
                }
        }
        else {
            CurrentInputMode.mode = EInputMode.USER_MODE;
            CommandAnalyzer.analyze(command);
            }
        }
    }
