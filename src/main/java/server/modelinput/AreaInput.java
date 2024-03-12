package server.modelinput;

import server.input.CurrentInputMode;
import server.input.EInputMode;
import client.MessageConstant;
import server.output.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.AreaValidator;

/**
 * The class that is responsible for the area input
 */

public class AreaInput {
    public static float input() throws ExitToMenuException{
        float area;
        String input;
        OutputManager.stOutput("Enter Flat `area` or `q` for exit to menu");
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(AreaValidator.validator(input)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        area = Float.parseFloat(input);
        return area;
    }
}
