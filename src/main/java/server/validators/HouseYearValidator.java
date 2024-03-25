package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the House year validator
 *
 * @since 1.0
 * @author savadanko
 */
public class HouseYearValidator {
    public static boolean validator(String year){
        if (year.isEmpty()){
            OutputManager.logError("House year cannot be empty");
            return false;
        }
        try{
            Long.parseLong(year);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The House year must be `long` value");
            return false;
        }
        if (Long.parseLong(year) <= 0){
            OutputManager.logError("The House year must be more than 0");
            return false;
        }
        return true;
    }
}
