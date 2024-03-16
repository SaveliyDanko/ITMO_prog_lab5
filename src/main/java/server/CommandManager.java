package server;

import server.collectiondatabasecommands.Command;
import server.exceptions.ExitToMenuException;
import server.output.OutputManager;

import java.util.ArrayList;

/**
 * A class that implements the design pattern of the command and
 *
 * @since 1.0
 * @author savadanko
 */

public class CommandManager {
    // Singleton realization
    private static final CommandManager commandManagerInstance = new CommandManager();
    private CommandManager(){}

    public static CommandManager getCommandManagerInstance() {
        return commandManagerInstance;
    }

    /**
     * Stack for commands history
     */
    public static ArrayList<Command> history = new ArrayList<>();

    Command command;

    /**
     * set command
     * @param command current command
     */
    public void setCommand(Command command){
        this.command = command;
    }

    /**
     * The function, that execute current command
     * @throws ExitToMenuException exception, that discard user to menu
     */
    public void executeCommand() throws ExitToMenuException{
        command.execute();
        history.add(command);
    }

    /**
     * The function, that show command history
     */
    public void showHistory(){
        for (Command i : history){
            OutputManager.stOutput(i.toString());
        }
    }
}
