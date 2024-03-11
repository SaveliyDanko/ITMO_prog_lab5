package server;

import database.CollectionDataBase;
import server.collectiondatabasecommands.*;
import server.exceptions.ExitToMenuException;
import server.exceptions.UnknownCommandException;

/**
 * A class that analyzes user input
 */

public class CommandAnalyzer {

    /**
     * A function that processes input and defines commands
     * @param command current command
     * @throws ExitToMenuException exception, that discard user into menu
     */
    public static void analyze(String command) throws ExitToMenuException {
        CommandManager commandManager = CommandManager.getCommandManagerInstance();
        CollectionDataBase dataBase = CollectionDataBase.getDataBaseInstance();
        Command currentCommand = null;
        try {
            switch (command.split(" ")[0]){

                case "help": currentCommand = new HelpCommand(dataBase);
                break;

                case "info": currentCommand = new InfoCommand(dataBase);
                break;

                case "show": currentCommand = new ShowCommand(dataBase);
                break;

                case "insert": currentCommand = new InsertCommand(dataBase);
                break;

                case "update": currentCommand = new UpdateCommand(dataBase);
                break;

                case "remove": currentCommand = new RemoveCommand(dataBase);
                break;

                case "clear": currentCommand = new ClearCommand(dataBase);
                break;

                case "save": currentCommand = new SaveCommand(dataBase);
                break;

                case "execute_script": currentCommand = new ExecuteScriptCommand();
                break;

                case "exit": System.exit(0);
                break;

                case "remove_lower": currentCommand = new RemoveLowerCommand(dataBase);
                break;

                case "history": currentCommand = new HistoryCommand();
                break;

                case "remove_greater_key": currentCommand = new RemoveGreaterKeyCommand(dataBase);
                break;

                case "min_by_name": currentCommand = new MinByNameCommand(dataBase);
                break;

                case "count_by_transport": currentCommand = new CountByTransportCommand(dataBase);
                break;

                case "filter_starts_with_name": currentCommand = new FilterStartsWithName(dataBase);
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
