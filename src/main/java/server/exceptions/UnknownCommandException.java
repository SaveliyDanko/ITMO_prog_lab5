package server.exceptions;

/**
 * Unknown command exception
 *
 * @since 1.0
 * @author savadanko
 */

public class UnknownCommandException extends Exception{
    public UnknownCommandException(String message){
        super(message);
    }
}
