package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

/**
 * Update command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class UpdateCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;


    public UpdateCommand(CollectionDataBase dataBase, String[] args) {
            this.dataBase = dataBase;
            this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.update(args);
    }
    @Override
    public String toString() {
        return "UpdateCommand";
    }
}
