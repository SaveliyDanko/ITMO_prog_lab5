package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import database.CollectionDataBaseHelpInformation;
import server.output.OutputManager;

/**
 * Help command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class HelpCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public HelpCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute(){
        if (args.length != 0){
            OutputManager.logError("Help command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            OutputManager.stOutput(CollectionDataBaseHelpInformation.HELP_MESSAGE);
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "HelpCommand";
    }
}
