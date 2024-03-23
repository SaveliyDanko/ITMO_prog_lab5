package server.validators;

import server.output.OutputManager;

/**
 * A class for implementing the Flat numbers of rooms validator
 *
 * @since 1.0
 * @author savadanko
 */
public class FlatNumberOfRoomsValidator {
    public static boolean validator(String x){
        if (x.isEmpty()){
            OutputManager.logError("Flat `numberOfRooms` cannot be empty");
            return false;
        }
        try{
            Long.parseLong(x);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The Flat `numberOfRooms` must be `long` value");
            return false;
        }
        if (Float.parseFloat(x) <= 0){
            OutputManager.logError("The Flat `numberOfRooms` must be more than 0");
            return false;
        }
        return true;
    }
}
