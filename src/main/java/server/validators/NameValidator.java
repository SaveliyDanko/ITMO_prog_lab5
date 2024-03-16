package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the name validator
 *
 * @since 1.0
 * @author savadanko
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
