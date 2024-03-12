package server.input;

import java.io.IOException;

/**
 * An interface that implements classes that are responsible for input
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
    String getNextLine() throws IOException;
}
