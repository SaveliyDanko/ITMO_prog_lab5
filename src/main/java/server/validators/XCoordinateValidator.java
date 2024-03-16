package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the x coordinate validator
 *
 * @since 1.0
 * @author savadanko
 */
public class XCoordinateValidator {
    public static boolean validator(String x){
        if (x.isEmpty()){
            OutputManager.logError("x cannot be empty // Enter x or `q` for exit to menu");
            return false;
        }
        try{
            Float.parseFloat(x);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The x must be `float' value // Enter x or `q` for exit to menu");
            return false;
        }
        if (Float.parseFloat(x) > 155){
            OutputManager.logError("The x must be less than 156 // Enter x or `q` for exit to menu");
            return false;
        }
        return true;
    }
}
