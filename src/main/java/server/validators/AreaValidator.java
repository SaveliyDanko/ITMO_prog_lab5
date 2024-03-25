package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the area validator
 *
 * @since 1.0
 * @author savadanko
 */

public class AreaValidator {
    public static boolean validator(String area){
        if (area.isEmpty()){
            OutputManager.logError("Area cannot be empty");
            return false;
        }
        try{
            Float.parseFloat(area);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The area cannot be a String");
            return false;
        }
        if (Float.parseFloat(area) <= 0){
            OutputManager.logError("The area must be positive");
            return false;
        }
        return true;
    }
}
