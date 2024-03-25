package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import server.exceptions.ExitToMenuException;
import server.modelinput.FlatInput;
import server.output.OutputManager;
import server.validators.IdValidator;

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
        if (args.length != 1){
            OutputManager.logError("Incorrect arguments // please try again or enter 'help' or 'exit command");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            Long id;
            if (IdValidator.validator(args[0])){
                id = Long.parseLong(args[0]);
                if (dataBase.getDataBase().isEmpty()){
                    OutputManager.stOutput("DataBase is empty\n" +
                            MessageConstant.CONSOLE_MESSAGE);
                }
                else {
                    if (dataBase.getDataBase().containsKey(id)){
                        dataBase.getDataBase().put(id, FlatInput.input());
                        OutputManager.stOutput("The item with ID = " + id + " has been successfully updated.\n" +
                                MessageConstant.CONSOLE_MESSAGE);
                    }
                    else {
                        OutputManager.logError("ID with this value does not exist");
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
        return "UpdateCommand";
    }
}
