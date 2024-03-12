package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.XCoordinateValidator;

/**
 * The class that is responsible for the x coordinate input
 */
public class XCoordinateInput {
    public static float input() throws ExitToMenuException{
        float x;
        String input;
        OutputManager.stOutput("Enter `x` coordinate or `q` for exit to menu");
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(XCoordinateValidator.validator(input)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        x = Float.parseFloat(input);
        return x;
    }
}
