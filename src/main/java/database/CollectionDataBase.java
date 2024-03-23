package database;

import client.AppConfig;
import client.MessageConstant;
import server.output.OutputManager;
import database.models.Flat;
import database.models.Transport;
import server.CsvFileManager;
import server.exceptions.ExitToMenuException;
import server.modelinput.FlatInput;
import server.modelinput.TransportInput;
import server.validators.IdValidator;
import server.validators.NameValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The class that is responsible for implementing the database
 *
 * @since 1.0
 * @author savadanko
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
    public void help(String[] args){
        if (args.length != 0){
            OutputManager.logError("Help command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            OutputManager.stOutput(CollectionDataBaseHelpInformation.HELP_MESSAGE);
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    /**
     * info command realization
     */
    public void info(String[] args){
        if (args.length != 0){
            OutputManager.logError("Info command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            OutputManager.stOutput("Data Base type:" + collection.getClass().getName());
            OutputManager.stOutput("Data Base initialization time: " + initializationTime);
            OutputManager.stOutput("The number of items in the collection: " + collection.size());
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    /**
     * show command realization
     */
    public void show(String[] args){
        if (args.length != 0){
            OutputManager.logError("Show command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
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
    }

    /**
     * remove command realization
     */
    public void remove(String[] args) {
        if (args.length != 1){
            OutputManager.logError("Incorrect arguments // please try again or enter 'help' or 'exit command");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            Long id;
            if (IdValidator.validator(args[0])) {
                id = Long.parseLong(args[0]);
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

    /**
     * insert command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void insert(String[] args) throws ExitToMenuException {
        if (args.length != 0){
            OutputManager.logError("Insert command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            Flat flat = FlatInput.input();
            collection.put(flat.getId(), flat);
            OutputManager.stOutput("You have added a new Flat to the DataBase \n" +
                    MessageConstant.CONSOLE_MESSAGE);
        }
    }

    /**
     * clear command realization
     */
    public void clear(String[] args){
        if (args.length != 0){
            OutputManager.logError("Clear command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            collection.clear();
            OutputManager.stOutput("The collection has been successfully cleared\n" +
                    MessageConstant.CONSOLE_MESSAGE);
        }
    }

    /**
     * update command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void update(String[] args) throws ExitToMenuException {
        if (args.length != 1){
            OutputManager.logError("Incorrect arguments // please try again or enter 'help' or 'exit command");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            Long id;
            if (IdValidator.validator(args[0])){
                id = Long.parseLong(args[0]);
                if (collection.isEmpty()){
                    OutputManager.stOutput("DataBase is empty\n" +
                            MessageConstant.CONSOLE_MESSAGE);
                }
                else {
                    if (collection.containsKey(id)){
                        collection.put(id, FlatInput.input());
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

    /**
     * save command realization
     */
    public void save(String[] args){
        if (args.length != 0){
            OutputManager.logError("Save command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            CsvFileManager.saveFlatToFile(collection, AppConfig.csvFilePath);
            OutputManager.stOutput("The collection was successfully saved");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    /**
     * remove_lover command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public void remove_lover(String[] args) throws ExitToMenuException {
        if (args.length != 0){
            OutputManager.logError("Remove lower command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            Flat flat = FlatInput.input();
            collection.entrySet().removeIf(entry -> entry.getValue().compareTo(flat) < 0);
            OutputManager.stOutput("The deletion was successful");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    /**
     * remove_greater_key command realization
     */
    public void removeGreaterKey(String[] args){
        if (args.length != 1){
            OutputManager.logError("Incorrect arguments // please try again or enter 'help' or 'exit command");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            long id;
            if (IdValidator.validator(args[0])){
                id = Long.parseLong(args[0]);
                // Итерируемся по map с использованием Iterator
                // Удаляем элемент, если его ключ больше заданного
                collection.entrySet().removeIf(entry -> entry.getKey() > id);
                OutputManager.stOutput("The deletion was successful");
                OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
            }
            else {
                OutputManager.logError("Invalid id, id must be positive long value");
                OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
            }
        }
    }

    /**
     * min_by_name command realization
     */
    public void minByName(String[] args){
        if (args.length != 0){
            OutputManager.logError("Min By Name lower command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
            String minName = collection.sequencedValues().getFirst().getName();
                for (Flat flat : collection.values()){
                    if (flat.getName().compareTo(minName) < 0){
                        minName = flat.getName();
                    }
                }
                OutputManager.stOutput(minName);
                OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
    }

    /**
     * count_by_transport command realization
     * @throws ExitToMenuException exception, that discard user into menu
     */

    public void countByTransport(String[] args) throws ExitToMenuException {
        if (args.length != 0){
            OutputManager.logError("countByTransport command should not have arguments");
            OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
        }
        else {
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
    }

    /**
     * filter_starts_with_name command realization
     */
    public void filterStartsWithName(String[] args){
        if (args.length != 1){
            OutputManager.logError("Incorrect arguments // please try again or enter 'help' or 'exit command");
        }
        else {
            int c = 0;
            String name = args[0];
            if (NameValidator.validate(name)){
                for (Flat flat : collection.values()){
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
}
