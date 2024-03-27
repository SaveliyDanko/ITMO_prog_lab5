package server;

import database.CollectionDataBase;
import server.collectiondatabasecommands.*;
import server.exceptions.ExitToMenuException;
import server.exceptions.UnknownCommandException;
import server.output.OutputManager;

import java.util.Arrays;
import java.util.HashMap;

/**
 * A class that analyzes user input
 *
 * @since 1.0
 * @author savadanko
 */

public class CommandAnalyzer {
    /**
     * A function that processes input and defines commands
     *
     * @param line current user input
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public static void analyze(String line) throws ExitToMenuException{

        CommandManager commandManager = CommandManager.getCommandManagerInstance();
        Command currentCommand;

        HashMap<String, Command> commandHashMap = new HashMap<>();

        CollectionDataBase dataBase = CollectionDataBase.getDataBaseInstance();

        String[] commandArgs = Arrays.copyOfRange(line.split(" "), 1, line.split(" ").length);

        commandHashMap.put("help", new HelpCommand(dataBase, commandArgs));
        commandHashMap.put("info", new InfoCommand(dataBase, commandArgs));
        commandHashMap.put("show", new ShowCommand(dataBase, commandArgs));
        commandHashMap.put("insert", new InsertCommand(dataBase, commandArgs));
        commandHashMap.put("update", new UpdateCommand(dataBase, commandArgs));
        commandHashMap.put("remove_key", new RemoveCommand(dataBase, commandArgs));
        commandHashMap.put("clear", new ClearCommand(dataBase, commandArgs));
        commandHashMap.put("save", new SaveCommand(dataBase, commandArgs));
        commandHashMap.put("remove_lower", new RemoveLowerCommand(dataBase, commandArgs));
        commandHashMap.put("min_by_name", new MinByNameCommand(dataBase, commandArgs));
        commandHashMap.put("remove_greater_key", new RemoveGreaterKeyCommand(dataBase, commandArgs));
        commandHashMap.put("count_by_transport", new CountByTransportCommand(dataBase, commandArgs));
        commandHashMap.put("filter_starts_with_name", new FilterStartsWithName(dataBase, commandArgs));
        commandHashMap.put("history", new HistoryCommand(commandArgs));
        commandHashMap.put("execute_script", new ExecuteScriptCommand(commandArgs));
        commandHashMap.put("exit", new ExitCommand());

        try {
            if (commandHashMap.containsKey(line.split(" ")[0])){
                currentCommand = commandHashMap.get(line.split(" ")[0]);
                commandManager.setCommand(currentCommand);
                commandManager.executeCommand();
            }
            else {
                throw new UnknownCommandException("Unknown command // please try again or enter 'help' or 'exit command");
            }
        }

        catch (UnknownCommandException e){
            OutputManager.logError(e.getMessage());
        }
    }
}
