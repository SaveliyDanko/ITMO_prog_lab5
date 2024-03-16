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
    String[] args;
    public MinByNameCommand(CollectionDataBase dataBase, String[] args) {
            this.dataBase = dataBase;
            this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.minByName(args);
    }

    @Override
    public String toString() {
        return "MinByNameCommand";
    }
}
