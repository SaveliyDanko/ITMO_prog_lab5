package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import database.models.Flat;
import database.models.Transport;
import server.exceptions.ExitToMenuException;
import server.modelinput.TransportInput;
import server.output.OutputManager;

/**
 * Count by transport command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */

public class CountByTransportCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;
    public CountByTransportCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        if (args.length != 0){
            OutputManager.logError("countByTransport command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            Transport transport = TransportInput.transportInput();
            long transportCount = 0;
            for (Flat flat : dataBase.getDataBase().values()){
                if (flat.getTransport().equals(transport)){
                    transportCount++;
                }
            }

            OutputManager.stOutput(Long.toString(transportCount));
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "CountByTransportCommand";
    }
}
