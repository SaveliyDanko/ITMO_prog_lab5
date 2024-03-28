package server.modelinput;

import server.input.InputManager;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.YCoordinateValidator;

/**
 * The class that is responsible for the y coordinate input
 *
 * @since 1.0
 * @author savadanko
 */
public class YCoordinateInput {
    public static long input() throws ExitToMenuException {
        long y;
        String input;
        OutputManager.stOutput("Enter `y` coordinate or `q` for exit to menu");
        while (true){
            if (InputManager.hasNextLine()){
                input = InputManager.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(YCoordinateValidator.validator(input)){
                    break;
                }
            }
            else {
                InputManager.mode = EInputMode.USER_MODE;
            }
        }
        y = Long.parseLong(input);
        return y;
    }
}
