package server.collectiondatabasecommands;

import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;

/**
 * Filter Starts With Name command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class FilterStartsWithName implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public FilterStartsWithName(CollectionDataBase dataBase, String[] args) {
            this.dataBase = dataBase;
            this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.filterStartsWithName(args);
    }

    @Override
    public String toString(){
        return "FilterStartsWithNameCommand";
    }
}
