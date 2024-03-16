package server.collectiondatabasecommands;


import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

/**
 * Remove command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class RemoveCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public RemoveCommand(CollectionDataBase dataBase, String[] args) {
            this.dataBase = dataBase;
            this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.remove(args);
    }

    @Override
    public String toString() {
        return "RemoveCommand";
    }
}
