package server.collectiondatabasecommands;

import database.CollectionDataBase;

/**
 * Help command implementation for the Command design pattern
 */

public class HelpCommand implements Command{
    CollectionDataBase dataBase;

    public HelpCommand(CollectionDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute(){
        dataBase.help();
    }

    @Override
    public String toString() {
        return "HelpCommand";
    }
}
