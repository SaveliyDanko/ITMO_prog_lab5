package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import database.models.Flat;
import server.exceptions.ExitToMenuException;
import server.output.OutputManager;

/**
 * Min By Name command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class MinByNameCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;
    public MinByNameCommand(CollectionDataBase dataBase, String[] args) {
            this.dataBase = dataBase;
            this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        if (args.length != 0){
            OutputManager.logError("Min By Name lower command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            String minName = dataBase.getDataBase().values().stream().toList().getFirst().getName();
            for (Flat flat : dataBase.getDataBase().values()){
                if (flat.getName().compareTo(minName) < 0){
                    minName = flat.getName();
                }
            }
            OutputManager.stOutput(minName);
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "MinByNameCommand";
    }
}
