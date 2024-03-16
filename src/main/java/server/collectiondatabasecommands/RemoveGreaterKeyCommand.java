package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

/**
 * Remove Greater Key command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class RemoveGreaterKeyCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;
    public RemoveGreaterKeyCommand(CollectionDataBase dataBase, String[] args){
            this.dataBase = dataBase;
            this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.removeGreaterKey(args);
    }

    @Override
    public String toString() {
        return "RemoveGreaterKeyCommand";
    }
}
