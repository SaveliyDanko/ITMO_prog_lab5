package server.validators;

import server.OutputManager;

/**
 * A class for implementing the Flat numbers of rooms validator
 */
public class FlatNumberOfRoomsValidator {
    public static boolean validator(String x){
        if (x.isEmpty()){
            OutputManager.logError("Flat `numberOfRooms` cannot be empty // Enter `numberOfRooms` or `q` for exit to menu");
            return false;
        }
        try{
            Long.parseLong(x);
        }
        catch (NumberFormatException e){
            OutputManager.logError("The Flat `numberOfRooms` must be `long` value // Enter `numberOfRooms` or `q` for exit to menu");
            return false;
        }
        if (Float.parseFloat(x) <= 0){
            OutputManager.logError("The Flat `numberOfRooms` must be more than 0 // Enter `numberOfRooms` or `q` for exit to menu");
            return false;
        }
        return true;
    }
}
