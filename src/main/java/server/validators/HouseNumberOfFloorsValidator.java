package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the House number of floors validator
 *
 * @since 1.0
 * @author savadanko
 */
public class HouseNumberOfFloorsValidator {
    public static boolean validator(String numberOfFloors){
        if (numberOfFloors.isEmpty()){
            OutputManager.logError("House numberOfFloors cannot be empty // Enter numberOfFloors or `q` for exit to menu");
            return false;
        }
        try{
            Long.parseLong(numberOfFloors);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The House numberOfFloors must be `long` value // Enter numberOfFloors or `q` for exit to menu");
            return false;
        }
        if (Long.parseLong(numberOfFloors) <= 0){
            OutputManager.logError("The House numberOfFloors must be more than 0 // Enter numberOfFloors or `q` for exit to menu");
            return false;
        }
        return true;
    }
}
