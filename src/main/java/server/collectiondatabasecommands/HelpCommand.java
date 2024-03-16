package server.collectiondatabasecommands;

import database.CollectionDataBase;

/**
 * Help command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class HelpCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public HelpCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute(){
        dataBase.help(args);
    }

    @Override
    public String toString() {
        return "HelpCommand";
    }
}
