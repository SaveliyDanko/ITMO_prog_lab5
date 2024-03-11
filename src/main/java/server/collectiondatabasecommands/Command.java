package server.collectiondatabasecommands;

import server.exceptions.ExitToMenuException;

public interface Command {
    void execute() throws ExitToMenuException;
}
