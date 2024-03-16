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

    public UpdateCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.update();
    }
    @Override
    public String toString() {
        return "UpdateCommand";
    }
}
