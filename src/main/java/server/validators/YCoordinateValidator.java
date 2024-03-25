package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the y coordinate validator
 *
 * @since 1.0
 * @author savadanko
 */
public class YCoordinateValidator {
    public static boolean validator(String y){
        if (y.isEmpty()){
            OutputManager.logError("y cannot be empty");
            return false;
        }
        try{
            Long.parseLong(y);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The y must be `long` value");
            return false;
        }
        if (Long.parseLong(y) <= -694){
            OutputManager.logError("The y must be more than -694");
            return false;
        }
        return true;
    }
}
