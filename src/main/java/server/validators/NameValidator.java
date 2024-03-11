package server.validators;

import server.OutputManager;

/**
 * A class for implementing the name validator
 */
public class NameValidator {
    public static boolean validate(String name){
        if (name.isEmpty()){
            OutputManager.logError("Name cannot be empty // Enter `name` or `q` for exit to menu");
            return false;
        }
        else if (name.contains(",")){
            OutputManager.logError("Name cannot contains coma \",\" // Enter `name` or `q` for exit to menu");
            return false;
        }
        else return true;
    }
}
