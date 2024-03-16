package server.collectiondatabasecommands;

import client.MessageConstant;
import server.output.OutputManager;
import server.CommandManager;

/**
 * History command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class HistoryCommand implements Command{
    CommandManager commandManager;
    String[] args;
    public HistoryCommand(String[] args) {
        commandManager = CommandManager.getCommandManagerInstance();
        this.args = args;
    }


    @Override
    public void execute() {
        if (args.length != 0){
            OutputManager.logError("History command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            if (CommandManager.history.isEmpty()){
                OutputManager.stOutput("Commands history is empty");
            }
            else {
                commandManager.showHistory();
                OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
            }
        }
    }

    @Override
    public String toString() {
        return "HistoryCommand";
    }
}
