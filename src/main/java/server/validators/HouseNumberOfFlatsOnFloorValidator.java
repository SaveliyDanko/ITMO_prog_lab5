package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the House number of flats on floor validator
 *
 * @since 1.0
 * @author savadanko
 */
public class HouseNumberOfFlatsOnFloorValidator {
    public static boolean validator(String numberOfFloors){
        if (numberOfFloors.isEmpty()){
            OutputManager.logError("House numberOfFlatsOnFloor cannot be empty");
            return false;
        }
        try{
            Long.parseLong(numberOfFloors);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The House numberOfFlatsOnFloor must be `long` value");
            return false;
        }
        if (Long.parseLong(numberOfFloors) <= 0){
            OutputManager.logError("The House numberOfFlatsOnFloor must be more than 0");
            return false;
        }
        return true;
    }
}
