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
    String[] args;
    public CountByTransportCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.countByTransport(args);
    }

    @Override
    public String toString() {
        return "CountByTransportCommand";
    }
}
