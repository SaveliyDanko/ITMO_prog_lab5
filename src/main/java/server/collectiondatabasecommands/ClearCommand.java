package server.collectiondatabasecommands;

import database.CollectionDataBase;

/**
 * Clear command implementation for the Command design pattern
 */

public class ClearCommand implements Command{
    CollectionDataBase dataBase;

    public ClearCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.clear();
    }

    @Override
    public String toString() {
        return "ClearCommand";
    }
}
