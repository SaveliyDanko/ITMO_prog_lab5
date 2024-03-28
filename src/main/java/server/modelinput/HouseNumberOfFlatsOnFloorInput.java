package server.modelinput;

import server.input.InputManager;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.HouseNumberOfFlatsOnFloorValidator;

/**
 * The class that is responsible for the House number of flats on floor input
 *
 * @since 1.0
 * @author savadanko
 */
public class HouseNumberOfFlatsOnFloorInput {
    public static Integer input() throws ExitToMenuException {
        int numberOfFlatsOnFloor;
        String input;
        OutputManager.stOutput("Enter House `numberOfFlatsOnFloor` or `q` for exit to menu");
        while (true){
            if (InputManager.hasNextLine()){
                input = InputManager.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(HouseNumberOfFlatsOnFloorValidator.validator(input)){
                    break;
                }
            }
            else {
                InputManager.mode = EInputMode.USER_MODE;
            }
        }
        numberOfFlatsOnFloor = Integer.parseInt(input);
        return numberOfFlatsOnFloor;
    }
}
