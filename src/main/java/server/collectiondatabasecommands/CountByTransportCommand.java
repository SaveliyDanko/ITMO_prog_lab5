package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

/**
 * Count by transport command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

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
