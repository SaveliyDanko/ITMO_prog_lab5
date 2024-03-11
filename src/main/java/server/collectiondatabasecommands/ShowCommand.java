package server.collectiondatabasecommands;

import database.CollectionDataBase;

/**
 * Show command implementation for the Command design pattern
 */
public class ShowCommand implements Command{
    CollectionDataBase dataBase;

    public ShowCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.show();
    }

    @Override
    public String toString() {
        return "ShowCommand";
    }
}
