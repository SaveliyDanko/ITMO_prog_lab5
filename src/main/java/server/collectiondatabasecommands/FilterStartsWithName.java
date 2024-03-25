package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import database.models.Flat;
import server.exceptions.ExitToMenuException;
import server.output.OutputManager;
import server.validators.NameValidator;

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
        if (args.length != 1){
            OutputManager.logError("Incorrect arguments // please try again or enter 'help' or 'exit command");
        }
        else {
            int c = 0;
            String name = args[0];
            if (NameValidator.validate(name)){
                for (Flat flat : dataBase.getDataBase().values()){
                    if (flat.getName().startsWith(name)){
                        c ++;
                        OutputManager.stOutput(flat.getName());
                    }
                }
                if (c == 0){
                    OutputManager.stOutput("No such same");
                }
                OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
            }
            else {
                OutputManager.logError("Incorrect name");
            }
        }
    }

    @Override
    public String toString(){
        return "FilterStartsWithNameCommand";
    }
}
