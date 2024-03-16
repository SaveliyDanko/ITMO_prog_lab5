package server.collectiondatabasecommands;

import database.CollectionDataBase;

/**
 * Clear command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class ClearCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public ClearCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() {
        dataBase.clear(args);
    }

    @Override
    public String toString() {
        return "ClearCommand";
    }
}
