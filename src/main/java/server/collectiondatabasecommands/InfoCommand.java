package server.collectiondatabasecommands;

import database.CollectionDataBase;

/**
 * Info command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class InfoCommand implements Command{
    CollectionDataBase dataBase;

    public InfoCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.info();
    }

    @Override
    public String toString() {
        return "InfoCommand";
    }
}
