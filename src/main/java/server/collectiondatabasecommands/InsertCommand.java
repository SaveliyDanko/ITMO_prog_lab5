package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import database.models.Flat;
import server.exceptions.ExitToMenuException;
import server.modelinput.FlatInput;
import server.output.OutputManager;

/**
 * Insert command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class InsertCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public InsertCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        if (args.length != 0){
            OutputManager.logError("Insert command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            Flat flat = FlatInput.input();
            dataBase.getDataBase().put(flat.getId(), flat);
            OutputManager.stOutput("You have added a new Flat to the DataBase \n" +
                    MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "InsertCommand";
    }
}