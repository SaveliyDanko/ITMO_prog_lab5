package server.inputs;

import server.CurrentInputMode;
import server.EInputMode;
import client.MessageConstant;
import server.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.HouseNumberOfFlatsOnFloorValidator;

/**
 * The class that is responsible for the House number of flats on floor input
 */
public class HouseNumberOfFlatsOnFloorInput {
    public static Integer input() throws ExitToMenuException {
        int numberOfFlatsOnFloor;
        String input;
        OutputManager.stOutput("Enter House `numberOfFlatsOnFloor` or `q` for exit to menu");
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(HouseNumberOfFlatsOnFloorValidator.validator(input)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        numberOfFlatsOnFloor = Integer.parseInt(input);
        return numberOfFlatsOnFloor;
    }
}
