package server.collectiondatabasecommands;


import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

/**
 * Remove command implementation for the Command design pattern
 */
public class RemoveCommand implements Command{
    CollectionDataBase dataBase;

    public RemoveCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.remove();
    }

    @Override
    public String toString() {
        return "RemoveCommand";
    }
}
