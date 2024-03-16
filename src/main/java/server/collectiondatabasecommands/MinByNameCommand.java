package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

/**
 * Min By Name command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class MinByNameCommand implements Command{
    CollectionDataBase dataBase;

    public MinByNameCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.minByName();
    }

    @Override
    public String toString() {
        return "MinByNameCommand";
    }
}
