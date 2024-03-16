package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the price validator
 *
 * @since 1.0
 * @author savadanko
 */

public class FlatPriceValidator {
    public static boolean validator(String price){
        if (price.isEmpty()){
            OutputManager.logError("`price` cannot be empty // Enter x or `q` for exit to menu");
            return false;
        }
        try{
            Float.parseFloat(price);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The `price` must be `float' value // Enter `price` or `q` for exit to menu");
            return false;
        }
        if (Float.parseFloat(price) <= 0){
            OutputManager.logError("The `price` must be more than 0 // Enter `price` or `q` for exit to menu");
            return false;
        }
        return true;
    }
}
