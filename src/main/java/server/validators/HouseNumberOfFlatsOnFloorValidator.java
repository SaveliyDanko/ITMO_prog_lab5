package server.validators;

import server.OutputManager;

/**
 * A class for implementing the House number of flats on floor validator
 */
public class HouseNumberOfFlatsOnFloorValidator {
    public static boolean validator(String numberOfFloors){
        if (numberOfFloors.isEmpty()){
            OutputManager.logError("House numberOfFlatsOnFloor cannot be empty // Enter numberOfFlatsOnFloor or `q` for exit to menu");
            return false;
        }
        try{
            Long.parseLong(numberOfFloors);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The House numberOfFlatsOnFloor must be `long` value // Enter numberOfFlatsOnFloor or `q` for exit to menu");
            return false;
        }
        if (Long.parseLong(numberOfFloors) <= 0){
            OutputManager.logError("The House numberOfFlatsOnFloor must be more than 0 // Enter numberOfFlatsOnFloor or `q` for exit to menu");
            return false;
        }
        return true;
    }
}
