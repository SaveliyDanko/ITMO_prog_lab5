package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

/**
 * Insert command implementation for the Command design pattern
 */
public class InsertCommand implements Command{
    CollectionDataBase dataBase;

    public InsertCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.insert();
    }

    @Override
    public String toString() {
        return "InsertCommand";
    }
}