package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import server.output.OutputManager;

/**
 * Info command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class InfoCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public InfoCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() {
        if (args.length != 0){
            OutputManager.logError("Info command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            OutputManager.stOutput("Data Base type:" + dataBase.getDataBase().getClass().getName());
            OutputManager.stOutput("Data Base initialization time: " + dataBase.initializationTime);
            OutputManager.stOutput("The number of items in the collection: " + dataBase.getDataBase().size());
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "InfoCommand";
    }
}
