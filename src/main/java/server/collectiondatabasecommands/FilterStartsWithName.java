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

    public FilterStartsWithName(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() throws ExitToMenuException {
        dataBase.filterStartsWithName();
    }

    @Override
    public String toString(){
        return "FilterStartsWithNameCommand";
    }
}
