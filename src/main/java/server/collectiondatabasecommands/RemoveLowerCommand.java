package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

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
        dataBase.remove_lover(args);
    }

    @Override
    public String toString() {
        return "RemoveLowerCommand";
    }
}
