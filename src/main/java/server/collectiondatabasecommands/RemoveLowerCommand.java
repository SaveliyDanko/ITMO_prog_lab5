package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import database.models.Flat;
import server.exceptions.ExitToMenuException;
import server.modelinput.FlatInput;
import server.output.OutputManager;

/**
 * Remove Lower command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class RemoveLowerCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public RemoveLowerCommand(CollectionDataBase dataBase, String[] args){
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        if (args.length != 0){
            OutputManager.logError("Remove lower command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            Flat flat = FlatInput.input();
            dataBase.getDataBase().entrySet().removeIf(entry -> entry.getValue().compareTo(flat) < 0);
            OutputManager.stOutput("The deletion was successful");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "RemoveLowerCommand";
    }
}
