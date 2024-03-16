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
    String[] args;

    public InfoCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() {
        dataBase.info(args);
    }

    @Override
    public String toString() {
        return "InfoCommand";
    }
}
