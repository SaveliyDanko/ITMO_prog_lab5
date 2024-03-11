package server.exceptions;

/**
 * Unknown command exception
 */

public class UnknownCommandException extends Exception{
    public UnknownCommandException(String message){
        super(message);
    }
}
