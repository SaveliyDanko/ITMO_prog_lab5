package server.collectiondatabasecommands;

import database.CollectionDataBase;

/**
 * Show command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class ShowCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public ShowCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() {
        dataBase.show(args);
    }

    @Override
    public String toString() {
        return "ShowCommand";
    }
}
