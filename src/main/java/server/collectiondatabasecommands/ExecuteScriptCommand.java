package server.collectiondatabasecommands;

import client.MessageConstant;
import server.CommandAnalyzer;
import server.ExecuteFiles;
import server.exceptions.ExitToMenuException;
import server.output.OutputManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
            String classLocation = ExecuteScriptCommand.class.getProtectionDomain().getCodeSource().getLocation().toString();
            classLocation = classLocation.substring(5);
            ArrayList<String> array = new ArrayList<>(List.of(classLocation.split(Pattern.quote(File.separator))));
            array.removeLast();
            classLocation = String.join("/", array);
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(classLocation + "/" + args[0]))){
                    if (ExecuteFiles.executeFilesSet.add(args[0])) {
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            CommandAnalyzer.analyze(line);
                        }
                        ExecuteFiles.executeFilesSet.remove(args[0]);
                    }
                    else {
                        OutputManager.logError("To avoid recursion, it is forbidden to call the file used in the script repeatedly");
                    }
                }
                catch (IOException e){
                    OutputManager.logError(e.getMessage());
                    OutputManager.stOutput(MessageConstant.CONSOLE_MESSAGE);
                }
            }
        }
    }
