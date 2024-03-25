package server.collectiondatabasecommands;

import server.exceptions.ExitToMenuException;

/**
 * Common Interface for Commands
 *
 * @since 1.0
 * @author savadanko
 */

public interface Command {
    /**
     * Command method, that realize in all Command classes
     * @throws ExitToMenuException exception, that discard user into menu
     */
    void execute() throws ExitToMenuException;
}
