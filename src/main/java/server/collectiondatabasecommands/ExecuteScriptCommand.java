package server.collectiondatabasecommands;

import server.CommandAnalyzer;
import server.ExecuteFiles;
import server.exceptions.ExitToMenuException;
import server.output.OutputManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteScriptCommand implements Command {
    String[] args;

    public ExecuteScriptCommand(String[] args) {
        this.args = args;
    }

    @Override
    public void execute() throws ExitToMenuException {
        if (args.length != 1){
            OutputManager.logError("Invalid file path");
        }
        else {
            if (ExecuteFiles.executeFilesSet.add(args[0])){
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))){
                    String line;
                    while((line = bufferedReader.readLine()) != null){
                        CommandAnalyzer.analyze(line);
                    }
                }
                catch (IOException e){
                    OutputManager.logError(e.getMessage());
                }
            }
            else {
                OutputManager.logError("to avoid recursion, it is forbidden to call the file used in the script repeatedly");
            }
        }
    }
}
