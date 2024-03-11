package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

public class RemoveGreaterKeyCommand implements Command{
    CollectionDataBase dataBase;

    public RemoveGreaterKeyCommand(CollectionDataBase dataBase){
        this.dataBase = dataBase;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.removeGreaterKey();
    }

    @Override
    public String toString() {
        return "RemoveGreaterKeyCommand";
    }
}
