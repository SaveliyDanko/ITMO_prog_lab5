package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the House year validator
 */
public class HouseYearValidator {
    public static boolean validator(String year){
        if (year.isEmpty()){
            OutputManager.logError("House year cannot be empty // Enter y or `q` for exit to menu");
            return false;
        }
        try{
            Long.parseLong(year);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The House year must be `long` value // Enter year or `q` for exit to menu");
            return false;
        }
        if (Long.parseLong(year) <= 0){
            OutputManager.logError("The House year must be more than 0 // Enter year or `q` for exit to menu");
            return false;
        }
        return true;
    }
}
