package server.validators;

import server.OutputManager;

/**
 * A class for implementing the area validator
 */

public class AreaValidator {
    public static boolean validator(String area){
        if (area.isEmpty()){
            OutputManager.logError("Area cannot be empty // Enter area or `q` for exit to menu");
            return false;
        }
        try{
            Float.parseFloat(area);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The area cannot be a String // Enter area or `q` for exit to menu");
            return false;
        }
        if (Float.parseFloat(area) <= 0){
            OutputManager.logError("The area must be positive // Enter area or `q` for exit to menu");
            return false;
        }
        return true;
    }
}
