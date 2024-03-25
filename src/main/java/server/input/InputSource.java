package server.input;

/**
 * An interface that implements classes that are responsible for input
 *
 * @since 1.0
 * @author savadanko
 */
public interface InputSource {

    /**
     * A function that checks if there are lines in the input
     * @return true if subsequent input is present
     */
    boolean hasNextLine();

    /**
     * A function that returns the following input
     * @return string
     */
    String getNextLine();
}
