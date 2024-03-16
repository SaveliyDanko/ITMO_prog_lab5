package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

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
        dataBase.insert(args);
    }

    @Override
    public String toString() {
        return "InsertCommand";
    }
}