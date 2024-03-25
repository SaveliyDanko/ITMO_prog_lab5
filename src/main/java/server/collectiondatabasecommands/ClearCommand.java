package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import server.output.OutputManager;

/**
 * Clear command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class ClearCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public ClearCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() {
        if (args.length != 0){
            OutputManager.logError("Clear command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            dataBase.getDataBase().clear();
            OutputManager.stOutput("The collection has been successfully cleared\n" +
                    MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "ClearCommand";
    }
}
