package server.collectiondatabasecommands;

import client.AppConfig;
import client.MessageConstant;
import database.CollectionDataBase;
import server.CsvFileManager;
import server.output.OutputManager;

/**
 * Save command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class SaveCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;
    public SaveCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() {
        if (args.length != 0){
            OutputManager.logError("Save command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            CsvFileManager.saveFlatToFile(dataBase.getDataBase(), AppConfig.csvFilePath);
            OutputManager.stOutput("The collection was successfully saved");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "SaveCommand";
    }
}
