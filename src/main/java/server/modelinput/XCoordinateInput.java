package server.modelinput;

import server.input.InputManager;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.XCoordinateValidator;

/**
 * The class that is responsible for the x coordinate input
 *
 * @since 1.0
 * @author savadanko
 */
public class XCoordinateInput {
    public static float input() throws ExitToMenuException{
        float x;
        String input;
        OutputManager.stOutput("Enter `x` coordinate or `q` for exit to menu");
        while (true){
            if (InputManager.hasNextLine()){
                input = InputManager.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(XCoordinateValidator.validator(input)){
                    break;
                }
            }
            else {
                InputManager.mode = EInputMode.USER_MODE;
            }
        }
        x = Float.parseFloat(input);
        return x;
    }
}
