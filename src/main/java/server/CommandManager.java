package server;

import server.collectiondatabasecommands.Command;
import server.exceptions.ExitToMenuException;

import java.util.Deque;
import java.util.LinkedList;

/**
 * A class that implements the design pattern of the command and
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
    public static Deque<Command> history = new LinkedList<>();

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
    public void executeCommand() throws ExitToMenuException {
        command.execute();
        history.push(command);
    }

    /**
     * The function, that show command history
     */
    public void showHistory(){
        for (Command command : history){
            OutputManager.stOutput(command.toString());
        }
    }
}
