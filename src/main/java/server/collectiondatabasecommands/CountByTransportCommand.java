package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

public class CountByTransportCommand implements Command{
    CollectionDataBase dataBase;

    public CountByTransportCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.countByTransport();
    }

    @Override
    public String toString() {
        return "CountByTransportCommand";
    }
}
