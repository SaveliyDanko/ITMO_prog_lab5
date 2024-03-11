package server.validators;

import server.OutputManager;

/**
 * A class for implementing the y coordinate validator
 */
public class YCoordinateValidator {
    public static boolean validator(String y){
        if (y.isEmpty()){
            OutputManager.logError("y cannot be empty // Enter y or `q` for exit to menu");
            return false;
        }
        try{
            Long.parseLong(y);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The y must be `long` value // Enter y or `q` for exit to menu");
            return false;
        }
        if (Long.parseLong(y) <= -694){
            OutputManager.logError("The y must be more than -694 // Enter y or `q` for exit to menu");
            return false;
        }
        return true;
    }
}
