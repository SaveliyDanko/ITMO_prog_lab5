package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the ID validator
 *
 * @since 1.0
 * @author savadanko
 */
public class IdValidator {
    public static boolean validator(String id){
        if (id.isEmpty()){
            OutputManager.logError("Id cannot be empty // Try again");
        }
        try{
            Long.parseLong(id);
        }
        catch (NumberFormatException e){
            OutputManager.logError("Id must be long // Enter Id or enter `q` for exit to menu");
            return false;
        }
        if (Long.parseLong(id) <= 0){
            OutputManager.logError("The Id must be more than 0 // Enter Id or `q` for exit to menu");
            return false;
        }
        else return true;
    }
}
