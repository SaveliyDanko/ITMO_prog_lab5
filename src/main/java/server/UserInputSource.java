package server;

import java.util.Scanner;

/**
 * A class that implements input from user input
 */

public class UserInputSource implements InputSource {
    Scanner console;
    public UserInputSource(){
        console = new Scanner(System.in);
    }

    /**
     * A function that checks if there are lines in the user input
     * @return true, if file is not empty
     */
    @Override
    public boolean hasNextLine() {
        return console.hasNextLine();
    }

    /**
     * A function that returns the following line from user input
     * @return string
     */
    @Override
    public String getNextLine() {
        return console.nextLine().trim();
    }
}
