package server.collectiondatabasecommands;

import client.MessageConstant;
import server.CurrentInputMode;
import server.EInputMode;
import server.OutputManager;
import server.exceptions.ExitToMenuException;

/**
 * Execute script command implementation for the Command design pattern
 */

public class ExecuteScriptCommand implements Command{
    @Override
    public void execute() throws ExitToMenuException {
        if (CurrentInputMode.mode.equals(EInputMode.USER_MODE)) {
            OutputManager.stOutput("You need to enter execute file");
        } else {
            OutputManager.logError("For avoid recursion you cannot use `execute_script` command in script file");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString(){
        return "ExecuteScriptCommand";
    }
}
