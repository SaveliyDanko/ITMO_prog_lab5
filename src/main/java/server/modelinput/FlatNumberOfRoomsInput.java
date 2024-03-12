package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.FlatNumberOfRoomsValidator;

/**
 * The class that is responsible for the flat numbers of rooms input
 */
public class FlatNumberOfRoomsInput {
    public static Long input() throws ExitToMenuException {
        long numberOfRooms;
        String input;
        OutputManager.stOutput("Enter Flat `numbersOfRoom` or `q` for exit to menu");
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(FlatNumberOfRoomsValidator.validator(input)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        numberOfRooms = Long.parseLong(input);
        return numberOfRooms;
    }
}
