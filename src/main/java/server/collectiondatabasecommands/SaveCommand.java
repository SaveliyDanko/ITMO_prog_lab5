package server.collectiondatabasecommands;

import database.CollectionDataBase;

/**
 * Save command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class SaveCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;
    public SaveCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() {
        dataBase.save(args);
    }

    @Override
    public String toString() {
        return "SaveCommand";
    }
}
