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

    public RemoveLowerCommand(CollectionDataBase dataBase){
        this.dataBase = dataBase;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.remove_lover();
    }

    @Override
    public String toString() {
        return "RemoveLowerCommand";
    }
}
