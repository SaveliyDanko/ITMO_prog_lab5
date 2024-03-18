package server;

import database.CollectionDataBase;
import server.collectiondatabasecommands.*;
import server.exceptions.ExitToMenuException;
import server.exceptions.UnknownCommandException;
import server.output.OutputManager;

import java.util.Arrays;

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
        CollectionDataBase dataBase = CollectionDataBase.getDataBaseInstance();
        Command currentCommand = null;

        String[] commandArgs = Arrays.copyOfRange(line.split(" "), 1, line.split(" ").length);
        try {
            switch (line.split(" ")[0]){

                case "help": currentCommand = new HelpCommand(dataBase, commandArgs);
                break;

                case "info": currentCommand = new InfoCommand(dataBase, commandArgs);
                break;

                case "show": currentCommand = new ShowCommand(dataBase, commandArgs);
                break;

                case "insert": currentCommand = new InsertCommand(dataBase, commandArgs);
                break;

                case "update": currentCommand = new UpdateCommand(dataBase, commandArgs);
                break;

                case "remove_key": currentCommand = new RemoveCommand(dataBase, commandArgs);
                break;

                case "clear": currentCommand = new ClearCommand(dataBase, commandArgs);
                break;

                case "save": currentCommand = new SaveCommand(dataBase, commandArgs);
                break;

                case "exit": System.exit(0);
                break;

                case "execute_script": currentCommand = new ExecuteScriptCommand(commandArgs);
                break;

                case "remove_lower": currentCommand = new RemoveLowerCommand(dataBase, commandArgs);
                break;

                case "history": currentCommand = new HistoryCommand(commandArgs);
                break;

                case "remove_greater_key": currentCommand = new RemoveGreaterKeyCommand(dataBase, commandArgs);
                break;

                case "min_by_name": currentCommand = new MinByNameCommand(dataBase, commandArgs);
                break;

                case "count_by_transport": currentCommand = new CountByTransportCommand(dataBase, commandArgs);
                break;

                case "filter_starts_with_name": currentCommand = new FilterStartsWithName(dataBase, commandArgs);
                break;

                default: throw new UnknownCommandException("Unknown command // please try again or enter 'help' or 'exit command");
            }

            commandManager.setCommand(currentCommand);
            commandManager.executeCommand();
        }
        catch (UnknownCommandException e){
            OutputManager.logError(e.getMessage());
        }
    }
}
