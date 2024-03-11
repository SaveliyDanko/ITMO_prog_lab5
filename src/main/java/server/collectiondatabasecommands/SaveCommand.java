package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

/**
 * Save command implementation for the Command design pattern
 */
public class SaveCommand implements Command{
    CollectionDataBase dataBase;

    public SaveCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.save();
    }

    @Override
    public String toString() {
        return "SaveCommand";
    }
}
