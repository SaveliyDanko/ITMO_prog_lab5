package server.collectiondatabasecommands;

import client.MessageConstant;
import server.output.OutputManager;
import server.CommandManager;
import server.exceptions.ExitToMenuException;

/**
 * History command implementation for the Command design pattern
 */

public class HistoryCommand implements Command{
    CommandManager commandManager = CommandManager.getCommandManagerInstance();
    @Override
    public void execute() throws ExitToMenuException {
        if (CommandManager.history.isEmpty()){
            OutputManager.stOutput("Commands history is empty");
        }
        else {
            commandManager.showHistory();
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "HistoryCommand";
    }
}
