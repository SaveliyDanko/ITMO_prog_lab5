package server.modelinput;

import server.input.InputManager;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.AreaValidator;

/**
 * The class that is responsible for the area input
 *
 * @since 1.0
 * @author savadanko
 */

public class AreaInput {
    public static float input() throws ExitToMenuException{
        float area;
        String input;
        OutputManager.stOutput("Enter Flat `area` or `q` for exit to menu");
        while (true){
            if (InputManager.hasNextLine()){
                input = InputManager.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(AreaValidator.validator(input)){
                    break;
                }
            }
            else {
                InputManager.mode = EInputMode.USER_MODE;
            }
        }
        area = Float.parseFloat(input);
        return area;
    }
}
