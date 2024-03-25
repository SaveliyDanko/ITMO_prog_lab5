package server.collectiondatabasecommands;


import client.MessageConstant;
import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;
import server.output.OutputManager;
import server.validators.IdValidator;

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
        if (args.length != 1){
            OutputManager.logError("Incorrect arguments // please try again or enter 'help' or 'exit command");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            Long id;
            if (IdValidator.validator(args[0])) {
                id = Long.parseLong(args[0]);
                if (dataBase.getDataBase().isEmpty()){
                    OutputManager.logError("You cannot delete object, because collection is empty");
                    OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
                }
                else {
                    if (dataBase.getDataBase().containsKey(id)){
                        dataBase.getDataBase().remove(id);
                        OutputManager.stOutput("The deletion was successful");
                        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
                    }
                    else {
                        OutputManager.logError("Invalid ID");
                        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
                    }
                }
            }
            else {
                OutputManager.logError("Invalid id, id must be positive long value");
                OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
            }
        }
    }

    @Override
    public String toString() {
        return "RemoveCommand";
    }
}
