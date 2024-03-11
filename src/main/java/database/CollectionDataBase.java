package database;

import client.AppConfig;
import client.MessageConstant;
import server.OutputManager;
import database.models.Flat;
import database.models.Transport;
import server.CsvFileManager;
import server.exceptions.ExitToMenuException;
import server.inputs.FlatInput;
import server.inputs.IdInput;
import server.inputs.NameInput;
import server.inputs.TransportInput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The class that is responsible for implementing the database
 */

public class CollectionDataBase implements DataBaseI{

    /**
     * A collection that contains objects
     */
    private final LinkedHashMap<Long, Flat> collection = new LinkedHashMap<>();

    /**
     * Date and Time initialization
     */
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
    LocalDateTime now = LocalDateTime.now();
    String initializationTime = now.format(formatter);

    // Singleton realization
    private static final CollectionDataBase dataBaseInstance = new CollectionDataBase();
    private CollectionDataBase() {}
    public static CollectionDataBase getDataBaseInstance() {
        return dataBaseInstance;
    }

    /**
     * get collection
     * @return collection
     */
    public LinkedHashMap<Long, Flat> getDataBase() {
        return collection;
    }

    /**
     * help command realization
     */
    public void help(){
        OutputManager.stOutput(CollectionDataBaseHelpInformation.HELP_MESSAGE);
        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
    }

    /**
     * info command realization
     */
    public void info(){
        OutputManager.stOutput("Data Base type:" + collection.getClass().getName());
        OutputManager.stOutput("Data Base initialization time: " + initializationTime);
        OutputManager.stOutput("The number of items in the collection: " + collection.size());
        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
    }

    /**
     * show command realization
     */
    public void show(){
        if (!collection.isEmpty()){
            Map<Long, Flat> sortedMap = new TreeMap<>(collection);
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

    /**
     * insert command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void insert() throws ExitToMenuException {
        Flat flat = FlatInput.input();
        collection.put(flat.getId(), flat);
        OutputManager.stOutput("You have added a new Flat to the DataBase \n" +
                MessageConstant.CONSOLE_MESSAGE);
    }

    /**
     * remove command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void remove() throws ExitToMenuException {
        Long id = IdInput.idInput();
        if (collection.isEmpty()){
            OutputManager.logError("You cannot delete object, because collection is empty");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            if (collection.containsKey(id)){
                collection.remove(id);
                OutputManager.stOutput("The deletion was successful");
                OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
            }
            else OutputManager.logError("Invalid ID\n" +
                    MessageConstant.CONSOLE_MESSAGE);
        }
    }

    /**
     * clear command realization
     */
    public void clear(){
        collection.clear();
        OutputManager.stOutput("The collection has been successfully cleared\n" +
                MessageConstant.CONSOLE_MESSAGE);
    }

    /**
     * update command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void update() throws ExitToMenuException{
        Long id = IdInput.idInput();
        if (collection.isEmpty()){
            OutputManager.stOutput("DataBase is empty\n" +
                    MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            if (collection.containsKey(id)){
                collection.put(id, FlatInput.input());
                OutputManager.stOutput("The item with ID = " + id + "has been successfully updated.\n" +
                        MessageConstant.CONSOLE_MESSAGE);
            }
            else OutputManager.logError("ID with this value does not exist\n" +
                    MessageConstant.CONSOLE_MESSAGE);
        }
    }

    /**
     * save command realization
     */
    public void save(){
        CsvFileManager.saveFlatToFile(collection, AppConfig.csvFilePath);
        OutputManager.stOutput("The collection was successfully saved");
        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
    }

    /**
     * remove_lover command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void remove_lover() throws ExitToMenuException {
        Flat flat = FlatInput.input();
        collection.entrySet().removeIf(entry -> entry.getValue().compareTo(flat) < 0);
        OutputManager.stOutput("The deletion was successful");
        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
    }

    /**
     * remove_greater_key command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void removeGreaterKey() throws ExitToMenuException {
        long id = IdInput.idInput();
        for (long i : collection.keySet()){
            if (i > id){
                collection.remove(i);
            }
        }
        OutputManager.stOutput("The deletion was successful");
        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
    }

    /**
     * min_by_name command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void minByName() throws ExitToMenuException {
        String minName = "No such Name";
        String name = NameInput.flat();
        for (Flat flat : collection.values()){
            if (flat.getName().compareTo(name) < 0){
                minName = flat.getName();
            }
        }
        OutputManager.stOutput(minName);
        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
    }

    /**
     * count_by_transport command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */

    public void countByTransport() throws ExitToMenuException {
        Transport transport = TransportInput.transportInput();
        long transportCount = 0;
        for (Flat flat : collection.values()){
            if (flat.getTransport().equals(transport)){
                transportCount++;
            }
        }

        OutputManager.stOutput(Long.toString(transportCount));
        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
    }

    /**
     * filter_starts_with_name command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void filterStartsWithName() throws ExitToMenuException {
        String name = NameInput.flat();
        for (Flat flat : collection.values()){
            if (flat.getName().startsWith(name)){
                OutputManager.stOutput(flat.getName());
            }
        }
        OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
    }
}
