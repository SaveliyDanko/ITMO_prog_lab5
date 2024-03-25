package server.collectiondatabasecommands;

import client.MessageConstant;
import database.CollectionDataBase;
import database.models.Flat;
import server.output.OutputManager;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Show command implementation for the Command design pattern
 *
 * @since 1.0
 * @author savadanko
 */
public class ShowCommand implements Command{
    CollectionDataBase dataBase;
    String[] args;

    public ShowCommand(CollectionDataBase dataBase, String[] args) {
        this.dataBase = dataBase;
        this.args = args;
    }

    @Override
    public void execute() {
        if (args.length != 0){
            OutputManager.logError("Show command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            if (!dataBase.getDataBase().isEmpty()){
                Map<Long, Flat> sortedMap = new TreeMap<>(dataBase.getDataBase());
                LinkedHashMap<Long, Flat> sortedLinkedHashMap = new LinkedHashMap<>(sortedMap);


                OutputManager.stOutput("Data Base elements:");
                for (Map.Entry<Long, Flat> item : sortedLinkedHashMap.entrySet()){
                    OutputManager.stOutput(item.toString());
                }
                OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
            }
            else OutputManager.stOutput("DataBase is empty\n" +
                    MessageConstant.CONSOLE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "ShowCommand";
    }
}
