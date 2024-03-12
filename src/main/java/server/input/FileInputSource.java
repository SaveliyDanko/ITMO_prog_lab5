package server.input;

import server.output.OutputManager;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * A class that implements input from a script file
 */

public class FileInputSource implements InputSource {

    /**
     * A collection that contains information from a file
     */
    public Deque<String> fileCommands = new LinkedList<>();


    /**
     * A function that fills a collection with lines from a file
     */
    public FileInputSource(File file) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                fileCommands.push(line);
            }
        }
        catch (IOException e){
            OutputManager.logError(e.getMessage());
        }
    }

    /**
     * A function that checks if there are lines in the file that need to be processed
     * @return true, if file is not empty
     */
    @Override
    public boolean hasNextLine() {

        return fileCommands.peekLast() != null;
    }


    /**
     * A function that returns the following line from a file
     * @return string
     */
    @Override
    public String getNextLine() {
        OutputManager.stOutput(fileCommands.peekLast());
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            OutputManager.logError("Приостановка потока была прервана");
            Thread.currentThread().interrupt(); // Восстановление прерванного статуса
        }
        return fileCommands.removeLast();
    }
}
