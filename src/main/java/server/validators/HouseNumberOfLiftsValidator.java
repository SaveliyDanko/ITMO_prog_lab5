package server.validators;

import server.OutputManager;

/**
 * A class for implementing the House number of lifts validator
 */
public class HouseNumberOfLiftsValidator {
    public static boolean validator(String numberOfFloors){
        if (numberOfFloors.isEmpty()){
            OutputManager.logError("House numberOfLifts cannot be empty // Enter numberOfLifts or `q` for exit to menu");
            return false;
        }
        try{
            Long.parseLong(numberOfFloors);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The House numberOfLifts must be `long` value // Enter numberOfLifts or `q` for exit to menu");
            return false;
        }
        if (Long.parseLong(numberOfFloors) <= 0){
            OutputManager.logError("The House numberOfLifts must be more than 0 // Enter numberOfLifts or `q` for exit to menu");
            return false;
        }
        return true;
    }
}
