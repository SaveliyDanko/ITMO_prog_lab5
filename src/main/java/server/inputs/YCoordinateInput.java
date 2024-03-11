package server.inputs;

import server.CurrentInputMode;
import server.EInputMode;
import client.MessageConstant;
import server.OutputManager;
import server.exceptions.ExitToMenuException;
import server.validators.YCoordinateValidator;

/**
 * The class that is responsible for the y coordinate input
 */
public class YCoordinateInput {
    public static long input() throws ExitToMenuException {
        long y;
        String input;
        OutputManager.stOutput("Enter `y` coordinate or `q` for exit to menu");
        while (true){
            if (CurrentInputMode.hasNextLine()){
                input = CurrentInputMode.getNextLine();
                if (input.equals("q")){
                    throw new ExitToMenuException(MessageConstant.EXIT_TO_MENU);
                }
                else if(YCoordinateValidator.validator(input)){
                    break;
                }
            }
            else {
                CurrentInputMode.mode = EInputMode.USER_MODE;
            }
        }
        y = Long.parseLong(input);
        return y;
    }
}
