package server.collectiondatabasecommands;

import server.exceptions.ExitToMenuException;

public class ExitCommand implements Command{
    @Override
    public void execute() throws ExitToMenuException {
        System.exit(0);
    }
}
